package proyecto;



import com.murcia.utils.ColaEnlazada;

public class Restaurante {

    private String nombre;
    private ColaEnlazada colaPedidos;
    private Caja caja;

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.colaPedidos = new ColaEnlazada();
        this.caja = new Caja();
    }
public void mostrarPedidosPendientes() {

    if (colaPedidos.size() == 0) {
        System.out.println("No hay pedidos pendientes");
        return;
    }

    System.out.print("Pedidos pendientes (IDs): ");

    int tamaño = colaPedidos.size();

    for (int i = 0; i < tamaño; i++) {

        Pedido p = (Pedido) colaPedidos.poll(); // saco

        System.out.print(p.getId() + " ");

        colaPedidos.add(p); // vuelvo a meter
    }

    System.out.println();
}
    public void registrarPedido(Pedido pedido) {
        colaPedidos.encolar(pedido);
    }

    public Pedido atenderPedido() {
        return (Pedido) colaPedidos.desencolar();
    }

    public boolean hayPedidos() {
       return colaPedidos.size() > 0;
    }

    public Caja getCaja() {
        return caja;
    }
}