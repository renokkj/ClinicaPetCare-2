package clinicavet.service.triagem;

import clinicavet.model.Pet;

public class RegraPetFilhote implements RegraDeTriagem {
    @Override
    public boolean aceita(Pet pet) {
        return pet.idadeEmAnos() < 1;
    }

    @Override
    public String prioridade() {
        return "MÉDIA";
    }
}
