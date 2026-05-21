package clinicavet.dao.impl;

import clinicavet.dao.ConnectionFactory;
import clinicavet.dao.TutorDao;
import clinicavet.exception.DaoException;
import clinicavet.model.Tutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TutorDaoMysql implements TutorDao {
    @Override
    public void inserir(Tutor tutor) {
        String sql = "insert into tutor(nome_completo, cpf, telefone, email, endereco, cidade, observacoes) values(?,?,?,?,?,?,?)";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, tutor);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao inserir tutor.", e);
        }
    }

    @Override
    public void atualizar(Tutor tutor) {
        String sql = "update tutor set nome_completo=?, cpf=?, telefone=?, email=?, endereco=?, cidade=?, observacoes=? where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, tutor);
            ps.setLong(8, tutor.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao atualizar tutor.", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "delete from tutor where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao deletar tutor.", e);
        }
    }

    @Override
    public Optional<Tutor> buscarPorId(Long id) {
        String sql = "select * from tutor where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar tutor por id.", e);
        }
    }

    @Override
    public List<Tutor> listarTodos() {
        String sql = "select * from tutor order by nome_completo";
        List<Tutor> resultado = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                resultado.add(mapear(rs));
            }
            return resultado;
        } catch (SQLException e) {
            throw new DaoException("Erro ao listar tutores.", e);
        }
    }

    private void preencher(PreparedStatement ps, Tutor tutor) throws SQLException {
        ps.setString(1, tutor.getNomeCompleto());
        ps.setString(2, tutor.getCpf());
        ps.setString(3, tutor.getTelefone());
        ps.setString(4, tutor.getEmail());
        ps.setString(5, tutor.getEndereco());
        ps.setString(6, tutor.getCidade());
        ps.setString(7, tutor.getObservacoes());
    }

    private Tutor mapear(ResultSet rs) throws SQLException {
        return new Tutor(
                rs.getLong("id"),
                rs.getString("nome_completo"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getString("email"),
                rs.getString("endereco"),
                rs.getString("cidade"),
                rs.getString("observacoes")
        );
    }
}
