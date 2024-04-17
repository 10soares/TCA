public class Conta {
    private String nome;
    private String cpf;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;
    private double limiteCredito;
    private String tipoConta;
    private String senha;

    public Conta() {
    }

    public Conta(String nome, String cpf, String numeroConta, String numeroAgencia, double saldo, double limiteCredito,
                 String tipoConta, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
        this.tipoConta = tipoConta;
        this.senha = senha;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double sacar(double valorSaque) {
        if (saldo + limiteCredito < valorSaque) {
            System.out.println("Saldo insuficiente para saque.");
            return saldo;
        }

        System.out.println("Saque de " + valorSaque + " realizado com sucesso na conta " + this.numeroConta);
        this.saldo -= valorSaque;
        return saldo;
    }

    public double depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        System.out.println("Depósito de " + valorDeposito + " realizado com sucesso na conta " + this.numeroConta);
        return saldo;
    }

    public double transferir(String numeroContaDestino, double valorTransferencia) {
        if (saldo < valorTransferencia) {
            System.out.println("Saldo insuficiente para transferência.");
            return saldo;
		}

        System.out.println("Transferência de " + valorTransferencia + " realizada com sucesso da conta "
                + this.numeroConta + " para a conta " + numeroContaDestino);
        this.saldo -= valorTransferencia;
        return saldo;
    }

    public double pagarComLimiteCredito(double valorPagamento) {
        if (limiteCredito < valorPagamento) {
            System.out.println("Limite de crédito insuficiente para realizar o pagamento.");
            return limiteCredito;
        }

        limiteCredito -= valorPagamento;

        System.out.println("Pagamento de R$ " + valorPagamento + " realizado com sucesso utilizando o limite de crédito.");
        
        return limiteCredito;
    }
    
    public double pagarFatura(double valorFatura) {
        if (saldo >= valorFatura) {
            saldo -= valorFatura;
            limiteCredito += valorFatura; 
            System.out.println("Fatura de R$ " + valorFatura + " paga com sucesso utilizando o saldo normal.");
        } else {
            System.out.println("Saldo insuficiente para pagar a fatura.");
        }
        
        return limiteCredito; 
    }
}
