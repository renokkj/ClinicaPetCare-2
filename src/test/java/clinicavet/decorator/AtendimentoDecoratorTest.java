package clinicavet.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoDecoratorTest {

    @Test
    public void deveAdicionarExameEVacinacao() {

        Atendimento atendimento =
                new ConsultaBasica();

        atendimento =
                new ExameDecorator(atendimento);

        atendimento =
                new VacinacaoDecorator(atendimento);

        assertEquals(
                "Consulta Veterinaria + Exames + Vacinacao",
                atendimento.getDescricao()
        );

        assertEquals(
                270.0,
                atendimento.getCusto()
        );
    }
}
