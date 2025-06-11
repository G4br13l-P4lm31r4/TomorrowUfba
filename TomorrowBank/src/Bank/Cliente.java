package Bank;

/**
 * Classe que representa um cliente do banco.
 * Cada cliente possui CPF, nome e uma conta corrente associada.
 */
public class Cliente {
    private final String cpf; // CPF do cliente (único)
    private final String nome; // Nome do cliente
    private final ContaCorrente conta; // Conta corrente associada ao cliente


    /**
     * Construtor do cliente.
     * Valida os dados e cria automaticamente uma conta corrente vinculada.
     *
     * @param cpf  CPF do cliente (não pode ser nulo ou vazio)
     * @param nome Nome do cliente (não pode ser nulo ou vazio)
     */
    public Cliente(String cpf, String nome) {
        // Validação básica
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio ou nulo");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.conta = new ContaCorrente(nome); // Cria a conta para o cliente
    }


     /**
     * Exibe os dados do cliente, incluindo a conta vinculada.
     */
    public void exibirDados() {
        System.out.println("\n=== Dados do cliente ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Número da conta: " + conta.getNumeroConta());
    }

    // Getters (acessores)
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public ContaCorrente getConta() {
        return conta;
    }

}
