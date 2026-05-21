package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.dao.TutorDao;
import clinicavet.util.DateUtils;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarPetCommand extends AbstractCommand {
    private final PetDao petDao;
    private final TutorDao tutorDao;

    public EditarPetCommand(PetDao petDao, TutorDao tutorDao) {
        this.petDao = petDao;
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var pet = petDao.buscarPorId(RequestUtils.getLong(request, "id")).orElseThrow();
        request.setAttribute("pet", pet);
        request.setAttribute("tutores", tutorDao.listarTodos());
        request.setAttribute("dataNascimentoFormatada", DateUtils.formatDate(pet.getDataNascimento()));
        return "/WEB-INF/views/pet/form.jsp";
    }
}