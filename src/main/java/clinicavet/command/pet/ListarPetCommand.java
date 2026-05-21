package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.dao.TutorDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarPetCommand extends AbstractCommand {
    private final PetDao petDao;
    private final TutorDao tutorDao;

    public ListarPetCommand(PetDao petDao, TutorDao tutorDao) {
        this.petDao = petDao;
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pets", petDao.listarTodos());
        request.setAttribute("tutores", tutorDao.listarTodos());
        return "/WEB-INF/views/pet/list.jsp";
    }
}
