package Bank;

/**
 * Classe que representa uma conta corrente.
 * Implementa as operações básicas de conta.
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("\n=== Saldo da Conta Corrente ===");
        System.out.println("Titular: " + titular);
        System.out.println("Número da conta: " + numeroConta);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    @Override
    public void deposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido!");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
        consultarSaldo();
    }

    @Override
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

    @Override
    public void transferir(Conta destino, double valor) {
        if (this == destino) {
            System.out.println("Não é possível transferir para a mesma conta");
            return;
        }
        if (saque(valor)) {
            destino.deposito(valor);
            System.out.printf("Transferência de R$ %.2f para a conta %s realizada com sucesso!\n", valor, destino.getNumeroConta());
        }
    }
}

