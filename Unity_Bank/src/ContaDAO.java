import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {
	private Connection connection;

	public ContaDAO(Connection connection) {
		this.connection = connection;
	}

	public Conta buscarPorCPF(String cpf) {
		String sql = "SELECT * FROM clientes WHERE Cpf = ?";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, cpf);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Conta conta = new Conta();
					conta.setNome(rs.getString("nome"));
					conta.setCpf(rs.getString("Cpf"));
					conta.setNumeroConta(rs.getString("Numero_da_conta"));
					conta.setNumeroAgencia(rs.getString("Numero_da_agencia"));
					conta.setTipoConta(rs.getString("tipo_conta"));
					conta.setSaldo(rs.getDouble("saldo"));
					conta.setLimiteCredito(rs.getDouble("Limite_de_Credito"));
					conta.setSenha(rs.getString("Senha"));
					return conta;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar conta: " + e.getMessage());
		}
	}

	public void atualizarSaldo(Conta conta) {
		String sql = "UPDATE clientes SET saldo = ? WHERE Cpf = ? AND Numero_da_conta = ?";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setDouble(1, conta.getSaldo());
			ps.setString(2, conta.getCpf());
			ps.setString(3, conta.getNumeroConta());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar saldo da conta: " + e.getMessage());
		}
	}

	public void atualizarCredito(Conta conta) {
		String sql = "UPDATE clientes SET saldo = ?, Limite_de_Credito = ? WHERE Cpf = ? AND Numero_da_conta = ?";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setDouble(1, conta.getSaldo());
			ps.setDouble(2, conta.getLimiteCredito());
			ps.setString(3, conta.getCpf());
			ps.setString(4, conta.getNumeroConta());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar saldo da conta: " + e.getMessage());
		}
	}

	public void atualizarSaldoDestino(Conta conta) {
		String sql = "UPDATE clientes SET saldo = ? WHERE Numero_da_conta = ?";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setDouble(1, conta.getSaldo());
			ps.setString(2, conta.getNumeroConta());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar saldo da conta destino: " + e.getMessage());
		}
	}

	public Conta buscarPorNumeroConta(String numeroConta) {
		String sql = "SELECT * FROM clientes WHERE Numero_da_conta = ?";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, numeroConta);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Conta conta = new Conta();
					conta.setNome(rs.getString("nome"));
					conta.setCpf(rs.getString("Cpf"));
					conta.setNumeroConta(rs.getString("Numero_da_conta"));
					conta.setNumeroAgencia(rs.getString("Numero_da_agencia"));
					conta.setTipoConta(rs.getString("tipo_conta"));
					conta.setSaldo(rs.getDouble("saldo"));
					conta.setLimiteCredito(rs.getDouble("Limite_de_Credito"));
					conta.setSenha(rs.getString("Senha"));
					return conta;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar conta: " + e.getMessage());
		}
	}

	public void salvar(Conta conta) {
		String sql = "INSERT INTO clientes (nome, Cpf, Numero_da_conta, Numero_da_agencia, tipo_conta, saldo, Limite_de_Credito, Senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, conta.getNome());
			ps.setString(2, conta.getCpf());
			ps.setString(3, conta.getNumeroConta());
			ps.setString(4, conta.getNumeroAgencia());
			ps.setString(5, conta.getTipoConta());
			ps.setDouble(6, conta.getSaldo());
			ps.setDouble(7, conta.getLimiteCredito());
			ps.setString(8, conta.getSenha());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar conta: " + e.getMessage());
		}
	}
}
