# Mini-Sistema de Cadastro em Memória com ArrayList

Este projeto foi desenvolvido como uma tarefa acadêmica para implementar um sistema de cadastro completo (CRUD) para Funcionários, Produtos e Clientes. O armazenamento de dados é feito em memória utilizando `ArrayList`, e a interação com o usuário ocorre via console.

## Como Executar o Programa

1.  Abra o projeto em uma IDE Java, como o IntelliJ IDEA.
2.  Localize o arquivo `Main.java` na estrutura do projeto.
3.  Clique com o botão direito do mouse sobre o arquivo `Main.java`.
4.  No menu de contexto, selecione a opção "Run 'Main.main()'".
5.  O programa será executado e o menu principal aparecerá no console da IDE.

## Sequência de Teste Utilizada

[cite_start]A seguinte sequência foi executada para validar todas as funcionalidades do sistema, de acordo com os requisitos mínimos de teste[cite: 53, 54, 55, 56].

**1. Cadastro Inicial de Dados**
* [cite_start]**Funcionários (2 registros)[cite: 53]:**
    * No Menu Principal, selecionei a opção `1) Gerenciar Funcionários`.
    * No Submenu, selecionei `1) Cadastrar` e inseri os dados para:
        * Nome: `Carlos Silva`, Salário: `3500.0`, Matrícula: `1020`.
    * Selecionei `1) Cadastrar` novamente e inseri os dados para:
        * Nome: `Ana Costa`, Salário: `4200.0`, Matrícula: `1021`.

* [cite_start]**Produtos (2 registros)[cite: 53]:**
    * Voltei ao Menu Principal e selecionei a opção `2) Gerenciar Produtos`.
    * No Submenu, selecionei `1) Cadastrar` e inseri os dados para:
        * Nome: `Teclado Mecanico`, Preço: `250.0`, Estoque: `30`.
    * Selecionei `1) Cadastrar` novamente e inseri os dados para:
        * Nome: `Mouse Gamer`, Preço: `150.0`, Estoque: `50`.

* [cite_start]**Clientes (2 registros)[cite: 53]:**
    * Voltei ao Menu Principal e selecionei a opção `3) Gerenciar Clientes`.
    * No Submenu, selecionei `1) Cadastrar` e inseri os dados para:
        * Nome: `Mariana Lima`, Telefone: `11987654321`, Email: `mariana@email.com`.
    * Selecionei `1) Cadastrar` novamente e inseri os dados para:
        * Nome: `Pedro Alves`, Telefone: `21912345678`, Email: `pedro@email.com`.

**2. [cite_start]Verificação com Listagem [cite: 56]**
* Para cada módulo (Funcionários, Produtos e Clientes), a opção `2) Listar` foi utilizada para confirmar que os dois registros de cada tipo foram cadastrados corretamente.

**3. [cite_start]Atualização de Dados (1 registro de cada tipo) [cite: 54]**
* **Funcionário:**
    * Acessado `1) Gerenciar Funcionários` -> `4) Atualizar por ID`.
    * Informado o ID `1` (Carlos Silva).
    * Atualizado o salário para `3800.0`. A alteração foi confirmada com uma nova listagem.
* **Produto:**
    * Acessado `2) Gerenciar Produtos` -> `4) Atualizar por ID`.
    * Informado o ID `1` (Teclado Mecanico).
    * Atualizado o preço para `275.0`. A alteração foi confirmada com uma nova listagem.
* **Cliente:**
    * Acessado `3) Gerenciar Clientes` -> `4) Atualizar por ID`.
    * Informado o ID `1` (Mariana Lima).
    * Atualizado o telefone para `11999998888`. A alteração foi confirmada com uma nova listagem.

**4. [cite_start]Exclusão de Dados (1 registro de cada tipo) [cite: 55]**
* **Funcionário:**
    * Acessado `1) Gerenciar Funcionários` -> `5) Excluir por ID`.
    * Informado o ID `2` (Ana Costa) para remoção. A exclusão foi confirmada com a listagem, que agora exibia apenas 1 funcionário.
* **Produto:**
    * Acessado `2) Gerenciar Produtos` -> `5) Excluir por ID`.
    * Informado o ID `2` (Mouse Gamer) para remoção. A exclusão foi confirmada com a listagem.
* **Cliente:**
    * Acessado `3) Gerenciar Clientes` -> `5) Excluir por ID`.
    * Informado o ID `2` (Pedro Alves) para remoção. A exclusão foi confirmada com a listagem.

**5. Teste dos Atalhos do Menu Principal**
* No Menu Principal, a opção `4) Cadastrar Cliente (atalho)` foi utilizada com sucesso para adicionar um novo cliente.
* No Menu Principal, a opção `5) Cadastrar Produto (atalho)` foi utilizada com sucesso para adicionar um novo produto.

Todos os testes foram concluídos com sucesso, confirmando que as funcionalidades de CRUD estão operando conforme o esperado.
