/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudiante
 */
public class Pedido {
    
  private int id;
    private Cliente cliente;
    private Producto producto1;
    private Producto producto2;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }

        if (producto1 == null) {
            producto1 = producto;
            return true;
        } else if (producto2 == null) {
            producto2 = producto;
            return true;
        }

        return false; // ya hay 2 productos
    }

    public void calcularTotal() {
        total = 0;

        if (producto1 != null) {
            total += producto1.obtenerPrecio();
        }

        if (producto2 != null) {
            total += producto2.obtenerPrecio();
        }
    }

    public double obtenerTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
