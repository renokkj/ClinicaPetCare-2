package clinicavet.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoDecoratorTest {

    @Test
    public void deveAdicionarExameEVacinacao() {

        Atendimento atendimento =
                new ConsultaBasica(100.0);

        atendimento =
                new ExameDecorator(atendimento);

        atendimento =
                new VacinacaoDecorator(atendimento);

        assertEquals(
                "Consulta Veterinária + Exames + Vacinação",
                atendimento.getDescricao()
        );

        assertEquals(
                270.0,
                atendimento.getCusto()
        );
    }
}
