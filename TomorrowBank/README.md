# 💸 Sistema Bancário - Tomorrow Bank

Este projeto foi desenvolvido como parte da disciplina do **Curso Tomorrow - UFBA - Programação Orientada a Ojetos em Java**, com o objetivo de aplicar os **conceitos de Programação Orientada a Objetos (POO)** em Java, por meio da criação de um sistema bancário simples.

## 📌 Descrição

O sistema simula as funcionalidades básicas de um banco, permitindo:

- Cadastro de clientes com CPF e nome.
- Criação automática de conta corrente para cada cliente.
- Operações bancárias como:
  - Consultar saldo
  - Realizar depósitos
  - Efetuar saques
  - Transferências entre contas
- Listagem de todos os clientes cadastrados.

## 🛠️ Tecnologias utilizadas

- **Java** (linguagem de programação)
- **JDK 17** (ou compatível)
- Terminal/Console para execução

## 📂 Estrutura do projeto

Bank/
├── Main.java # Classe principal (interface do sistema via terminal)
├── Banco.java # Representa o banco e gerencia os clientes
├── Cliente.java # Representa os clientes do banco
├── ContaCorrente.java # Representa a conta corrente de cada cliente

## 💡 Conceitos de POO aplicados

- **Encapsulamento**: Atributos privados e acesso controlado via getters.
- **Composição**: Um cliente possui uma conta (relação "tem-um").
- **Responsabilidade única**: Cada classe tem uma função bem definida.
- **Validação de dados**: Verificações ao cadastrar cliente e realizar operações.

## ✅ Status

✔️ Finalizado e funcional  
🚀 Pronto para evoluções futuras, como interface gráfica (JavaFX) ou persistência de dados.

## 👨‍💻 Autor

Desenvolvido por [Gabriel Palmeira, Leandro Pina, Jonata Oliveira, Yan Kauê, Luiz da Silva] para o Projeto final da Tomorrow da UFBA.  

