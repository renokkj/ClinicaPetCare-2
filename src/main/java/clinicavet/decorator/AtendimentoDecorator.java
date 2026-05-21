package clinicavet.decorator;

public abstract class AtendimentoDecorator implements Atendimento {

    protected Atendimento atendimento;

    public AtendimentoDecorator(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
}
