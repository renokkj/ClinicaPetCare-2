package clinicavet.command.pet;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.PetDao;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletarPetCommand extends AbstractCommand {
    private final PetDao petDao;

    public DeletarPetCommand(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        petDao.deletar(RequestUtils.getLong(request, "id"));
        success(request, "Pet removido com sucesso.");
        return redirect("/app?entidade=pet&acao=listar");
    }
}
