package clinicavet.controller;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
@WebServlet("/login")
public class LoginController extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);} 
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {String email=req.getParameter("email"); String senha=req.getParameter("senha"); if("admin@clinicavet.com".equals(email) && "123456".equals(senha)){ HttpSession session=req.getSession(); session.setAttribute("usuarioLogado", email); resp.sendRedirect(req.getContextPath()+"/app?entidade=home&acao=index"); } else { req.setAttribute("erro", "Login inválido"); req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);} }
}
