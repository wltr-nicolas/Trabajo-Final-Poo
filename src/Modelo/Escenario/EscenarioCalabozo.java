package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioCalabozo extends Escenario {

    public EscenarioCalabozo(String nombre, String descripcion, int spawnX, int spawnY) {
        super(nombre, descripcion, spawnX, spawnY);
    }

    @Override
    public void iniciarEscenario(Hero jugador) {
        System.out.println("=== DESCENDIENDO AL CALABOZO ===");
        System.out.println("El aire se vuelve frío y pesado. Las antorchas apenas iluminan el camino.");
    }

    @Override // le agregamos efectos ambientales?????
    public void aplicarEfectoAmbiente(Hero jugador) {
        // La oscuridad reduce la efectividad o causa daño leve por trampas
        System.out.println("La oscuridad del calabozo reduce tu visión. Cuidado con las trampas.");
    } 
}
