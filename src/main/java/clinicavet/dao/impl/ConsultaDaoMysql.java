package clinicavet.dao.impl;

import clinicavet.dao.ConnectionFactory;
import clinicavet.dao.ConsultaDao;
import clinicavet.exception.DaoException;
import clinicavet.model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultaDaoMysql implements ConsultaDao {
    @Override
    public void inserir(Consulta consulta) {
        String sql = "insert into consulta(pet_id, data_consulta, tipo_consulta, status_consulta, observacoes, valor) values(?,?,?,?,?,?)";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, consulta);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao inserir consulta.", e);
        }
    }

    @Override
    public void atualizar(Consulta consulta) {
        String sql = "update consulta set pet_id=?, data_consulta=?, tipo_consulta=?, status_consulta=?, observacoes=?, valor=? where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, consulta);
            ps.setLong(7, consulta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao atualizar consulta.", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "delete from consulta where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao deletar consulta.", e);
        }
    }

    @Override
    public Optional<Consulta> buscarPorId(Long id) {
        String sql = "select * from consulta where id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar consulta por id.", e);
        }
    }

    @Override
    public List<Consulta> listarTodos() {
        return listar("select * from consulta order by data_consulta desc", null);
    }

    @Override
    public List<Consulta> listarPorPet(Long petId) {
        return listar("select * from consulta where pet_id=? order by data_consulta desc", petId);
    }

    private List<Consulta> listar(String sql, Long petId) {
        List<Consulta> consultas = new ArrayList<>();
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (petId != null) {
                ps.setLong(1, petId);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    consultas.add(mapear(rs));
                }
            }
            return consultas;
        } catch (SQLException e) {
            throw new DaoException("Erro ao listar consultas.", e);
        }
    }

    private void preencher(PreparedStatement ps, Consulta consulta) throws SQLException {
        ps.setLong(1, consulta.getPetId());
        ps.setTimestamp(2, Timestamp.valueOf(consulta.getDataConsulta()));
        ps.setString(3, consulta.getTipoConsulta());
        ps.setString(4, consulta.getStatusConsulta());
        ps.setString(5, consulta.getObservacoes());
        ps.setBigDecimal(6, consulta.getValor());
    }

    private Consulta mapear(ResultSet rs) throws SQLException {
        Consulta consulta = new Consulta();
        consulta.setId(rs.getLong("id"));
        consulta.setPetId(rs.getLong("pet_id"));
        Timestamp data = rs.getTimestamp("data_consulta");
        consulta.setDataConsulta(data == null ? null : data.toLocalDateTime());
        consulta.setTipoConsulta(rs.getString("tipo_consulta"));
        consulta.setStatusConsulta(rs.getString("status_consulta"));
        consulta.setObservacoes(rs.getString("observacoes"));
        consulta.setValor(rs.getBigDecimal("valor"));
        return consulta;
    }
}
