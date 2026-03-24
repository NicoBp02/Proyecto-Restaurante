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
    private String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public void tomarPedido(Pedido pedido) {
        if (pedido != null) {
            System.out.println("Empleado " + nombre + " tomó el pedido " + pedido.getId());
        }
    }
}
