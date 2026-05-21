package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormNovaConsultaCommand extends AbstractCommand {
    private final PetDao petDao;

    public FormNovaConsultaCommand(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pets", petDao.listarTodos());
        request.setAttribute("dataConsultaFormatada", "");
        return "/WEB-INF/views/consulta/form.jsp";
    }
}
