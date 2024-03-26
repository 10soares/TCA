public class Conta {
    private String nome;
    private String cpf;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;
    private double limiteCredito;
    private String tipoConta;

    
    public Conta() {}
        


    public Conta(String nome, String cpf, String numeroConta, String numeroAgencia, double saldo, double limiteCredito, String tipoConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.tipoConta = tipoConta;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
