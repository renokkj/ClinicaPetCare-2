package clinicavet.service.triagem;

import clinicavet.model.Pet;

public class RegraPetIdoso implements RegraDeTriagem {
    @Override
    public boolean aceita(Pet pet) {
        return pet.idadeEmAnos() >= 8;
    }

    @Override
    public String prioridade() {
        return "ALTA";
    }
}
