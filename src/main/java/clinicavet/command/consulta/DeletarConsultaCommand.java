package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletarConsultaCommand extends AbstractCommand {
    private final ConsultaDao consultaDao;

    public DeletarConsultaCommand(ConsultaDao consultaDao) {
        this.consultaDao = consultaDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        consultaDao.deletar(RequestUtils.getLong(request, "id"));
        success(request, "Consulta removida com sucesso.");
        return redirect("/app?entidade=consulta&acao=listar");
    }
}