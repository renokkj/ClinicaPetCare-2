package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeletarTutorCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public DeletarTutorCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        tutorDao.deletar(RequestUtils.getLong(request, "id"));
        success(request, "Tutor removido com sucesso.");
        return redirect("/app?entidade=tutor&acao=listar");
    }
}
