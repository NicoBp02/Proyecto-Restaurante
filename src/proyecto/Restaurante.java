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

            Pedido p = (Pedido) colaPedidos.poll();
            System.out.print(p.getId() + " ");
            colaPedidos.add(p);
        }

        System.out.println();
    }

    
    
    public Pedido buscarPedido(int id) {
    if (colaPedidos.size() == 0) return null;

    ColaEnlazada aux = new ColaEnlazada();
    Pedido encontrado = null;

    int tamaño = colaPedidos.size();

    for (int i = 0; i < tamaño; i++) {
        Pedido p = (Pedido) colaPedidos.poll();

        if (p.getId() == id && encontrado == null) {
            encontrado = p;
        }

        aux.add(p);
    }

    // Restaurar la cola original
    for (int i = 0; i < tamaño; i++) {
        colaPedidos.add(aux.poll());
    }

    return encontrado;
}
    
    
    
    
    public Pedido atenderPedidoEspecifico(int id) {
    if (colaPedidos.size() == 0) return null;

    ColaEnlazada aux = new ColaEnlazada();
    Pedido objetivo = null;

    int tamaño = colaPedidos.size();

    for (int i = 0; i < tamaño; i++) {
        Pedido p = (Pedido) colaPedidos.poll();

        if (p.getId() == id && objetivo == null) {
            objetivo = p; // ESTE es el que se atiende primero
        } else {
            aux.add(p);
        }
    }

    // Restaurar la cola SIN el pedido atendido
    while (aux.size() > 0) {
        colaPedidos.add(aux.poll());
    }

    return objetivo;
}
    
    
    
    
    public void registrarPedido(Pedido pedido) {
        colaPedidos.add(pedido);
    }

    public Pedido atenderPedido() {
        if (colaPedidos.size() > 0) {
            return (Pedido) colaPedidos.poll();
        }
        return null;
    }

    public boolean hayPedidos() {
        return colaPedidos.size() > 0;
    }

    public Caja getCaja() {
        return caja;
    }
}