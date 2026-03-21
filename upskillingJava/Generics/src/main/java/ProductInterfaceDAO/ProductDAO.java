package ProductInterfaceDAO;

public interface ProductDAO<T> {
    void guardar(T t);
    T buscarPorId(Long id);
}
