package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.dao.ProntuarioDao;
import clinicavet.dao.TutorDao;
import clinicavet.util.DateUtils;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarPetPorIdCommand extends AbstractCommand {
    private final PetDao petDao;
    private final ProntuarioDao prontuarioDao;
    private final TutorDao tutorDao;

    public BuscarPetPorIdCommand(PetDao petDao, ProntuarioDao prontuarioDao, TutorDao tutorDao) {
        this.petDao = petDao;
        this.prontuarioDao = prontuarioDao;
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = RequestUtils.getLong(request, "id");

        var pet = petDao.buscarPorId(id).orElseThrow();
        request.setAttribute("pet", pet);
        request.setAttribute("prontuario", prontuarioDao.buscarPorPetId(id).orElse(null));
        request.setAttribute("tutores", tutorDao.listarTodos());
        request.setAttribute("dataNascimentoFormatada", DateUtils.formatDate(pet.getDataNascimento()));

        return "/WEB-INF/views/pet/detail.jsp";
    }
}