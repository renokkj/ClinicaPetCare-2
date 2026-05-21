package clinicavet.decorator;

public class VacinacaoDecorator extends AtendimentoDecorator {

    public VacinacaoDecorator(Atendimento atendimento) {
        super(atendimento);
    }

    @Override
    public String getDescricao() {
        return atendimento.getDescricao() + " + Vacinacao";
    }

    @Override
    public double getCusto() {
        return atendimento.getCusto() + 50.0;
    }
}
