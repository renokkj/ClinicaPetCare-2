package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarTutorCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public ListarTutorCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("tutores", tutorDao.listarTodos());
        return "/WEB-INF/views/tutor/list.jsp";
    }
}