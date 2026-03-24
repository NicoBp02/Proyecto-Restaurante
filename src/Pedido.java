

import com.murcia.utils.ListaEnlazada;

public class Pedido {

    private int id;
    private Cliente cliente;
    private ListaEnlazada<Producto> productos;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ListaEnlazada<Producto>() {}; // 🔥 SOLUCIÓN
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void calcularTotal() {
        total = 0;

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            total += p.obtenerPrecio();
        }
    }

    public int calcularTiempoDomicilio() {
        return 15 + (productos.size() * 10);
    }

    public double obtenerTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
}