package Vista;

import Modelo.Escenario.EscenarioFactory;
import Modelo.Escenario.TipoEscenario;

public class Escenario {

        /**
     * Evalúa si la batalla del tutorial terminó en derrota del héroe
     */
    public void procesarFinTutorial() {
        if (!tutorialCompletado && !jugador.estaVivo()) {
            System.out.println("\n==================================================");
            System.out.println("¡Aparece el Tabernero (Aventurero Rango SSS)!");
            System.out.println("Los bandidos huyen aterrados.");
            System.out.println("Tabernero: 'Te rescaté a tiempo. Debes buscar recursos en el bosque.'");
            System.out.println("==================================================\n");

            jugador.recibirDanio(-jugador.getVidaMaxima()); 
            this.tutorialCompletado = true;

            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.BOSQUE), 50, 50);
        }
    }
    
}
