import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Connection connection = Conexao_db.obterConexao();

		ContaDAO contaDAO = new ContaDAO(connection);

		Scanner scanner = new Scanner(System.in);

		ContaBancaria contaBancaria = new ContaBancaria(contaDAO);

		contaBancaria.realizarOperacao(scanner);

		scanner.close();
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
		}
	}
}
