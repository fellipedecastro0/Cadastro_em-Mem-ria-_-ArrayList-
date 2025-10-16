import java.util.ArrayList;

public class ProdutoRepository implements Repository<Produto> {
    
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Produto produto) {
        Produto novoProduto = new Produto(
            proximoId, 
            produto.getNome(), 
            produto.getPreco(), 
            produto.getQuantidadeEmEstoque()
        );
        
        listaProdutos.add(novoProduto);
        System.out.println("Produto " + novoProduto.getNome() + " adicionado com sucesso. ID: " + novoProduto.getId());
        proximoId++;
    }

    @Override
    public void listar() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\nLista de Produtos");
        for (Produto p : listaProdutos) {
            System.out.println(p);
        }
        System.out.println("---------------------------\n");
    }

    @Override
    public Produto buscarPorId(int id) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto produto = listaProdutos.get(i);
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; 
    }

    @Override
    public void atualizar(Produto produtoAtualizado) {
        int index = -1;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == produtoAtualizado.getId()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            listaProdutos.set(index, produtoAtualizado);
            System.out.println("Produto ID " + produtoAtualizado.getId() + " atualizado.");
        } else {
            System.out.println("Erro: Produto ID " + produtoAtualizado.getId() + " não encontrado.");
        }
    }

    @Override
    public void removerPorId(int id) {
        int index = -1;
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            listaProdutos.remove(index);
            System.out.println("Produto ID " + id + " removido .");
        } else {
            System.out.println("Produto ID " + id + " não encontrado.");
        }
    }
}
