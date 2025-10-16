import java.util.ArrayList;

public class FuncionarioRepository implements Repository<Funcionario> {
    
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Funcionario funcionario) {
        Funcionario novoFuncionario = new Funcionario(
            proximoId, 
            funcionario.getNome(), 
            funcionario.getSalario(), 
            funcionario.getMatricula()
        );
        
        listaFuncionarios.add(novoFuncionario);
        System.out.println("Funcionário " + novoFuncionario.getNome() + " adicionado ID: " + novoFuncionario.getId());
        proximoId++;
    }

    @Override
    public void listar() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("\nLista de Funcionários");
        for (Funcionario f : listaFuncionarios) {
            System.out.println(f);
        }
        System.out.println("-----------------------------\n");
    }

    @Override
    public Funcionario buscarPorId(int id) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            Funcionario funcionario = listaFuncionarios.get(i);
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null; 
    }

    @Override
    public void atualizar(Funcionario funcionarioAtualizado) {
        int index = -1;
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getId() == funcionarioAtualizado.getId()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            listaFuncionarios.set(index, funcionarioAtualizado);
            System.out.println("Funcionário ID " + funcionarioAtualizado.getId() + " atualizado.");
        } else {
            System.out.println("Erro: Funcionário ID " + funcionarioAtualizado.getId() + " não encontrado para atualização.");
        }
    }

    @Override
    public void removerPorId(int id) {
        int index = -1;
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            listaFuncionarios.remove(index);
            System.out.println("Funcionário ID: " + id + " removido .");
        } else {
            System.out.println("Funcionário ID: " + id + " não encontrado.");
        }
    }
}
