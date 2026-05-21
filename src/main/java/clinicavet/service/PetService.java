package clinicavet.service;

import clinicavet.dao.PetDao;
import clinicavet.dao.ProntuarioDao;
import clinicavet.model.Pet;
import clinicavet.model.Prontuario;
import clinicavet.service.triagem.RegraPetAlergico;
import clinicavet.service.triagem.RegraPetFilhote;
import clinicavet.service.triagem.RegraPetIdoso;
import java.time.LocalDateTime;
import java.util.List;

public class PetService {
    private final PetDao petDao;
    private final ProntuarioDao prontuarioDao;
    private final TriagemAutomaticaService triagemService;

    public PetService(PetDao petDao, ProntuarioDao prontuarioDao) {
        this.petDao = petDao;
        this.prontuarioDao = prontuarioDao;
        this.triagemService = new TriagemAutomaticaService(List.of(
                new RegraPetAlergico(),
                new RegraPetIdoso(),
                new RegraPetFilhote()
        ));
    }

    public Long cadastrarComProntuario(Pet pet) {
        Long id = petDao.inserir(pet);
        Prontuario prontuario = new Prontuario();
        prontuario.setPetId(id);
        prontuario.setHistoricoClinico("Prontuário criado automaticamente.");
        prontuario.setMedicacaoContinua("Não informada");
        prontuario.setRestricoesAlimentares("Não informada");
        prontuario.setNivelPrioridade(triagemService.classificar(pet));
        prontuario.setUltimaAtualizacao(LocalDateTime.now());
        prontuarioDao.inserir(prontuario);
        return id;
    }

    public void atualizar(Pet pet) {
        petDao.atualizar(pet);
        automatizarTriagem(pet.getId());
    }

    public void automatizarTriagem(Long petId) {
        Pet pet = petDao.buscarPorId(petId).orElseThrow();
        Prontuario prontuario = prontuarioDao.buscarPorPetId(petId).orElseGet(Prontuario::new);
        prontuario.setPetId(petId);
        prontuario.setHistoricoClinico(valorOuPadrao(prontuario.getHistoricoClinico(), "Prontuário criado automaticamente."));
        prontuario.setMedicacaoContinua(valorOuPadrao(prontuario.getMedicacaoContinua(), "Não informada"));
        prontuario.setRestricoesAlimentares(valorOuPadrao(prontuario.getRestricoesAlimentares(), "Não informada"));
        prontuario.setNivelPrioridade(triagemService.classificar(pet));
        prontuario.setUltimaAtualizacao(LocalDateTime.now());

        if (prontuario.getId() == null) {
            prontuarioDao.inserir(prontuario);
            return;
        }
        prontuarioDao.atualizar(prontuario);
    }

    private String valorOuPadrao(String valor, String padrao) {
        return valor == null || valor.isBlank() ? padrao : valor;
    }
}
