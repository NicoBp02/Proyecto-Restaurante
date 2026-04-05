package proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiante
 */
public class Empleado {
       private String nombre;
    

    public Empleado(String nombre) {
        this.nombre = nombre;
     
    }
public String getNombre() {
        return nombre;
    }
/*
    public void tomarPedido(Pedido pedido) {
        if (pedido != null) {
            System.out.println("Empleado " + nombre + " tomó el pedido " + pedido.getId());
        }
    }
*/
}
