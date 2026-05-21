package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import clinicavet.model.Tutor;
import clinicavet.util.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AtualizarTutorCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public AtualizarTutorCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Tutor tutor = new Tutor();
        tutor.setId(RequestUtils.getLong(request, "id"));
        tutor.setNomeCompleto(request.getParameter("nomeCompleto"));
        tutor.setCpf(request.getParameter("cpf"));
        tutor.setTelefone(request.getParameter("telefone"));
        tutor.setEmail(request.getParameter("email"));
        tutor.setEndereco(request.getParameter("endereco"));
        tutor.setCidade(request.getParameter("cidade"));
        tutor.setObservacoes(request.getParameter("observacoes"));
        tutorDao.atualizar(tutor);
        success(request, "Tutor atualizado com sucesso.");
        return redirect("/app?entidade=tutor&acao=listar");
    }
}