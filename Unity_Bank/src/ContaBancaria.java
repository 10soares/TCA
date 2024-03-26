import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaBancaria {
	private static final String caminhoArquivo = "C:\\Users\\Tarde\\Desktop\\Saquepague-Pagonext.-.Listas.de.clientes\\Saquepague-Pagonext - Listas de clientes\\lista-3-contas-salario-tipo-de-conta.csv";
	private List<String> linhasCSV;

	public ContaBancaria() {
		this.linhasCSV = new ArrayList<>();
		carregarCSV();
	}

	private void carregarCSV() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;
			while ((linha = bufferedReader.readLine()) != null) {
				linhasCSV.add(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
		}
	}

	public List<String> getLinhasCSV() {
		return linhasCSV;
	}

	public void realizarOperacao(Scanner scanner) {
	    System.out.print("Digite o CPF que deseja buscar: ");
	    String cpfPesquisado = scanner.nextLine();

	    System.out.print("Digite a senha da conta: ");
	    String senha = scanner.nextLine();

	    double saldoOrigem = 0;

	    try {
	        FileReader fileReader = new FileReader(caminhoArquivo);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha;
	        while ((linha = bufferedReader.readLine()) != null) {
	            String[] partes = linha.split(",");
	            String cpf = partes[1].trim();

	            if (cpf.equals(cpfPesquisado)) {
	                String nome = partes[0].trim();
	                String numeroContaOrigem = partes[2].trim();
	                String numeroAgenciaOrigem = partes[3].trim();
	                double saldo = Double.parseDouble(partes[5].trim());
	                String tipoConta = partes[4].trim();
	                double limiteCredito = Double.parseDouble(partes[6].trim());
	                String senhaConta = partes[partes.length - 1].trim();

	                while (!senha.equals(senhaConta)) {
	                    System.out.println("Senha incorreta.");
	                    System.out.print("Digite a senha novamente: ");
	                    senha = scanner.nextLine();
	                }

	                System.out.println("Conta encontrada para o CPF: " + cpfPesquisado + ":");
	                System.out.println("Nome: " + nome);
	                System.out.println("CPF: " + cpf);
	                System.out.println("Número da Conta Origem: " + numeroContaOrigem);
	                System.out.println("Número da Agência Origem: " + numeroAgenciaOrigem);
	                System.out.println("Saldo Origem: " + saldo);

	                if (tipoConta.equals("Conta corrente")) {
	                    System.out.println("Limite de Crédito: " + limiteCredito);
	                    System.out.println("Tipo de Conta: " + tipoConta);
	                } else {
	                    System.out.println("Tipo de Conta: " + tipoConta);
	                }

	                System.out.println("\n===============================");
	                System.out.println("Escolha o tipo de operação:");
	                System.out.println("1. Transferência");
	                System.out.println("2. Saque");
	                System.out.println("3. Deposito");
	                System.out.println("===============================");
	                System.out.print("Opção: ");
	                
	                int opcao = scanner.nextInt();
	                scanner.nextLine(); 

	                switch (opcao) {
	                    case 1:
	                        System.out.print("Digite o número da conta de destino: ");
	                        String numeroContaDestino = scanner.nextLine();

	                        if (numeroContaDestino.equals(numeroContaOrigem)) {
	                            System.out.println("Não é possível realizar transferência para a mesma conta origem.");
	                            return;
	                        }

	                        System.out.print("Digite o valor a ser transferido: ");
	                        double valorTransferencia = scanner.nextDouble();

	                        saldoOrigem = saldo;

	                        TransferenciaBancaria transferencia = new TransferenciaBancaria(numeroContaOrigem, numeroAgenciaOrigem,
	                                numeroContaDestino, null, valorTransferencia, saldoOrigem);
	                        transferencia.efetuarTransferencia();
	                        break;

	                    case 2:
	                        System.out.println("saque nao implementada");
	                        break;
	                    case 3:
	                    	System.out.println("deposito nao implementada");
	                        break;

	                    default:
	                        System.out.println("Opção inválida.");
	                        return;
	                }

	                break;
	            }
	        }

	        bufferedReader.close();
	    } catch (IOException e) {
	        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	    }}}