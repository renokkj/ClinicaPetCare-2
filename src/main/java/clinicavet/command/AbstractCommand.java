package clinicavet.command;

import jakarta.servlet.http.HttpServletRequest;

public abstract class AbstractCommand implements ICommand {
    protected String redirect(String path) {
        return "redirect:" + path;
    }

    protected void success(HttpServletRequest request, String message) {
        request.getSession().setAttribute("flashSuccess", message);
    }

    protected void error(HttpServletRequest request, String message) {
        request.setAttribute("errorMessage", message);
    }
}
