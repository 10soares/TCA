import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF que deseja buscar: ");
        String cpfPesquisado = scanner.nextLine();

        String caminhoArquivo = "C:\\Users\\Tarde\\Downloads\\Saquepague-Pagonext - Listas de clientes\\lista-3-contas.csv";

        try {
            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            boolean encontrou = false;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(",");

                if (partes.length >= 4 && partes[1].trim().equals(cpfPesquisado)) {
                    String nome = partes[0].trim();
                    String cpf = partes[1].trim();
                    String numeroConta = partes[2].trim();
                    String numeroAgencia = partes[3].trim();

                    System.out.println("Cliente encontrado");
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + cpf);
                    System.out.println("Número da Conta: " + numeroConta);
                    System.out.println("Número da Agência: " + numeroAgencia);
                    System.out.println("----------------------------------------");
                    encontrou = true;

                
                    System.out.print("Digite o número da conta de destino: ");
                    String numeroContaDestino = scanner.nextLine();
                    System.out.print("Digite o nome da conta de destino: ");
                    String destinoNome = scanner.nextLine();
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    TransferenciaBancaria transferencia = new TransferenciaBancaria(numeroConta, numeroAgencia, numeroContaDestino, numeroContaDestino, destinoNome,valorTransferencia);
                    transferencia.efetuarTransferencia();
                }
            }

            if (!encontrou) {
                System.out.println("CPF não encontrado.");
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
