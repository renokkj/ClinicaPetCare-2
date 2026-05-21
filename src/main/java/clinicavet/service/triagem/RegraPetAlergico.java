package clinicavet.service.triagem;

import clinicavet.model.Pet;

public class RegraPetAlergico implements RegraDeTriagem {
    @Override
    public boolean aceita(Pet pet) {
        return pet.possuiAlergias();
    }

    @Override
    public String prioridade() {
        return "ALTA";
    }
}
