package proyecto;



import com.murcia.utils.ListaEnlazada;

public class Pedido {
private Empleado empleado;
    private int id;
    private Cliente cliente;
    private ListaEnlazada<Producto> productos;
    private double total;
public int getCantidadProductos() {
    return productos.size();
}
    public Pedido(int id, Cliente cliente,Empleado empleado ) {
        this.id = id;
        this.cliente = cliente; 
        this.empleado = empleado;
        this.productos = new ListaEnlazada<Producto>() {}; 
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
    public Empleado getEmpleado() {
        return empleado;
    }
}