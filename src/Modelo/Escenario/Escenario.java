package Modelo.Escenario;

import java.util.ArrayList;
import Modelo.Item;
import Modelo.Personaje.Enemigo;
import Modelo.Personaje.Hero;

public abstract class Escenario {

    // Atributos privados (Encapsulamiento)
    private String nombre;
    private String descripcion;
    private ArrayList<Enemigo> enemigosDisponibles;
    private ArrayList<Item> dropsDelEscenario;

    // Constructor de la clase madre
    public Escenario(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enemigosDisponibles = new ArrayList<>();
        this.dropsDelEscenario = new ArrayList<>();
    }

    // --- MÉTODOS CONCRETOS (Comunes a todos los biomas) ---

    public void agregarEnemigo(Enemigo enemigo) {
        this.enemigosDisponibles.add(enemigo);
    }

    public void agregarItemDrop(Item item) {
        this.dropsDelEscenario.add(item);
    }

    public boolean hayEnemigosVivos() {
        for (Enemigo e : enemigosDisponibles) {
            if (e.estaVivo()) {
                return true; // Queda al menos uno con vida
            }
        }
        return false;
    }

    // --- MÉTODOS ABSTRACTOS (Cada bioma le da su propia lógica) ---

    // Define qué pasa cuando el jugador llega al bioma (ej: mostrar texto, cambiar música o fondo)
    public abstract void iniciarEscenario(Hero jugador);

    // Define efectos especiales del clima o bioma (ej: la nieve frena, la cueva quita visibilidad)
    public abstract void aplicarEfectoAmbiente(Hero jugador);

    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public ArrayList<Enemigo> getEnemigosDisponibles() { return enemigosDisponibles; }
    public ArrayList<Item> getDropsDelEscenario() { return dropsDelEscenario; }
}