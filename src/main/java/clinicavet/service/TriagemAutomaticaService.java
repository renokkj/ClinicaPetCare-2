package clinicavet.service;

import clinicavet.model.Pet;
import clinicavet.service.triagem.RegraDeTriagem;
import java.util.List;

public class TriagemAutomaticaService {
    private final List<RegraDeTriagem> regras;

    public TriagemAutomaticaService(List<RegraDeTriagem> regras) {
        this.regras = regras;
    }

    public String classificar(Pet pet) {
        for (RegraDeTriagem regra : regras) {
            if (regra.aceita(pet)) {
                return regra.prioridade();
            }
        }
        return "NORMAL";
    }
}
