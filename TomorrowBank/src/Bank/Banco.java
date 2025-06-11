package Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o banco.
 * Gerencia uma lista de clientes e oferece métodos para cadastro, busca e
 * listagem.
 */
public class Banco {
    private String nome; // Nome do banco
    private List<Cliente> clientes; // Lista de clientes cadastrados


    /**
     * Construtor que inicializa o banco com um nome e uma lista vazia de clientes.
     * 
     * @param nome Nome do banco
     */
    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }


    /**
     * Adiciona um cliente à lista de clientes do banco.
     * Exibe mensagem de confirmação.
     * 
     * @param cliente Cliente a ser adicionado
     */
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso no TomorrowBank");
    }


    /**
     * Busca um cliente pelo CPF.
     * 
     * @param cpf CPF do cliente a ser buscado
     * @return Cliente se encontrado, ou null se não existir
     */
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }


    /**
     * Lista todos os clientes do banco, exibindo seus dados.
     */
    public void listarCliente() {
        System.out.println("\n=== Clientes do banco" + nome + " ===");
        for (Cliente cliente : clientes) {
            cliente.exibirDados();
        }
    }

}
