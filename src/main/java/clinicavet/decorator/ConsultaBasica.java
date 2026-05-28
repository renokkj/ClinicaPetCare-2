package clinicavet.decorator;

public class ConsultaBasica implements Atendimento {

    private double valorBase;

    public ConsultaBasica(double valorBase) {
        this.valorBase = valorBase;
    }

    @Override
    public String getDescricao() {
        return "Consulta Veterinária";
    }

    @Override
    public double getCusto() {
        return valorBase;
    }
}