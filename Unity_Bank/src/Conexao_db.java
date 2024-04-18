import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_db {
	private static final String URL = "jdbc:mysql://localhost:3306/unitybank_db";
	private static final String USER = "root";
	private static final String PASSWORD = "12345";

	private Conexao_db() {
	}

	public static Connection obterConexao() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}
}
