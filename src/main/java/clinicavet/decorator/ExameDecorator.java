package clinicavet.decorator;

public class ExameDecorator extends AtendimentoDecorator {

    public ExameDecorator(Atendimento atendimento) {
        super(atendimento);
    }

    @Override
    public String getDescricao() {
        return atendimento.getDescricao() + " + Exames";
    }

    @Override
    public double getCusto() {
        return atendimento.getCusto() + 120.0;
    }
}
