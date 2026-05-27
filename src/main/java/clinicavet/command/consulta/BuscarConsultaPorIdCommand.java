package clinicavet.command.consulta;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;

import clinicavet.decorator.Atendimento;
import clinicavet.decorator.ConsultaBasica;
import clinicavet.decorator.ExameDecorator;
import clinicavet.decorator.VacinacaoDecorator;

import clinicavet.model.Consulta;
import clinicavet.util.RequestUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BuscarConsultaPorIdCommand extends AbstractCommand {

    private final ConsultaDao consultaDao;
    private final PetDao petDao;

    public BuscarConsultaPorIdCommand(
            ConsultaDao consultaDao,
            PetDao petDao) {

        this.consultaDao = consultaDao;
        this.petDao = petDao;
    }

    @Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) {

        Consulta consulta = consultaDao
                .buscarPorId(
                        RequestUtils.getLong(request, "id")
                )
                .orElseThrow();

        request.setAttribute("consulta", consulta);

        request.setAttribute(
                "pets",
                petDao.listarTodos()
        );

        // DECORATOR
        Atendimento atendimento =
                new ConsultaBasica();

        atendimento =
                new ExameDecorator(atendimento);

        atendimento =
                new VacinacaoDecorator(atendimento);

        request.setAttribute(
                "descricaoAtendimento",
                atendimento.getDescricao()
        );

        request.setAttribute(
                "custoAtendimento",
                atendimento.getCusto()
        );

        return "/WEB-INF/views/consulta/detail.jsp";
    }
}