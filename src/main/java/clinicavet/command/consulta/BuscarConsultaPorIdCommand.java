package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarConsultaPorIdCommand extends AbstractCommand {
    private final ConsultaDao consultaDao;
    private final PetDao petDao;

    public BuscarConsultaPorIdCommand(ConsultaDao consultaDao, PetDao petDao) {
        this.consultaDao = consultaDao;
        this.petDao = petDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("consulta", consultaDao.buscarPorId(RequestUtils.getLong(request, "id")).orElseThrow());
        request.setAttribute("pets", petDao.listarTodos());
        return "/WEB-INF/views/consulta/detail.jsp";
    }
}