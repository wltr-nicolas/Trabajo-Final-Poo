import  java.util.ArrayList;

public abstract class Personaje {
    
    /*Nivel de visibilidad (protected vs. private)
El problema/riesgo: Poner los atributos en protected permite que cualquier clase hija (y cualquier clase dentro del mismo paquete)
modifique los valores directamente sin pasar por validaciones.
Solución: Aplicar encapsulamiento estricto definiendo los atributos como private y dando acceso a los hijos mediante métodos
 Getters y Setters o métodos de lógica (ejemplo: recibirDano()). */

    private String nombre; 
    private int vidaMaxima;
    private int vidaActual;
    private int tamanio;
    private int x;
    private int y;
    private int danio;
    private int armadura;
    private ArrayList <Item> items;


    
    public Personaje(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura ) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.tamanio = tamanio;
        this.x = x;
        this.y = y;
        this.danio = danio;
        this.armadura = armadura;
        this.items = new ArrayList<>();

    }
    
    public void recibirDano(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

// MÉTODOS ABSTRACTOS:  para Hero y Enemigo
    public abstract void realizarAccionAtacar();
    public abstract void realizarAccionDefender();
    public abstract void ejecutarAccionAdicional();

    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public String getNombre() { return nombre; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getVidaActual() { return vidaActual; }
    public int getDanio() { return danio; }
    public int getArmadura() { return armadura; }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public ArrayList<Item> getItems() { return items; }
    
}


