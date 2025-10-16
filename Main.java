import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        executarMenuPrincipal();
    }

    private static final Scanner scanner = new Scanner(System.in);

    // Repositórios
    private static final FuncionarioRepository funcionarioRepo = new FuncionarioRepository();
    private static final ProdutoRepository produtoRepo = new ProdutoRepository();
    private static final ClienteRepository clienteRepo = new ClienteRepository();

    private static void executarMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1) Gerenciar Funcionários");
            System.out.println("2) Gerenciar Produtos");
            System.out.println("3) Gerenciar Clientes");
            System.out.println("0) Sair");

            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    menuFuncionarios();
                    break;
                case 2:
                    menuProdutos();
                    break;
                case 3:
                    menuClientes();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }

    // ================= FUNCIONÁRIOS =================
    private static void menuFuncionarios() {
        int opcao;
        do {
            System.out.println("\n--- MENU FUNCIONÁRIOS ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar");
            System.out.println("5) Remover");
            System.out.println("0) Voltar");

            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionarioPorId();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    removerFuncionario();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRAR FUNCIONÁRIO ---");
        String nome = lerString("Nome: ");
        double salario = lerDouble("Salário: ");
        String matricula = lerString("Matrícula: ");

        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setSalario(salario);
        f.setMatricula(matricula);

        funcionarioRepo.adicionar(f);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void listarFuncionarios() {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        List<Funcionario> lista = funcionarioRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : lista) {
            System.out.println(formatarFuncionario(f));
        }
    }

    private static void buscarFuncionarioPorId() {
        int id = lerInt("Digite o ID do funcionário: ");
        Funcionario f = funcionarioRepo.buscarPorId(id);
        if (f == null) {
            System.out.println("Funcionário não encontrado.");
        } else {
            System.out.println(formatarFuncionario(f));
        }
    }

    private static void atualizarFuncionario() {
        int id = lerInt("Digite o ID para atualizar: ");
        Funcionario existente = funcionarioRepo.buscarPorId(id);
        if (existente == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        String nome = lerString("Novo nome (ENTER para manter): ");
        String salarioStr = lerString("Novo salário (ENTER para manter): ");
        String matricula = lerString("Nova matrícula (ENTER para manter): ");

        if (!nome.isEmpty()) existente.setNome(nome);
        if (!salarioStr.isEmpty()) existente.setSalario(Double.parseDouble(salarioStr));
        if (!matricula.isEmpty()) existente.setMatricula(matricula);

        funcionarioRepo.atualizar(id, existente);
        System.out.println("✅ Funcionário atualizado com sucesso!");
    }

    private static void removerFuncionario() {
        int id = lerInt("Digite o ID para remover: ");
        boolean ok = funcionarioRepo.removerPorId(id);
        System.out.println(ok ? "Funcionário removido." : "ID não encontrado.");
    }

    // ================= PRODUTOS =================
    private static void menuProdutos() {
        int opcao;
        do {
            System.out.println("\n--- MENU PRODUTOS ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar");
            System.out.println("5) Remover");
            System.out.println("0) Voltar");

            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProdutoPorId();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }

    private static void cadastrarProduto() {
        System.out.println("\n--- CADASTRAR PRODUTO ---");
        String nome = lerString("Nome: ");
        double preco = lerDouble("Preço: ");
        int quantidade = lerInt("Quantidade em estoque: ");

        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        p.setQuantidadeEmEstoque(quantidade);

        produtoRepo.adicionar(p);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        List<Produto> lista = produtoRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : lista) {
            System.out.println(formatarProduto(p));
        }
    }

    private static void buscarProdutoPorId() {
        int id = lerInt("Digite o ID do produto: ");
        Produto p = produtoRepo.buscarPorId(id);
        if (p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println(formatarProduto(p));
        }
    }

    private static void atualizarProduto() {
        int id = lerInt("Digite o ID para atualizar: ");
        Produto existente = produtoRepo.buscarPorId(id);
        if (existente == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        String nome = lerString("Novo nome (ENTER para manter): ");
        String precoStr = lerString("Novo preço (ENTER para manter): ");
        String qtdStr = lerString("Nova quantidade (ENTER para manter): ");

        if (!nome.isEmpty()) existente.setNome(nome);
        if (!precoStr.isEmpty()) existente.setPreco(Double.parseDouble(precoStr));
        if (!qtdStr.isEmpty()) existente.setQuantidadeEmEstoque(Integer.parseInt(qtdStr));

        produtoRepo.atualizar(id, existente);
        System.out.println("Produto atualizado com sucesso!");
    }

    private static void removerProduto() {
        int id = lerInt("Digite o ID para remover: ");
        boolean ok = produtoRepo.removerPorId(id);
        System.out.println(ok ? "Produto removido." : "ID não encontrado.");
    }

    // ================= CLIENTES =================
    private static void menuClientes() {
        int opcao;
        do {
            System.out.println("\n--- MENU CLIENTES ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar");
            System.out.println("5) Remover");
            System.out.println("0) Voltar");

            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorId();
                    break;
                case 4:
                    atualizarCliente();
                    break;
                case 5:
                    removerCliente();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- CADASTRAR CLIENTE ---");
        String nome = lerString("Nome: ");
        String telefone = lerString("Telefone: ");
        String email = lerString("Email: ");

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setTelefone(telefone);
        c.setEmail(email);

        clienteRepo.adicionar(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        List<Cliente> lista = clienteRepo.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : lista) {
            System.out.println(formatarCliente(c));
        }
    }

    private static void buscarClientePorId() {
        int id = lerInt("Digite o ID do cliente: ");
        Cliente c = clienteRepo.buscarPorId(id);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println(formatarCliente(c));
        }
    }

    private static void atualizarCliente() {
        int id = lerInt("Digite o ID para atualizar: ");
        Cliente existente = clienteRepo.buscarPorId(id);
        if (existente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        String nome = lerString("Novo nome (ENTER para manter): ");
        String telefone = lerString("Novo telefone (ENTER para manter): ");
        String email = lerString("Novo email (ENTER para manter): ");

        if (!nome.isEmpty()) existente.setNome(nome);
        if (!telefone.isEmpty()) existente.setTelefone(telefone);
        if (!email.isEmpty()) existente.setEmail(email);

        clienteRepo.atualizar(id, existente);
        System.out.println("Cliente atualizado com sucesso!");
    }

    private static void removerCliente() {
        int id = lerInt("Digite o ID para remover: ");
        boolean ok = clienteRepo.removerPorId(id);
        System.out.println(ok ? "Cliente removido." : "ID não encontrado.");
    }

    // ================= UTILITÁRIOS =================
    private static String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex: 10.50).");
            }
        }
    }

    private static String formatarFuncionario(Funcionario f) {
        return String.format("ID: %d | Nome: %s | Salário: %.2f | Matrícula: %s",
                f.getId(), f.getNome(), f.getSalario(), f.getMatricula());
    }

    private static String formatarProduto(Produto p) {
        return String.format("ID: %d | Nome: %s | Preço: %.2f | Qtde: %d",
                p.getId(), p.getNome(), p.getPreco(), p.getQuantidadeEmEstoque());
    }

    private static String formatarCliente(Cliente c) {
        return String.format("ID: %d | Nome: %s | Telefone: %s | Email: %s",
                c.getId(), c.getNome(), c.getTelefone(), c.getEmail());
    }
}
