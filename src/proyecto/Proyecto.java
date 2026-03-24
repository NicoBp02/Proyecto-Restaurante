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

        do {
            System.out.println("\n=== MENÚ SISTEMA DE PEDIDOS ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Atender pedido");
            System.out.println("3. Ver dinero en caja");
            System.out.println("4. Salir");

       opcion = Input.nextInt("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    System.out.println("Registrar pedido...");
                    break;

                case 2:
                    System.out.println("Atender pedido...");
                    break;

                case 3:
                    System.out.println("Ver dinero en caja...");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);
    }
    }
    

