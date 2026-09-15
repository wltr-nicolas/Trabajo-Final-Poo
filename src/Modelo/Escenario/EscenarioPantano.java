package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioPantano extends Escenario {

    public EscenarioPantano() {
        super("Pantano Putrefacto", 
              "Una ciénaga peligrosa llena de agua estancada y vapores tóxicos.");
    }

    @Override
    public void iniciarEscenario(Hero jugador) {
        System.out.println("=== ENTRANDO AL PANTANO PUTREFACTO ===");
        System.out.println("El lodo dificulta tus pasos y el hedor a veneno casi no te deja respirar.");
    }

    @Override // le agregamos efectos ambientales?????
    public void aplicarEfectoAmbiente(Hero jugador) {
        // El tóxico del pantano puede restar un pequeño porcentaje de vida al jugador
        int danioPant = 2;
        jugador.recibirDanio(danioPant);
        System.out.println("Los vapores tóxicos del pantano te hacen " + danioPant + " de daño por turno.");
    } 
}