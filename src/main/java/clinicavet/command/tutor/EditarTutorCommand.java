package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarTutorCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public EditarTutorCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = RequestUtils.getLong(request, "id");
        request.setAttribute("tutor", tutorDao.buscarPorId(id).orElseThrow());
        return "/WEB-INF/views/tutor/form.jsp";
    }
}
