public abstract class Enemigo extends Personaje {

    private Item drop; // el ítem que este enemigo suelta al morir

    public Enemigo(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) {
        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);

    }

    public abstract Item generarDrop(); // cada enemigo decide qué suelta

    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public Item getDrop() {
        return drop;
    }

}