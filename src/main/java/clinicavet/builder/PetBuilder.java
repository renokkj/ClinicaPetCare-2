package clinicavet.builder;

import clinicavet.exception.ValidationException;
import clinicavet.model.Pet;
import clinicavet.util.DateUtils;
import java.math.BigDecimal;

public class PetBuilder {
    private final Pet pet;

    private PetBuilder() {
        this.pet = new Pet();
    }

    public static PetBuilder novo() {
        return new PetBuilder();
    }

    public PetBuilder comId(Long id) {
        pet.setId(id);
        return this;
    }

    public PetBuilder comNome(String nome) {
        pet.setNome(nome);
        return this;
    }

    public PetBuilder comEspecie(String especie) {
        pet.setEspecie(especie);
        return this;
    }

    public PetBuilder comRaca(String raca) {
        pet.setRaca(raca);
        return this;
    }

    public PetBuilder comSexo(String sexo) {
        pet.setSexo(sexo);
        return this;
    }

    public PetBuilder comCor(String cor) {
        pet.setCor(cor);
        return this;
    }

    public PetBuilder comDataNascimento(String dataNascimento) {
        pet.setDataNascimento(DateUtils.parseDate(dataNascimento));
        return this;
    }

    public PetBuilder comPeso(BigDecimal peso) {
        pet.setPeso(peso);
        return this;
    }

    public PetBuilder comPorte(String porte) {
        pet.setPorte(porte);
        return this;
    }

    public PetBuilder comCastrado(boolean castrado) {
        pet.setCastrado(castrado);
        return this;
    }

    public PetBuilder comNumeroMicrochip(String numeroMicrochip) {
        pet.setNumeroMicrochip(numeroMicrochip);
        return this;
    }

    public PetBuilder comAlergias(String alergias) {
        pet.setAlergias(alergias);
        return this;
    }

    public PetBuilder comStatusVacinal(String statusVacinal) {
        pet.setStatusVacinal(statusVacinal);
        return this;
    }

    public PetBuilder comTutorId(Long tutorId) {
        pet.setTutorId(tutorId);
        return this;
    }

    public Pet construir() {
        validarObrigatorios();
        return pet;
    }

    private void validarObrigatorios() {
        if (pet.getNome() == null || pet.getNome().isBlank()) {
            throw new ValidationException("O nome do pet é obrigatório.");
        }
        if (pet.getEspecie() == null || pet.getEspecie().isBlank()) {
            throw new ValidationException("A espécie do pet é obrigatória.");
        }
        if (pet.getTutorId() == null) {
            throw new ValidationException("Selecione um tutor para o pet.");
        }
    }
}