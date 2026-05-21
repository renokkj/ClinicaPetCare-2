package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.dao.ProntuarioDao;
import clinicavet.service.PetService;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutomatizarTriagemPetCommand extends AbstractCommand {
    private final PetDao petDao;
    private final ProntuarioDao prontuarioDao;

    public AutomatizarTriagemPetCommand(PetDao petDao, ProntuarioDao prontuarioDao) {
        this.petDao = petDao;
        this.prontuarioDao = prontuarioDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        new PetService(petDao, prontuarioDao).automatizarTriagem(RequestUtils.getLong(request, "id"));
        success(request, "Triagem automática executada com sucesso.");
        return redirect("/app?entidade=pet&acao=listar");
    }
}