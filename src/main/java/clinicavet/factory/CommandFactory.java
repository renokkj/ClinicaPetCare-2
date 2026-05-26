package clinicavet.factory;

import clinicavet.command.ICommand;
import clinicavet.command.consulta.AtualizarConsultaCommand;
import clinicavet.command.consulta.BuscarConsultaPorIdCommand;
import clinicavet.command.consulta.DeletarConsultaCommand;
import clinicavet.command.consulta.EditarConsultaCommand;
import clinicavet.command.consulta.FormNovaConsultaCommand;
import clinicavet.command.consulta.ListarConsultaCommand;
import clinicavet.command.consulta.SalvarConsultaCommand;
import clinicavet.command.home.IndexHomeCommand;
import clinicavet.command.pet.AtualizarPetCommand;
import clinicavet.command.pet.AutomatizarTriagemPetCommand;
import clinicavet.command.pet.BuscarPetPorIdCommand;
import clinicavet.command.pet.DeletarPetCommand;
import clinicavet.command.pet.EditarPetCommand;
import clinicavet.command.pet.FormNovoPetCommand;
import clinicavet.command.pet.ListarPetCommand;
import clinicavet.command.pet.SalvarPetCommand;
import clinicavet.command.tutor.AtualizarTutorCommand;
import clinicavet.command.tutor.BuscarTutorPorIdCommand;
import clinicavet.command.tutor.DeletarTutorCommand;
import clinicavet.command.tutor.EditarTutorCommand;
import clinicavet.command.tutor.FormNovoTutorCommand;
import clinicavet.command.tutor.ListarTutorCommand;
import clinicavet.command.tutor.SalvarTutorCommand;
import clinicavet.dao.ConsultaDao;
import clinicavet.dao.PetDao;
import clinicavet.dao.ProntuarioDao;
import clinicavet.dao.TutorDao;
import clinicavet.dao.impl.ConsultaDaoMysql;
import clinicavet.dao.impl.PetDaoMysql;
import clinicavet.dao.impl.ProntuarioDaoMysql;
import clinicavet.dao.impl.TutorDaoMysql;
import clinicavet.command.consulta.FinalizarConsultaCommand;

public class CommandFactory {

    private final TutorDao tutorDao = new TutorDaoMysql();
    private final PetDao petDao = new PetDaoMysql();
    private final ProntuarioDao prontuarioDao = new ProntuarioDaoMysql();
    private final ConsultaDao consultaDao = new ConsultaDaoMysql();

    public ICommand create(String entidade, String acao) {
        switch (entidade + ":" + acao) {
            case "home:index":
                return new IndexHomeCommand();

            case "tutor:listar":
                return new ListarTutorCommand(tutorDao);
            case "tutor:formNovo":
                return new FormNovoTutorCommand();
            case "tutor:salvar":
                return new SalvarTutorCommand(tutorDao);
            case "tutor:buscarPorId":
                return new BuscarTutorPorIdCommand(tutorDao);
            case "tutor:editar":
                return new EditarTutorCommand(tutorDao);
            case "tutor:atualizar":
                return new AtualizarTutorCommand(tutorDao);
            case "tutor:deletar":
                return new DeletarTutorCommand(tutorDao);

            case "pet:listar":
                return new ListarPetCommand(petDao, tutorDao);
            case "pet:formNovo":
                return new FormNovoPetCommand(tutorDao);
            case "pet:salvar":
                return new SalvarPetCommand(petDao, prontuarioDao);
            case "pet:buscarPorId":
                return new BuscarPetPorIdCommand(petDao, prontuarioDao, tutorDao);
            case "pet:editar":
                return new EditarPetCommand(petDao, tutorDao);
            case "pet:atualizar":
                return new AtualizarPetCommand(petDao, prontuarioDao);
            case "pet:deletar":
                return new DeletarPetCommand(petDao);
            case "pet:automatizarTriagem":
                return new AutomatizarTriagemPetCommand(petDao, prontuarioDao);

            case "consulta:listar":
                return new ListarConsultaCommand(consultaDao, petDao);
            case "consulta:formNovo":
                return new FormNovaConsultaCommand(petDao);
            case "consulta:salvar":
                return new SalvarConsultaCommand(consultaDao);
            case "consulta:buscarPorId":
                return new BuscarConsultaPorIdCommand(consultaDao, petDao);
            case "consulta:editar":
                return new EditarConsultaCommand(consultaDao, petDao);
            case "consulta:atualizar":
                return new AtualizarConsultaCommand(consultaDao);
            case "consulta:finalizar":
                return new FinalizarConsultaCommand(consultaDao);
            case "consulta:deletar":
                return new DeletarConsultaCommand(consultaDao);

            default:
                throw new IllegalArgumentException("Comando não encontrado para: " + entidade + "/" + acao);
        }
    }
}