
package AlacenaBeltran;

/**
 * Permite instanciar objetos de tipo producto
 * @author abeltran
 */
public class Producto {
    
    private int id;
    private String nombre;
    private float precio;
    private int unidades;
    
    public Producto(int id, String nombre,float precio,int unidades){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.unidades=unidades;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return nombre+","+precio+","+unidades;
    }
    
    /**
     * Muestra una cadena de caracteres que representa el producto en concreto
     * @return Devuelve la representación del objeto
     */
    public String show(){
        return "Codigo: "+this.id+"\nNombre: "+this.nombre+"\nPrecio: "+this.precio+"\nDescuento:\nUnidades: "+this.unidades+"u";
    }
    
    
}
