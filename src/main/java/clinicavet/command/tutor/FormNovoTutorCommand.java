package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormNovoTutorCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/tutor/form.jsp";
    }
}
