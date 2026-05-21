package clinicavet.dao;

import clinicavet.model.Tutor;
import java.util.List;
import java.util.Optional;

public interface TutorDao {
    void inserir(Tutor tutor);
    void atualizar(Tutor tutor);
    void deletar(Long id);
    Optional<Tutor> buscarPorId(Long id);
    List<Tutor> listarTodos();
}
