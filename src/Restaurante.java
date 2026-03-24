

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

    public void registrarPedido(Pedido pedido) {
        colaPedidos.encolar(pedido);
    }

    public Pedido atenderPedido() {
        return (Pedido) colaPedidos.desencolar();
    }

    public boolean hayPedidos() {
        return !colaPedidos.estaVacia();
    }

    public Caja getCaja() {
        return caja;
    }
}