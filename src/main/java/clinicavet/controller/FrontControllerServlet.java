package clinicavet.controller;

import clinicavet.command.ICommand;
import clinicavet.factory.CommandFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app")
public class FrontControllerServlet extends HttpServlet {
    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        removerFlashAnterior(request);

        String entidade = parametroOuPadrao(request.getParameter("entidade"), "home");
        String acao = parametroOuPadrao(request.getParameter("acao"), "index");

        try {
            ICommand command = commandFactory.create(entidade, acao);
            String view = command.execute(request, response);
            navegar(request, response, view);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(request, response);
        }
    }

    private void navegar(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        if (view == null || response.isCommitted()) {
            return;
        }
        if (view.startsWith("redirect:")) {
            response.sendRedirect(request.getContextPath() + view.substring(9));
            return;
        }
        request.getRequestDispatcher(view).forward(request, response);
    }

    private String parametroOuPadrao(String value, String defaultValue) {
        return value == null || value.isBlank() ? defaultValue : value;
    }

    private void removerFlashAnterior(HttpServletRequest request) {
        Object flash = request.getSession().getAttribute("flashSuccess");
        if (flash != null) {
            request.setAttribute("flashSuccess", flash);
            request.getSession().removeAttribute("flashSuccess");
        }
    }
}
