
import java.util.Random;
import Modelo.Dado;
import Modelo.Escenario.ZonaCombate;
import Modelo.Personaje.Hero;
import Controlador.GestorEscenarios;
import Vista.EscenarioVista;


   public class App {

   public static void main(String[] args) throws Exception{
      //System.out.println("Hello, World");

      Dado dado = new Dado(6);
      ZonaCombate zonaCombate = new ZonaCombate(dado, 3); // Ejemplo de creación de una zona de combate
      Hero jugador = new Hero("Walter", 100, 10, 5, 1, 10, 5);
      GestorEscenarios gestorEscenarios = new GestorEscenarios(jugador, zonaCombate);
      EscenarioVista escenarioVista = new EscenarioVista(gestorEscenarios);




   }
}