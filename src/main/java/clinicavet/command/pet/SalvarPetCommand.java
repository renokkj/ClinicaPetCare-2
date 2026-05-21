package clinicavet.command.pet;

import clinicavet.builder.PetBuilder;
import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.dao.ProntuarioDao;
import clinicavet.service.PetService;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class SalvarPetCommand extends AbstractCommand {
    private final PetDao petDao;
    private final ProntuarioDao prontuarioDao;

    public SalvarPetCommand(PetDao petDao, ProntuarioDao prontuarioDao) {
        this.petDao = petDao;
        this.prontuarioDao = prontuarioDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        BigDecimal peso = RequestUtils.getBigDecimal(request, "peso");

        PetService service = new PetService(petDao, prontuarioDao);
        service.cadastrarComProntuario(
                PetBuilder.novo()
                        .comNome(request.getParameter("nome"))
                        .comEspecie(request.getParameter("especie"))
                        .comRaca(request.getParameter("raca"))
                        .comSexo(request.getParameter("sexo"))
                        .comCor(request.getParameter("cor"))
                        .comDataNascimento(request.getParameter("dataNascimento"))
                        .comPeso(peso)
                        .comPorte(request.getParameter("porte"))
                        .comCastrado(RequestUtils.getBoolean(request, "castrado"))
                        .comNumeroMicrochip(request.getParameter("numeroMicrochip"))
                        .comAlergias(request.getParameter("alergias"))
                        .comStatusVacinal(request.getParameter("statusVacinal"))
                        .comTutorId(RequestUtils.getLong(request, "tutorId"))
                        .construir()
        );

        success(request, "Pet cadastrado com prontuário automático.");
        return redirect("/app?entidade=pet&acao=listar");
    }
}
