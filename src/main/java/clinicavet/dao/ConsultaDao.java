package clinicavet.dao;

import clinicavet.model.Consulta;
import java.util.List;
import java.util.Optional;

public interface ConsultaDao {
    void inserir(Consulta consulta);
    void atualizar(Consulta consulta);
    void deletar(Long id);
    Optional<Consulta> buscarPorId(Long id);
    List<Consulta> listarTodos();
    List<Consulta> listarPorPet(Long petId);
}
