package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;
import clinicavet.util.DateUtils;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarConsultaCommand extends AbstractCommand {
    private final ConsultaDao consultaDao;
    private final PetDao petDao;

    public EditarConsultaCommand(ConsultaDao consultaDao, PetDao petDao) {
        this.consultaDao = consultaDao;
        this.petDao = petDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var consulta = consultaDao.buscarPorId(RequestUtils.getLong(request, "id")).orElseThrow();
        request.setAttribute("consulta", consulta);
        request.setAttribute("pets", petDao.listarTodos());
        request.setAttribute("dataConsultaFormatada", DateUtils.formatDateTime(consulta.getDataConsulta()));
        return "/WEB-INF/views/consulta/form.jsp";
    }
}