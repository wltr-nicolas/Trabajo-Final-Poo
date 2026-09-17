package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioBosque extends Escenario {



    public EscenarioBosque(String nombre, String descripcion, int spawnX, int spawnY) {
        super(nombre, descripcion, spawnX, spawnY);
    }

    @Override
    public void iniciarEscenario(Hero jugador) {
        System.out.println("=== ENTRANDO AL BOSQUE DE LAS SOMBRAS ===");
        System.out.println("El crujido de las hojas te pone en alerta. Hay criaturas acechando entre los árboles.");
    }

    @Override // le agregamos efectos ambientales?????
    public void aplicarEfectoAmbiente(Hero jugador) {
        // Efecto del bosque: puede haber enemigos ocultos y objetos raros
        System.out.println("En la vegetacion densa se pueden dislumbrar objeto raros y enemigos ocultos.");
    } 
}
