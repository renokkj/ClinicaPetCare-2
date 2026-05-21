package clinicavet.dao;

import clinicavet.model.Pet;
import java.util.List;
import java.util.Optional;

public interface PetDao {
    Long inserir(Pet pet);
    void atualizar(Pet pet);
    void deletar(Long id);
    Optional<Pet> buscarPorId(Long id);
    List<Pet> listarTodos();
}
