package ProductInterfaceDAO;

public class Main {
    public static void main(String[] args) {
        ProductDAO<Producto> repo = new ProductoImpl();

        repo.guardar(new Producto(1L, "Laptop", 1500.0));
        repo.guardar(new Producto(2L, "Mouse", 25.0));
        repo.guardar(new Producto(3L, "Teclado", 80.0));

        System.out.println("Buscar ID 1: " + repo.buscarPorId(1L));
        System.out.println("Buscar ID 2: " + repo.buscarPorId(2L));
        System.out.println("Buscar ID 99: " + repo.buscarPorId(99L));
    }
}
