package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormNovoPetCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public FormNovoPetCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("tutores", tutorDao.listarTodos());
        request.setAttribute("dataNascimentoFormatada", "");
        return "/WEB-INF/views/pet/form.jsp";
    }
}