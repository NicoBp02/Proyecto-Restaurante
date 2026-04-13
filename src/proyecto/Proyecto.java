
package proyecto;
import com.murcia.utils.Input;

public class Proyecto {

    public static void main(String[] args) {
int opcion;
Restaurante restaurante = new Restaurante("Mi Restaurante");
        do {
            System.out.println("\n=== MENU SISTEMA DE PEDIDOS ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Atender pedido");
            System.out.println("3. Ver dinero en caja");
            System.out.println("4. Buscar pedido");
            System.out.println("5. Atender pedido especifico ");
            System.out.println("6. Salir");
            
         // Se usa Input de la librería para validar entrada numérica
       opcion = Input.nextInt("Seleccione una opcion: ");

            switch (opcion) {

                case 1:
                    System.out.println("Registrar pedido...");          
                       // Se crea el empleado que atiende el pedido
                    String nombreEmp = Input.next("Empleado: ");
                    Empleado emp = new Empleado(nombreEmp);
                    // Se crean los datos del cliente
                    String nombre = Input.next("Nombre del cliente: ");
                    String telefono = Input.next("Telefono: ");

                    Cliente cliente = new Cliente(nombre, telefono);
     // Se crea el pedido con cliente y empleado
                    int idPedido = Input.nextInt("ID del pedido: ");
                    Pedido pedido = new Pedido(idPedido, cliente, emp);
// Se define la cantidad de productos a ingresar
                    int cantidad = Input.nextInt("Cantidad de productos: ");
// Se usa un ciclo para agregar múltiples productos al pedido
                    for (int i = 0; i < cantidad; i++) {

                        String nombreProducto = Input.next("Producto: ");
                        float precio = Input.nextFloat("Precio: ");
// Cada producto se agrega a una lista enlazada
                        Producto producto = new Producto(nombreProducto, precio);
                        pedido.agregarProducto(producto);
                    }
// El pedido se encola (FIFO) en el restaurante
                    restaurante.registrarPedido(pedido);

                    System.out.println("Pedido registrado correctamente");
                    break;


                case 2:
                    System.out.println("Atender pedido...");
                    // Se verifica si hay pedidos en la cola
                      if (restaurante.hayPedidos()) {
      // Se atiende el primer pedido (FIFO)
                        Pedido p = restaurante.atenderPedido();
// Validación de seguridad
    if (p == null) {
        System.out.println("Error: no se pudo atender el pedido");
        break;
    }
    // Se calcula el total recorriendo la lista enlazada
                        p.calcularTotal();

                        System.out.println("\n=== PEDIDO ATENDIDO ===");
                        System.out.println("ID: " + p.getId());
                        System.out.println("Cliente: " + p.getCliente().getNombre());

                        // Se valida si el pedido tiene empleado asignado
                        if (p.getEmpleado() != null) {
                            System.out.println("Atendido por: " + p.getEmpleado().getNombre());
                        } else {
                            System.out.println("Atendido por: No asignado");
                        }

                        System.out.println("Total: " + p.obtenerTotal());

                        // Se calcula tiempo basado en cantidad de productos
                        int tiempo = p.calcularTiempoDomicilio();
                        System.out.println("Tiempo estimado: " + tiempo + " minutos");

                        // Se obtiene el tamaño de la lista enlazada
                        System.out.println("Cantidad de productos: " + p.getCantidadProductos());

                        // Se genera factura asociada al pedido
                        Factura factura = new Factura(p.getId(), p);
                        factura.generarTotal();

                        // Se encola la factura en caja para procesar pago
                        restaurante.getCaja().registrarFactura(factura);

                        // Se procesa el pago (FIFO en cola de facturas)
                        restaurante.getCaja().procesarPago();

                        System.out.println(" Pago procesado correctamente");

                        // Se muestran los pedidos restantes sin perder la cola
                        restaurante.mostrarPedidosPendientes();

                    } else {
                        System.out.println(" No hay pedidos en la cola");
                    }

                    break;

                case 3:
                    System.out.println("Ver dinero en caja...");

                    // Se consulta el dinero acumulado en caja
                    System.out.println("\n=== CAJA ===");
                    System.out.println("Dinero en caja: " + restaurante.getCaja().getDineroEnCaja());

                    break;

                    case 4: //buscar pedido
                       
    int idBuscar = Input.nextInt("Ingrese ID del pedido: ");
    Pedido encontrado = restaurante.buscarPedido(idBuscar);
                        System.out.println("------------------------");
    if (encontrado != null) {
        System.out.println("Pedido encontrado:");
        System.out.println("Cliente: " + encontrado.getCliente().getNombre());
        System.out.println("Cantidad productos: " + encontrado.getCantidadProductos());
    } else {
        System.out.println("Pedido no encontrado");
    }
    break;
                    
    case 5: //priorizar y atender pedidos especificos 
    int idAtender = Input.nextInt("ID del pedido a priorizar: ");
    Pedido p = restaurante.atenderPedidoEspecifico(idAtender);

    if (p != null) {
        p.calcularTotal();

        System.out.println("\n=== PEDIDO PRIORITARIO ATENDIDO ===");
        System.out.println("ID: " + p.getId());
        System.out.println("Cliente: " + p.getCliente().getNombre());
        System.out.println("Total: " + p.obtenerTotal());

        Factura factura = new Factura(p.getId(), p);
        factura.generarTotal();

        restaurante.getCaja().registrarFactura(factura);
        restaurante.getCaja().procesarPago();

    } else {
        System.out.println("Pedido no encontrado");
    }
    break;
    
                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 6); // Ciclo hasta que el usuario decida salir
    }
}
