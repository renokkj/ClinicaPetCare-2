package clinicavet.dao;

import clinicavet.model.Prontuario;
import java.util.Optional;

public interface ProntuarioDao {
    void inserir(Prontuario prontuario);
    void atualizar(Prontuario prontuario);
    Optional<Prontuario> buscarPorPetId(Long petId);
}
