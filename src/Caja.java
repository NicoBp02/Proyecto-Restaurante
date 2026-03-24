
import com.murcia.utils.ColaEnlazada;
public class Caja {
      private double dineroEnCaja;
    private ColaEnlazada colaFacturas;

    public Caja() {
        dineroEnCaja = 0;
        colaFacturas = new ColaEnlazada();
    }

    public void registrarFactura(Factura factura) {
        colaFacturas.encolar(factura);
    }

    public void procesarPago() {

        if (!colaFacturas.estaVacia()) {

            Factura f = (Factura) colaFacturas.desencolar();

            if (!f.estaPagada()) {
                dineroEnCaja += f.obtenerTotal();
                f.marcarComoPagada();

                System.out.println("Factura pagada: " + f.obtenerTotal());
            }
        }
    }

    public double getDineroEnCaja() {
        return dineroEnCaja;
    }
}
