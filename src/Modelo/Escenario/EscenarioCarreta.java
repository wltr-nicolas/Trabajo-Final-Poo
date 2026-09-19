package Modelo.Escenario;
import Modelo.Personaje.Hero;

public class EscenarioCarreta extends Escenario {

    public EscenarioCarreta(String nombre, String descripcion, int spawnX, int spawnY) {
        super(nombre, descripcion, spawnX, spawnY);
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