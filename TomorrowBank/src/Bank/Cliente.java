package Bank;

/**
 * Classe que representa um cliente do banco.
 * Cada cliente possui CPF, nome e uma conta (poupança ou corrente).
 */
public class Cliente {
    private final String cpf;
    private final String nome;
    private final Conta conta;

    /**
     * Construtor para cliente com conta corrente padrão.
     * 
     * @param cpf CPF do cliente
     * @param nome Nome do cliente
     */
    public Cliente(String cpf, String nome) {
        validarDados(cpf, nome);
        this.cpf = cpf;
        this.nome = nome;
        this.conta = new ContaCorrente(nome);
    }

    /**
     * Construtor para cliente com opção de conta poupança.
     * 
     * @param cpf CPF do cliente
     * @param nome Nome do cliente
     * @param contaPoupanca true para conta poupança, false para corrente
     * @param taxaJuros Taxa de juros mensal da conta poupança (ignorável se conta corrente)
     */
    public Cliente(String cpf, String nome, boolean contaPoupanca, double taxaJuros) {
        validarDados(cpf, nome);
        this.cpf = cpf;
        this.nome = nome;
        if (contaPoupanca) {
            this.conta = new ContaPoupanca(nome, taxaJuros);
        } else {
            this.conta = new ContaCorrente(nome);
        }
    }

    /**
     * Valida dados obrigatórios.
     */
    private void validarDados(String cpf, String nome) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio ou nulo");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo");
        }
    }

    /**
     * Exibe os dados do cliente.
     */
    public void exibirDados() {
        System.out.println("\n=== Dados do cliente ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Número da conta: " + conta.getNumeroConta());
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }
}


