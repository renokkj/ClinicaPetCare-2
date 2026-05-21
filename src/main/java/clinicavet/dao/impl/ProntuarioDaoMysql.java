package clinicavet.dao.impl;

import clinicavet.dao.ConnectionFactory;
import clinicavet.dao.ProntuarioDao;
import clinicavet.exception.DaoException;
import clinicavet.model.Prontuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class ProntuarioDaoMysql implements ProntuarioDao {
    @Override
    public void inserir(Prontuario prontuario) {
        String sql = "insert into prontuario(pet_id, historico_clinico, medicacao_continua, restricoes_alimentares, nivel_prioridade, ultima_atualizacao) values(?,?,?,?,?,?)";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            preencher(ps, prontuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao inserir prontuário.", e);
        }
    }

    @Override
    public void atualizar(Prontuario prontuario) {
        String sql = "update prontuario set historico_clinico=?, medicacao_continua=?, restricoes_alimentares=?, nivel_prioridade=?, ultima_atualizacao=? where pet_id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, prontuario.getHistoricoClinico());
            ps.setString(2, prontuario.getMedicacaoContinua());
            ps.setString(3, prontuario.getRestricoesAlimentares());
            ps.setString(4, prontuario.getNivelPrioridade());
            ps.setTimestamp(5, Timestamp.valueOf(prontuario.getUltimaAtualizacao()));
            ps.setLong(6, prontuario.getPetId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erro ao atualizar prontuário.", e);
        }
    }

    @Override
    public Optional<Prontuario> buscarPorPetId(Long petId) {
        String sql = "select * from prontuario where pet_id=?";
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, petId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException("Erro ao buscar prontuário por pet.", e);
        }
    }

    private void preencher(PreparedStatement ps, Prontuario prontuario) throws SQLException {
        ps.setLong(1, prontuario.getPetId());
        ps.setString(2, prontuario.getHistoricoClinico());
        ps.setString(3, prontuario.getMedicacaoContinua());
        ps.setString(4, prontuario.getRestricoesAlimentares());
        ps.setString(5, prontuario.getNivelPrioridade());
        ps.setTimestamp(6, Timestamp.valueOf(prontuario.getUltimaAtualizacao()));
    }

    private Prontuario mapear(ResultSet rs) throws SQLException {
        Prontuario prontuario = new Prontuario();
        prontuario.setId(rs.getLong("id"));
        prontuario.setPetId(rs.getLong("pet_id"));
        prontuario.setHistoricoClinico(rs.getString("historico_clinico"));
        prontuario.setMedicacaoContinua(rs.getString("medicacao_continua"));
        prontuario.setRestricoesAlimentares(rs.getString("restricoes_alimentares"));
        prontuario.setNivelPrioridade(rs.getString("nivel_prioridade"));
        Timestamp ultimaAtualizacao = rs.getTimestamp("ultima_atualizacao");
        prontuario.setUltimaAtualizacao(ultimaAtualizacao == null ? null : ultimaAtualizacao.toLocalDateTime());
        return prontuario;
    }
}
