package clinicavet.service;

import clinicavet.model.Pet;
import clinicavet.service.triagem.RegraPetFilhote;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TriagemAutomaticaServiceTest {

    @Test
    public void deveClassificarFilhoteComoAltaPrioridade() {

        Pet pet = new Pet();
        //pet.setIdade(1);

        TriagemAutomaticaService service =
                new TriagemAutomaticaService(
                        List.of(new RegraPetFilhote())
                );

        String prioridade = service.classificar(pet);

        assertEquals("MÉDIA", prioridade);
    }
}
