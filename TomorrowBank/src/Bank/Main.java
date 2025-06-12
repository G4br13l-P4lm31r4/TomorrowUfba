package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco Digital");

        boolean sair = false;
        // Loop principal do sistema
        while (!sair) {
            try {
                // Menu principal
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1 - Cadastrar cliente");
                System.out.println("2 - Operações bancárias");
                System.out.println("3 - Listar clientes");
                System.out.println("4 - Sair");
                System.out.print("Escolha a opção: ");
                int opcao = sc.nextInt();
                sc.nextLine(); // Limpa o buffer após leitura numérica

                switch (opcao) {
                    case 1:
                        // Chamada para cadastro de cliente
                        cadastrarCliente(sc, banco);
                        break;
                    case 2:
                        // Menu de operações bancárias por cliente
                        operacoesBancarias(sc, banco);
                        break;
                    case 3:
                        // Lista todos os clientes do banco
                        banco.listarCliente();
                        break;
                    case 4:
                        // Sai do sistema
                        System.out.println("Saindo do sistema...");
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                // Trata erro de entrada não numérica
                System.out.println("Entrada inválida! Digite um número.");
                sc.nextLine(); // limpa entrada inválida
            }
        }
        sc.close();
    }

    /**
     * Método que cadastra clientes, com opção de conta poupança ou corrente.
     */
    private static void cadastrarCliente(Scanner sc, Banco banco) {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o CPF (somente números): ");
        String cpf = sc.nextLine();

        try {
            System.out.println("Deseja abrir conta poupança? (S/N)");
            String tipoConta = sc.nextLine().trim().toUpperCase();

            if (tipoConta.equals("S")) {
                System.out.print("Digite a taxa de juros mensal (exemplo: 0.01 para 1%): ");
                double taxaJuros = sc.nextDouble();
                sc.nextLine(); // limpar buffer
                Cliente cliente = new Cliente(cpf, nome, true, taxaJuros);
                banco.adicionarCliente(cliente);
            } else if (tipoConta.equals("N")) {
                Cliente cliente = new Cliente(cpf, nome);
                banco.adicionarCliente(cliente);
            } else {
                System.out.println("Opção inválida para tipo de conta.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Taxa de juros inválida!");
            sc.nextLine(); // limpa buffer
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    /**
     * Menu de operações bancárias:
     * saldo, saque, depósito, transferência e aplicar juros (se poupança).
     */
    private static void operacoesBancarias(Scanner sc, Banco banco) {
        System.out.println("\n=== Operações Bancárias ===");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();

        Cliente cliente = banco.buscarCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Conta conta = cliente.getConta();
        boolean voltar = false;
        while (!voltar) {
            try {
                System.out.println("\nEscolha a operação:");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Saque");
                System.out.println("3 - Depósito");
                System.out.println("4 - Transferência");
                if (conta instanceof ContaPoupanca) {
                    System.out.println("5 - Aplicar juros");
                    System.out.println("6 - Voltar");
                } else {
                    System.out.println("5 - Voltar");
                }
                System.out.print("Opção: ");
                int opcao = sc.nextInt();
                sc.nextLine(); // limpar buffer

                // Ações disponíveis para conta poupança
                if (conta instanceof ContaPoupanca) {
                    switch (opcao) {
                        case 1 -> conta.consultarSaldo();
                        case 2 -> {
                            System.out.print("Digite o valor do saque: ");
                            double valor = sc.nextDouble();
                            sc.nextLine();
                            conta.saque(valor);
                        }
                        case 3 -> {
                            System.out.print("Digite o valor do depósito: ");
                            double valor = sc.nextDouble();
                            sc.nextLine();
                            conta.deposito(valor);
                        }
                        case 4 -> {
                            System.out.print("Digite o CPF do destinatário: ");
                            String cpfDestino = sc.nextLine();
                            Cliente destinatario = banco.buscarCliente(cpfDestino);
                            if (destinatario != null) {
                                System.out.print("Digite o valor da transferência: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();
                                conta.transferir(destinatario.getConta(), valor);
                            } else {
                                System.out.println("Cliente destinatário não encontrado.");
                            }
                        }
                        case 5 -> ((ContaPoupanca) conta).aplicarJuros();
                        case 6 -> voltar = true;
                        default -> System.out.println("Opção inválida.");
                    }
                } else {
                    // Ações disponíveis para conta corrente
                    switch (opcao) {
                        case 1 -> conta.consultarSaldo();
                        case 2 -> {
                            System.out.print("Digite o valor do saque: ");
                            double valor = sc.nextDouble();
                            sc.nextLine();
                            conta.saque(valor);
                        }
                        case 3 -> {
                            System.out.print("Digite o valor do depósito: ");
                            double valor = sc.nextDouble();
                            sc.nextLine();
                            conta.deposito(valor);
                        }
                        case 4 -> {
                            System.out.print("Digite o CPF do destinatário: ");
                            String cpfDestino = sc.nextLine();
                            Cliente destinatario = banco.buscarCliente(cpfDestino);
                            if (destinatario != null) {
                                System.out.print("Digite o valor da transferência: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();
                                conta.transferir(destinatario.getConta(), valor);
                            } else {
                                System.out.println("Cliente destinatário não encontrado.");
                            }
                        }
                        case 5 -> voltar = true;
                        default -> System.out.println("Opção inválida.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                sc.nextLine(); // limpa buffer
            }
        }
    }
}
