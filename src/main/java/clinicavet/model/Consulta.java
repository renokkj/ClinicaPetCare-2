package clinicavet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Consulta {
    private Long id;
    private Long petId;
    private LocalDateTime dataConsulta;
    private String tipoConsulta;
    private String statusConsulta;
    private String observacoes;
    private BigDecimal valor;

    public Consulta() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPetId() { return petId; }
    public void setPetId(Long petId) { this.petId = petId; }
    public LocalDateTime getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(LocalDateTime dataConsulta) { this.dataConsulta = dataConsulta; }
    public String getTipoConsulta() { return tipoConsulta; }
    public void setTipoConsulta(String tipoConsulta) { this.tipoConsulta = tipoConsulta; }
    public String getStatusConsulta() { return statusConsulta; }
    public void setStatusConsulta(String statusConsulta) { this.statusConsulta = statusConsulta; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}
