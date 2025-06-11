package Bank;

/**
 * Classe que representa uma conta corrente bancária.
 * Permite realizar operações como consulta de saldo, depósito, saque e transferência.
 */
public class ContaCorrente {
    private String titular;  // Nome do titular da conta
    private String numeroConta; // Número da conta (gerado automaticamente)
    private double saldo;  // Saldo da conta
    private static int totalContas = 0; // Contador estático de contas criadas

      /**
     * Construtor da classe ContaCorrente.
     * Inicializa a conta com titular e gera número da conta.
     */
    public ContaCorrente(String titular) {
        totalContas++;
        this.titular = titular;
        this.numeroConta = gerarNumeroConta(); // Gera número único
        this.saldo = 0;
    }

     /**
     * Gera automaticamente o número da conta.
     * O número é sequencial, com 6 dígitos.
     */
    private String gerarNumeroConta() {
        return String.format("%06d", totalContas + 1);
    }

    /**
     * Exibe o saldo atual da conta e informações do titular.
     */
    public void consultarSaldo() {
        System.out.println("\n=== Saldo da conta ===");
        System.out.println("Titular: " + titular);
        System.out.println("Numero da conta: " + numeroConta);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    /**
     * Realiza um depósito na conta.
     * @param valor Valor a ser depositado (deve ser maior que zero)
     */
    public void deposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de deposito inválido!");
            return;
        }
        saldo += valor;
        System.out.printf("Deposito de R$ %.2f realizado com sucesso!\n", valor);
        consultarSaldo();
    }

     /**
     * Realiza um saque na conta.
     * @param valor Valor a ser sacado
     * @return true se o saque for realizado, false caso contrário
     */
    public boolean saque(double valor) {
       
        if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
            return false;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque!");
            consultarSaldo();
            return false;
        }

        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
        consultarSaldo();
        return true;
    }

     /**
     * Realiza uma transferência para outra conta.
     * @param destino Conta de destino
     * @param valor Valor da transferência
     */
    public void transferir(ContaCorrente destino, double valor) {
        if (this == destino) {
            System.out.println("Não é possível transferir para a mesma conta");
            return;
        }

        if (saque(valor)) {
            destino.deposito(valor);
            System.out.printf("Transferência de R$ %.2f para a conta %s realizado com sucesso! \n", valor, destino.getNumeroConta());
        }
    }

    // Getters 
    
    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getTotalContas() {
        return totalContas;
    }

    
}
