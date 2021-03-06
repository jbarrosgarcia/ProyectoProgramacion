package AlacenaBeltran;

/**
 * Clase empleado, representa cada trabajador de la tienda o local que se quiere
 * gestionar
 *
 * @author abeltran
 */
public class Empleado {

    private int id;
    private String nombre;
    private String password;

    public Empleado(int id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + '}';
    }

}
