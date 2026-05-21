package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarConsultaCommand extends AbstractCommand {
    private final ConsultaDao consultaDao;
    private final PetDao petDao;

    public ListarConsultaCommand(ConsultaDao consultaDao, PetDao petDao) {
        this.consultaDao = consultaDao;
        this.petDao = petDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("consultas", consultaDao.listarTodos());
        request.setAttribute("pets", petDao.listarTodos());
        return "/WEB-INF/views/consulta/list.jsp";
    }
}
