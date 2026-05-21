package clinicavet.decorator;

public class ConsultaBasica implements Atendimento {

    @Override
    public String getDescricao() {
        return "Consulta Veterinaria";
    }

    @Override
    public double getCusto() {
        return 100.0;
    }
}
