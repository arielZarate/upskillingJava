package ProductInterfaceDAO;

import java.util.HashMap;
import java.util.Map;

public class ProductoImpl implements ProductDAO<Producto> {

    //una map product en memoria
    private Map<Long, Producto> productos = new HashMap<>();

    @Override
    public void guardar(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productos.get(id);
    }
}
