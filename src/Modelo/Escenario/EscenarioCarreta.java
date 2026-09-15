package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioCarreta extends Escenario {

    public EscenarioCarreta() {
        super("Camino Real - Asalto a la Carreta", 
              "Un camino empedrado, se rompe tu carreta tratas de repararla y en ese momento fuiste emboscado por una banda de ladrones.");
    }

    @Override
    public void iniciarEscenario(Hero jugador) {
        System.out.println("=== ¡ASALTO EN LA CARRETA! ===");
        System.out.println("Los ladrones han rodeado tu vehículo. ¡Prepárate para defender tus recursos!");
    }

    @Override // le agregamos efectos ambientales?????
    public void aplicarEfectoAmbiente(Hero jugador) {
        // Terreno despejado: no aplica efectos negativos
        System.out.println("El terreno despejado permite un combate directo.");
    } 
}