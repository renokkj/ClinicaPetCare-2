package clinicavet.command.tutor;

import clinicavet.command.AbstractCommand;
import clinicavet.dao.TutorDao;
import clinicavet.model.Tutor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalvarTutorCommand extends AbstractCommand {
    private final TutorDao tutorDao;

    public SalvarTutorCommand(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Tutor tutor = new Tutor();
        tutor.setNomeCompleto(request.getParameter("nomeCompleto"));
        tutor.setCpf(request.getParameter("cpf"));
        tutor.setTelefone(request.getParameter("telefone"));
        tutor.setEmail(request.getParameter("email"));
        tutor.setEndereco(request.getParameter("endereco"));
        tutor.setCidade(request.getParameter("cidade"));
        tutor.setObservacoes(request.getParameter("observacoes"));
        tutorDao.inserir(tutor);
        success(request, "Tutor cadastrado com sucesso.");
        return redirect("/app?entidade=tutor&acao=listar");
    }
}