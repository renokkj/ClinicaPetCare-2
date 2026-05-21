package clinicavet.model;

import java.time.LocalDateTime;

public class Prontuario {
    private Long id;
    private Long petId;
    private String historicoClinico;
    private String medicacaoContinua;
    private String restricoesAlimentares;
    private String nivelPrioridade;
    private LocalDateTime ultimaAtualizacao;

    public Prontuario() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPetId() { return petId; }
    public void setPetId(Long petId) { this.petId = petId; }
    public String getHistoricoClinico() { return historicoClinico; }
    public void setHistoricoClinico(String historicoClinico) { this.historicoClinico = historicoClinico; }
    public String getMedicacaoContinua() { return medicacaoContinua; }
    public void setMedicacaoContinua(String medicacaoContinua) { this.medicacaoContinua = medicacaoContinua; }
    public String getRestricoesAlimentares() { return restricoesAlimentares; }
    public void setRestricoesAlimentares(String restricoesAlimentares) { this.restricoesAlimentares = restricoesAlimentares; }
    public String getNivelPrioridade() { return nivelPrioridade; }
    public void setNivelPrioridade(String nivelPrioridade) { this.nivelPrioridade = nivelPrioridade; }
    public LocalDateTime getUltimaAtualizacao() { return ultimaAtualizacao; }
    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) { this.ultimaAtualizacao = ultimaAtualizacao; }
}
