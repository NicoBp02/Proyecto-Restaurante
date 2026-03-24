/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiante
 */
public class Restaurante {
   private String nombre;
    private Pedido pedido1;
    private Pedido pedido2;

    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    public boolean registrarPedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }

        if (pedido1 == null) {
            pedido1 = pedido;
            return true;
        } else if (pedido2 == null) {
            pedido2 = pedido;
            return true;
        }

        return false; // ya hay 2 pedidos
    }

    public void mostrarPedidos() {

        if (pedido1 != null) {
            pedido1.calcularTotal();
            System.out.println("Pedido 1 Total: " + pedido1.obtenerTotal());
        }

        if (pedido2 != null) {
            pedido2.calcularTotal();
            System.out.println("Pedido 2 Total: " + pedido2.obtenerTotal());
        }
    }

    public String getNombre() {
        return nombre;
    }
}
