package Bank;

import java.util.Scanner;

/**
 * Classe principal que executa o sistema bancário no terminal.
 * Permite cadastrar clientes, realizar operações bancárias e listar clientes.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Tomorrow Bank");

        //Menu principal do sistema bancário 
        while (true) {
            System.out.println("\n=== Sistema bancário ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Operações bancárias");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma das opções: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar Buffer do scanner 

            switch (opcao) {
                case 1:
                    cadastrarCliente(banco, sc); // Chama método para cadastrar cliente
                    break;
                case 2:
                    operacoesBancarias(banco, sc); // Chama menu de operações bancárias
                    break;
                case 3:
                    banco.listarCliente(); // Lista todos os clientes cadastrados
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    System.exit(0); // Encerra o programa
                default:
                    System.out.println("=== Opção inválida ===");
            }

        }
    }

     /**
     * Método para cadastrar um novo cliente no banco.
     */
    private static void cadastrarCliente(Banco banco, Scanner sc) {
        System.out.println("\n=== Cadastro de cliente ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        Cliente novoCliente = new Cliente(cpf, nome);
        banco.adicionarCliente(novoCliente);
    }

     /**
     * Método que gerencia o submenu de operações bancárias de um cliente.
     */
    private static void operacoesBancarias(Banco banco, Scanner sc) {
        System.out.println("\n=== Operações Bancárias ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();

        Cliente cliente = banco.buscarCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        ContaCorrente conta = cliente.getConta();

        while (true) {
            System.out.println("\n=== Menu de operações ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar Buffer

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Valor para depósito: R$");
                    double valorDeposito = sc.nextDouble();
                    conta.deposito(valorDeposito);
                    break;
                case 3: 
                    System.out.print("Valor para saque: R$");
                    double valorSaque = sc.nextDouble();
                    conta.saque(valorSaque);
                    break;
                case 4:
                    System.out.print("CPF do destinatário: ");
                    String cpfDestino = sc.nextLine();
                    Cliente destino = banco.buscarCliente(cpfDestino);

                    if (destino != null && !destino.getCpf().equals(cpf)) {
                        System.out.print("Valor para transferência: R$");
                        double valorTransferencia = sc.nextDouble();
                        conta.transferir(destino.getConta(), valorTransferencia);
                    } else {
                        System.out.println("Conta destino inválida");
                    }
                    break;
                case 5:
                    return;  // Volta para o menu principal
                default:
                    System.out.println("=== Opção inválida ===");
            }
        }
    }
}
