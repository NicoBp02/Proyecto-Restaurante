package proyecto;

import com.murcia.utils.ListaEnlazada; // Estructura de datos tipo lista enlazada

public class Pedido {

    // Representa el empleado que atiende el pedido
    private Empleado empleado;

    // Identificador único del pedido
    private int id;

    // Cliente asociado al pedido
    private Cliente cliente;

    // Lista enlazada para almacenar los productos del pedido (estructura dinámica)
    private ListaEnlazada<Producto> productos;

    // Total del pedido
    private double total;

    // Retorna la cantidad de productos usando size() de la lista enlazada
    public int getCantidadProductos() {
        return productos.size();
    }

    // Constructor que inicializa los datos del pedido
    public Pedido(int id, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;

        // Se instancia como clase anónima porque ListaEnlazada es abstracta
        this.productos = new ListaEnlazada<Producto>() {};
    }

    // Agrega un producto a la lista enlazada
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Recorre la lista enlazada para calcular el total del pedido
    public void calcularTotal() {
        total = 0;

        // Uso de recorrido por índice sobre estructura enlazada
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            total += p.obtenerPrecio(); // Suma el precio de cada producto
        }
    }

    // Calcula tiempo de domicilio basado en cantidad de productos
    public int calcularTiempoDomicilio() {
        return 15 + (productos.size() * 10); // Base 15 min + 10 por producto
    }

    // Retorna el total calculado
    public double obtenerTotal() {
        return total;
    }

    // Getters para acceder a los datos del pedido (encapsulamiento)
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