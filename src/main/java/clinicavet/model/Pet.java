package clinicavet.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Pet {
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private String sexo;
    private String cor;
    private LocalDate dataNascimento;
    private BigDecimal peso;
    private String porte;
    private boolean castrado;
    private String numeroMicrochip;
    private String alergias;
    private String statusVacinal;
    private Long tutorId;

    public Pet() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public BigDecimal getPeso() { return peso; }
    public void setPeso(BigDecimal peso) { this.peso = peso; }
    public String getPorte() { return porte; }
    public void setPorte(String porte) { this.porte = porte; }
    public boolean isCastrado() { return castrado; }
    public void setCastrado(boolean castrado) { this.castrado = castrado; }
    public String getNumeroMicrochip() { return numeroMicrochip; }
    public void setNumeroMicrochip(String numeroMicrochip) { this.numeroMicrochip = numeroMicrochip; }
    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }
    public String getStatusVacinal() { return statusVacinal; }
    public void setStatusVacinal(String statusVacinal) { this.statusVacinal = statusVacinal; }
    public Long getTutorId() { return tutorId; }
    public void setTutorId(Long tutorId) { this.tutorId = tutorId; }

    public int idadeEmAnos() {
        if (dataNascimento == null) {
            return 0;
        }
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public boolean possuiAlergias() {
        return alergias != null && !alergias.isBlank();
    }
}
