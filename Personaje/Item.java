

public class Item {

    private String nombre;
    private String descripcion;
    private int precio;
    

    public Item(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getPrecio () { return precio; }
    
    @Override
    public String toString() {
        return nombre;
    }


}