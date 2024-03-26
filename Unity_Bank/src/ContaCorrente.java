public class ContaCorrente extends Conta {

	public ContaCorrente(String nome, String cpf, String numeroConta, String numeroAgencia, double saldo,
			double limiteCredito) {
		super(nome, cpf, numeroConta, numeroAgencia, saldo, limiteCredito, "Conta Corrente");
	}

	public void sacar(double valor) {
		if (valor <= 0) {
			System.out.println("O valor de saque deve ser maior que zero.");
			return;
		}

		if (getSaldo() + getLimiteCredito() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque de R$" + valor + " realizado com sucesso.");
		} else {
			System.out.println("Saldo insuficiente para realizar o saque.");
		}
	}

	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("O valor de depósito deve ser maior que zero.");
			return;
		}

		setSaldo(getSaldo() + valor);
		System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
	}

	public void transferir(double valor, ContaCorrente contaDestino) {
		if (valor <= 0) {
			System.out.println("O valor da transferência deve ser maior que zero.");
			return;
		}

		if (getSaldo() + getLimiteCredito() >= valor) {
			setSaldo(getSaldo() - valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			System.out.println("Transferência de R$" + valor + " para a conta " + contaDestino.getNumeroConta()
					+ " realizada com sucesso.");
		} else {
			System.out.println("Saldo insuficiente para realizar a transferência.");
		}
	}
}
