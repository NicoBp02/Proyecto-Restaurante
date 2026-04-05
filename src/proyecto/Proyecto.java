/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import com.murcia.utils.Input;
/**
 *
 * @author Estudiante
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
int opcion;
Restaurante restaurante = new Restaurante("Mi Restaurante");
        do {
            System.out.println("\n=== MENU SISTEMA DE PEDIDOS ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Atender pedido");
            System.out.println("3. Ver dinero en caja");
            System.out.println("4. Salir");

       opcion = Input.nextInt("Seleccione una opcion: ");

            switch (opcion) {

                case 1:
                    System.out.println("Registrar pedido...");
                    String nombre = Input.next("Nombre del cliente: ");
                    String telefono = Input.next("Telefono: ");

                    Cliente cliente = new Cliente(nombre, telefono);

                    int idPedido = Input.nextInt("ID del pedido: ");
                    Pedido pedido = new Pedido(idPedido, cliente);

                    int cantidad = Input.nextInt("Cantidad de productos: ");

                    for (int i = 0; i < cantidad; i++) {

                        String nombreProducto = Input.next("Producto: ");
                        float precio = Input.nextFloat("Precio: ");

                        Producto producto = new Producto(nombreProducto, precio);
                        pedido.agregarProducto(producto);
                    }

                    restaurante.registrarPedido(pedido);

                    System.out.println("Pedido registrado correctamente");
                    break;


                case 2:
                    System.out.println("Atender pedido...");
                      if (restaurante.hayPedidos()) {

                        Pedido p = restaurante.atenderPedido();

                        p.calcularTotal();

                        System.out.println("\n=== PEDIDO ATENDIDO ===");
                        System.out.println("ID: " + p.getId());
                        System.out.println("Cliente: " + p.getCliente().getNombre());
                        System.out.println("Total: " + p.obtenerTotal());

                        int tiempo = p.calcularTiempoDomicilio();
                        System.out.println("Tiempo estimado: " + tiempo + " minutos");

                        // FACTURA Y CAJA
                        Factura factura = new Factura(p.getId(), p);
                        factura.generarTotal();

                        restaurante.getCaja().registrarFactura(factura);
                        restaurante.getCaja().procesarPago();

                        System.out.println(" Pago procesado correctamente");
 //  MOSTRAR LOS QUE FALTAN
        restaurante.mostrarPedidosPendientes();

                    } else {
                        System.out.println(" No hay pedidos en la cola");
                    }

                    break;

                case 3:
                    System.out.println("Ver dinero en caja...");
                      System.out.println("\n=== CAJA ===");
                    System.out.println("Dinero en caja: " + restaurante.getCaja().getDineroEnCaja());

                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }
    }
    

