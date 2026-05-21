package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.model.Consulta;
import clinicavet.service.ConsultaService;
import clinicavet.util.DateUtils;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AtualizarConsultaCommand extends AbstractCommand {
    private final ConsultaDao consultaDao;

    public AtualizarConsultaCommand(ConsultaDao consultaDao) {
        this.consultaDao = consultaDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Consulta consulta = new Consulta();
        consulta.setId(RequestUtils.getLong(request, "id"));
        consulta.setPetId(RequestUtils.getLong(request, "petId"));
        consulta.setDataConsulta(DateUtils.parseDateTime(request.getParameter("dataConsulta")));
        consulta.setTipoConsulta(request.getParameter("tipoConsulta"));
        consulta.setStatusConsulta(request.getParameter("statusConsulta"));
        consulta.setObservacoes(request.getParameter("observacoes"));
        consulta.setValor(RequestUtils.getBigDecimal(request, "valor"));

        new ConsultaService(consultaDao).salvar(consulta);

        success(request, "Consulta atualizada com sucesso.");
        return redirect("/app?entidade=consulta&acao=listar");
    }
}