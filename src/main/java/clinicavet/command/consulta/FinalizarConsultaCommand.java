package clinicavet.command.consulta;

import clinicavet.command.ICommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.model.Consulta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FinalizarConsultaCommand implements ICommand {

    private final ConsultaDao consultaDao;

    public FinalizarConsultaCommand(ConsultaDao consultaDao) {
        this.consultaDao = consultaDao;
    }

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {

        Long id = Long.valueOf(request.getParameter("id"));

        Consulta consulta = consultaDao.buscarPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Consulta não encontrada."));

        consulta.setStatusConsulta("FINALIZADA");

        consultaDao.atualizar(consulta);

        request.getSession().setAttribute(
                "flashSuccess",
                "Consulta finalizada com sucesso!"
        );

        return "redirect:/app?entidade=consulta&acao=listar";
    }
}