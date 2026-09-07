public class Arma extends Item {

    private int caraDadoDanio; // el daño que hace el arma, que se determina con un dado de x caras;

    public Arma(String nombre, String descripcion, int precio, int caraDadoDanio) {
        super(nombre, descripcion, precio);
        this.caraDadoDanio = caraDadoDanio;


    }

    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public int getCaraDadoDanio() { return caraDadoDanio; }
}
