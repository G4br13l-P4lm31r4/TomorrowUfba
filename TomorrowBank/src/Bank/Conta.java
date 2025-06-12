package Bank;

/**
 * Classe abstrata que representa uma conta bancária.
 * Fornece a estrutura básica para operações como depósito, saque e transferência.
 */
public abstract class Conta {
    protected String titular; // Nome do titular da conta
    protected String numeroConta; // Número da conta gerado automaticamente
    protected double saldo; // Saldo atual da conta
    protected static int totalContas = 0; // Controle para gerar números únicos

    /**
     * Construtor que define titular e gera número da conta.
     * Inicializa saldo zerado.
     * 
     * @param titular Nome do titular da conta
     */
    public Conta(String titular) {
        this.titular = titular;
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0;
        totalContas++;
    }

    /**
     * Gera número da conta com 6 dígitos, sequencial.
     */
    private String gerarNumeroConta() {
        return String.format("%06d", totalContas + 1);
    }

    // Métodos abstratos que devem ser implementados nas subclasses

    public abstract void consultarSaldo();

    public abstract void deposito(double valor);

    public abstract boolean saque(double valor);

    public abstract void transferir(Conta destino, double valor);

    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}