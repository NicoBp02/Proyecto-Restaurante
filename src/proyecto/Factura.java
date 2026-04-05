package proyecto;

public class Factura {
    private int numero;
    private Pedido pedido;
    private double total;
    private boolean pagada;

    public Factura(int numero, Pedido pedido) {
        this.numero = numero;
        this.pedido = pedido;
        this.pagada = false;
    }

    public void generarTotal() {
        if (pedido != null) {
            pedido.calcularTotal();
            total = pedido.obtenerTotal();
        }
    }

    public void marcarComoPagada() {
        pagada = true;
    }

    public double obtenerTotal() {
        return total;
    }

    public boolean estaPagada() {
        return pagada;
    }
}
