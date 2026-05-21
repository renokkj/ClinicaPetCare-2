package clinicavet.dao.impl;

import clinicavet.dao.ConnectionFactory;
import clinicavet.dao.PetDao;
import clinicavet.exception.DaoException;
import clinicavet.model.Pet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetDaoMysql implements PetDao {
    @Override
    public Long inserir(Pet pet) {
        String sql = "insert into pet(nome, especie, raca, sexo, cor, data_nascimento, peso, porte, castrado, numero_microchip, alergias, status_vacinal, tutor_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preencher(ps, pet);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getLong(1) : null;
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao inserir pet.", e);
        }
    }

    @Override
    public void atualizar(Pet pet) {
        String sql = "update pet set nome=?, especie=?, raca=?, sexo=?, cor=?, data_nascimento=?, peso=?, porte=?, castrado=?, numero_microchip=?, alergias=?, status_vacinal=?, tutor_id=? where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, pet);
            ps.setLong(14, pet.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao atualizar pet.", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "delete from pet where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao deletar pet.", e);
        }
    }

    @Override
    public Optional<Pet> buscarPorId(Long id) {
        String sql = "select * from pet where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar pet por id.", e);
        }
    }

    @Override
    public List<Pet> listarTodos() {
        String sql = "select * from pet order by nome";
        List<Pet> pets = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pets.add(mapear(rs));
            }
            return pets;
        } catch (SQLException e) {
            throw new DaoException("Erro ao listar pets.", e);
        }
    }

    private void preencher(PreparedStatement ps, Pet pet) throws SQLException {
        ps.setString(1, pet.getNome());
        ps.setString(2, pet.getEspecie());
        ps.setString(3, pet.getRaca());
        ps.setString(4, pet.getSexo());
        ps.setString(5, pet.getCor());
        if (pet.getDataNascimento() != null) {
            ps.setDate(6, Date.valueOf(pet.getDataNascimento()));
        } else {
            ps.setDate(6, null);
        }
        ps.setBigDecimal(7, pet.getPeso());
        ps.setString(8, pet.getPorte());
        ps.setBoolean(9, pet.isCastrado());
        ps.setString(10, pet.getNumeroMicrochip());
        ps.setString(11, pet.getAlergias());
        ps.setString(12, pet.getStatusVacinal());
        ps.setLong(13, pet.getTutorId());
    }

    private Pet mapear(ResultSet rs) throws SQLException {
        Pet pet = new Pet();
        pet.setId(rs.getLong("id"));
        pet.setNome(rs.getString("nome"));
        pet.setEspecie(rs.getString("especie"));
        pet.setRaca(rs.getString("raca"));
        pet.setSexo(rs.getString("sexo"));
        pet.setCor(rs.getString("cor"));
        Date dataNascimento = rs.getDate("data_nascimento");
        pet.setDataNascimento(dataNascimento == null ? null : dataNascimento.toLocalDate());
        pet.setPeso(rs.getBigDecimal("peso"));
        pet.setPorte(rs.getString("porte"));
        pet.setCastrado(rs.getBoolean("castrado"));
        pet.setNumeroMicrochip(rs.getString("numero_microchip"));
        pet.setAlergias(rs.getString("alergias"));
        pet.setStatusVacinal(rs.getString("status_vacinal"));
        pet.setTutorId(rs.getLong("tutor_id"));
        return pet;
    }
}
