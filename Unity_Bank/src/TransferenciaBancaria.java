public class TransferenciaBancaria {
    private String origemNumeroConta;
    private String origemNumeroAgencia;
    private String destinoNumeroConta;
    private String destinoNumeroAgencia;
    private double valor;

    public TransferenciaBancaria(String origemNumeroConta, String origemNumeroAgencia, 
                                 String destinoNumeroConta, String destinoNumeroAgencia, double valor) {
        this.origemNumeroConta = origemNumeroConta;
        this.origemNumeroAgencia = origemNumeroAgencia;
        this.destinoNumeroConta = destinoNumeroConta;
        this.destinoNumeroAgencia = destinoNumeroAgencia;
        this.valor = valor;
    }

    
    public void efetuarTransferencia() {
        
        System.out.println("Transferência efetuada: R$" + valor + " da conta " + origemNumeroConta + " para a conta " + destinoNumeroConta);
    }
}
