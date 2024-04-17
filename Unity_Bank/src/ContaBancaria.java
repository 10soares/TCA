import java.util.Random;
import java.util.Scanner;

public class ContaBancaria {
	private ContaDAO contaDAO;

	public ContaBancaria(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	public void realizarOperacao(Scanner scanner) {
		boolean continuar = true;

		while (continuar) {
			System.out.println("===========================");
			System.out.println("Bem-vindo ao Unity Bank!");
			System.out.println("Escolha uma opção:");
			System.out.println("1. Login");
			System.out.println("2. Cadastrar");
			System.out.println("===========================");

			System.out.print("Opção: ");
			int opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1:
				fazerLogin(scanner);
				continuar = false;
				break;
			case 2:
				cadastrarUsuario(scanner);
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	private void fazerLogin(Scanner scanner) {
		System.out.print("Digite o CPF que deseja buscar: ");
		String cpfPesquisado = scanner.nextLine();

		System.out.print("Digite a senha da conta: ");
		String senha = scanner.nextLine();

		boolean cpfEncontrado = false;
		Conta contaOrigem = null;

		Conta conta = contaDAO.buscarPorCPF(cpfPesquisado);
		if (conta != null) {
			cpfEncontrado = true;

			while (!conta.getSenha().equals(senha)) {
				System.out.println("Senha incorreta. Tente novamente:");
				senha = scanner.nextLine();
			}

			contaOrigem = conta;
			System.out.println("=================================================");
			System.out.println("\nConta encontrada para o CPF: " + cpfPesquisado);
			System.out.println("Nome: " + conta.getNome());
			System.out.println("CPF: " + conta.getCpf());
			System.out.println("Número da Agência: " + conta.getNumeroAgencia());
			System.out.println("Número da conta: " + conta.getNumeroConta() + ":");
			System.out.println("Saldo: " + conta.getSaldo());
			System.out.println("=================================================\n");

			String tipoConta = conta.getTipoConta();

			double limiteCredito = conta.getLimiteCredito();
			double saldo = conta.getSaldo();

			boolean continuarOperacao = true;

			while (continuarOperacao) {
				if (tipoConta.equals("Conta corrente")) {

					System.out.println("Limite de Crédito: " + limiteCredito);
					System.out.println("Tipo de Conta: " + tipoConta);

					System.out.println("\n============================");
					System.out.println("Escolha uma opção:");
					System.out.println("1. Transferência");
					System.out.println("2. Saque");
					System.out.println("3. Depósito");
					System.out.println("4. Saldo");
					System.out.println("5. Pagar utilizando Crédito");
					System.out.println("6. Pagar Fatura");
					System.out.println("7. Sair");
					System.out.println("============================");
					System.out.print("Opção: ");
					int opcao = Integer.parseInt(scanner.nextLine());

					switch (opcao) {
					case 1:
						System.out.print("Digite o número da conta de destino: ");
						String numeroContaDestino = scanner.nextLine();
						System.out.print("Digite o valor a ser transferido: ");
						double valorTransferencia = Double.parseDouble(scanner.nextLine());
						double novoSaldoOrigem = contaOrigem.transferir(numeroContaDestino, valorTransferencia);
						System.out.println("Novo saldo da conta origem após a transferência: " + novoSaldoOrigem);
						contaDAO.atualizarSaldo(contaOrigem);
						Conta contaDestino = contaDAO.buscarPorNumeroConta(numeroContaDestino);
						contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
						contaDAO.atualizarSaldoDestino(contaDestino);
						break;
					case 2:
						System.out.print("Digite o valor a ser sacado: ");
						double valorSaque = Double.parseDouble(scanner.nextLine());
						double novoSaldoSaque = contaOrigem.sacar(valorSaque);
						System.out.println("Novo saldo da conta após o saque: " + novoSaldoSaque);
						contaDAO.atualizarSaldo(contaOrigem);
						break;
					case 3:
						System.out.print("Digite o valor a ser depositado: ");
						double valorDeposito = Double.parseDouble(scanner.nextLine());
						double novoSaldoDeposito = contaOrigem.depositar(valorDeposito);
						System.out.println("Novo saldo da conta após o depósito: " + novoSaldoDeposito);
						contaDAO.atualizarSaldo(contaOrigem);
						break;
					case 4:
						System.out.println("Saldo da conta: " + saldo);
						break;
					case 5:
						System.out.print("Digite o valor a ser pago utilizando o limite de crédito: ");
						double valorPagamento = Double.parseDouble(scanner.nextLine());

						if (valorPagamento <= limiteCredito) {
							double novoLimiteCredito = contaOrigem.pagarComLimiteCredito(valorPagamento);
							System.out.println("Novo limite de crédito após o pagamento: " + novoLimiteCredito);
							contaDAO.atualizarCredito(contaOrigem);
						} else {
							System.out.println("Valor do pagamento excede o limite de crédito disponível.");
						}
						break;
					case 6:
						System.out.print("Digite o valor da fatura a ser paga: ");
						double valorFatura = Double.parseDouble(scanner.nextLine());
						double novoLimiteCredito = contaOrigem.pagarFatura(valorFatura);
						System.out.println("Novo limite de crédito após o pagamento da fatura: " + novoLimiteCredito);
						contaDAO.atualizarCredito(contaOrigem);
						break;
					case 7:
						System.out.println("Encerrando o Unity Bank. Obrigado por usar nossos serviços. Até logo!");
						System.exit(0);
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				} else {
					System.out.println("===========================");
					System.out.println("\nEscolha uma opção:");
					System.out.println("1. Saque");
					System.out.println("2. Depósito");
					System.out.println("3. Sair");
					System.out.println("===========================");
					System.out.print("Opção: ");
					int opcao = Integer.parseInt(scanner.nextLine());

					switch (opcao) {
					case 1:
						System.out.print("Digite o valor a ser sacado: ");
						double valorSaque = Double.parseDouble(scanner.nextLine());
						double novoSaldoSaque = contaOrigem.sacar(valorSaque);
						System.out.println("Novo saldo da conta após o saque: " + novoSaldoSaque);
						contaDAO.atualizarSaldo(contaOrigem);
						break;
					case 2:
						System.out.print("Digite o valor a ser depositado: ");
						double valorDeposito = Double.parseDouble(scanner.nextLine());
						double novoSaldoDeposito = contaOrigem.depositar(valorDeposito);
						System.out.println("Novo saldo da conta após o depósito: " + novoSaldoDeposito);
						contaDAO.atualizarSaldo(contaOrigem);
						break;
					case 3:
						System.out.println("Encerrando o Unity Bank. Obrigado por usar nossos serviços. Até logo!");
						System.exit(0);
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				}
			}
		}

		if (!cpfEncontrado) {
			System.out.println("CPF e/ou número de conta não encontrado(s).");
		}
	}

	private void cadastrarUsuario(Scanner scanner) {
		System.out.println("---- Cadastro de Usuário ----");
		System.out.print("Nome completo: ");
		String nome = scanner.nextLine();

		System.out.print("CPF: ");
		String cpf = scanner.nextLine();

		Random rand = new Random();
		int agenciaNumero = rand.nextInt(999) + 100;
		int agenciaDigito = rand.nextInt(9);
		String numeroAgencia = agenciaNumero + "-" + agenciaDigito;

		int contaParte1 = rand.nextInt(90) + 10;
		int contaParte2 = rand.nextInt(9000) + 1000;
		String numeroConta = contaParte1 + "." + contaParte2;

		System.out.println("Escolha o tipo de conta:");
		System.out.println("1. Conta Corrente");
		System.out.println("2. Conta Salário");
		System.out.print("Opção: ");
		int opcaoConta = Integer.parseInt(scanner.nextLine());

		String tipoConta;
		switch (opcaoConta) {
		case 1:
			tipoConta = "Conta corrente";
			break;
		case 2:
			tipoConta = "Conta salário";
			break;
		default:
			System.out.println("Opção inválida. Será cadastrada como Conta Corrente.");
			tipoConta = "Conta corrente";
		}

		System.out.print("Digite sua senha: ");
		String senha = scanner.nextLine();

		Conta novaConta = new Conta(nome, cpf, numeroConta, numeroAgencia, 0, 0, tipoConta, senha);
		contaDAO.salvar(novaConta);
		System.out.println("seu número da agencia é: "+numeroAgencia);
		System.out.println("seu número da conta é: "+numeroConta);
		System.out.println("Usuário cadastrado com sucesso!");
	}
}
