public interface Repository<T> {
    void adicionar(T item);
    void listar();
    T buscarPorId(int id);
    void atualizar(T item);
    void removerPorId(int id);
}
