public class Salario extends Conta {

    public Salario(String nome, String cpf, String numeroConta, String numeroAgencia, double saldo) {
        super(nome, cpf, numeroConta, numeroAgencia, saldo, 0, "Salário");
    }


	public void receberSalario(double valor) {
		if (valor <= 0) {
			System.out.println("O valor do salário deve ser maior que zero.");
			return;
		}

		setSaldo(getSaldo() + valor);
		System.out.println("Salário de R$" + valor + " recebido com sucesso.");
	}


	
}
