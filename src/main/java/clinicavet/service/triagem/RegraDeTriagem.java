package clinicavet.service.triagem;

import clinicavet.model.Pet;

public interface RegraDeTriagem {
    boolean aceita(Pet pet);
    String prioridade();
}
