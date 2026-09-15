package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioBosque extends Escenario {

    public EscenarioBosque() {
        super("Bosque de las Sombras", 
              "Un frondoso bosque habitado por animales salvajes y criaturas místicas.");
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
