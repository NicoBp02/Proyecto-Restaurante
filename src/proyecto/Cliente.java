package proyecto;

public class Cliente {
    private String nombre;
    private String telefono;
    private boolean vip;

    public Cliente(String nombre, String telefono, boolean vip) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.vip = vip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean esVip() {
        return vip;
    }
}