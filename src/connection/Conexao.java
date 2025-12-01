package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:postgresql://localhost:5432/Hotel";
    private static final String user = "postgres";
    private static final String senha = "2804";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver PostgreSQL não encontrado. Adicione o driver no classpath.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, senha);
    }

    public Conexao() throws SQLException {
        DriverManager.getConnection(url, user, senha);
    }
}