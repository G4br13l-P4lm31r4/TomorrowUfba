# 💸 Sistema Bancário - Tomorrow Bank

Este projeto foi desenvolvido como parte da disciplina do **Curso Tomorrow - UFBA - Programação Orientada a Objetos em Java**, com o objetivo de aplicar os **conceitos de Programação Orientada a Objetos (POO)** em Java, por meio da criação de um sistema bancário funcional executado via terminal.

## 📌 Descrição

O sistema simula as operações básicas de um banco digital, permitindo:

- Cadastro de clientes com CPF e nome.
- Escolha entre dois tipos de conta:
  - Conta Corrente (padrão)
  - Conta Poupança (com aplicação de juros)
- Operações bancárias como:
  - Consultar saldo
  - Realizar depósitos
  - Efetuar saques
  - Transferências entre contas
  - Aplicação de juros em contas poupança
- Listagem de todos os clientes cadastrados

## 🧩 Funcionalidades adicionais

- Validação de entradas via tratamento de exceções
- Navegação em menus por meio do terminal
- Aplicação prática de conceitos de reutilização e herança com a hierarquia de contas

## 🛠️ Tecnologias utilizadas

- **Java** (linguagem de programação)
- Terminal/Console para execução

## 📂 Estrutura do projeto

Bank/
├── Main.java # Classe principal: interface do sistema via terminal
├── Banco.java # Classe que representa o banco e gerencia os clientes
├── Cliente.java # Representa os clientes e associa uma conta
├── Conta.java # Classe abstrata base para os tipos de conta
├── ContaCorrente.java # Representa uma conta corrente simples
├── ContaPoupanca.java # Representa uma conta poupança com taxa de juros


## 💡 Conceitos de POO aplicados

- **Encapsulamento**: Uso de modificadores de acesso e métodos de acesso (`get`/`set`)
- **Herança**: `ContaCorrente` e `ContaPoupanca` herdam da classe `Conta`
- **Polimorfismo**: Operações bancárias comuns executadas em qualquer tipo de conta
- **Composição**: Cada cliente possui uma conta bancária
- **Responsabilidade única**: Cada classe tem uma função clara e separada
- **Validação de dados**: Verificações na entrada de dados e durante operações

## ✅ Status

✔️ Finalizado e funcional  
🚀 Pronto para evoluções futuras:
- Interface gráfica (JavaFX)
- Persistência de dados em arquivos ou banco de dados
- Autenticação com senha por cliente

## 👨‍💻 Autores

Desenvolvido por **Gabriel Palmeira, Leandro Pina, Jonata Oliveira, Yan Kauê, Luiz da Silva**  
Para o projeto final do **Curso Tomorrow - UFBA**.

