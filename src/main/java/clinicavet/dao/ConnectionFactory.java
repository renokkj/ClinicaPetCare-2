package clinicavet.dao;

import clinicavet.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
    private static final String URL = System.getProperty("clinicavet.db.url", "jdbc:mysql://localhost:3306/clinica_vet_pp?useSSL=false&serverTimezone=UTC");
    private static final String USER = System.getProperty("clinicavet.db.user", "root");
    private static final String PASSWORD = System.getProperty("clinicavet.db.password", "1234");

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Não foi possível abrir a conexão com o banco de dados.", e);
        }
    }
}
