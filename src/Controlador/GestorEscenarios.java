package Controlador;

import Modelo.Escenario.EvaluadorEncuentro;
import Modelo.Escenario.TipoEscenario;
import Modelo.Escenario.Escenario;
import Modelo.Personaje.Hero;
import Modelo.Escenario.EscenarioFactory;

public class GestorEscenarios {

    private Escenario escenarioActual;
    private Hero jugador;
    private boolean tutorialCompletado;
    private EvaluadorEncuentro evaluadorEncuentro;

    // Inyección de dependencias a través del constructor
    public GestorEscenarios(Hero jugador, EvaluadorEncuentro evaluadorEncuentro) {
        this.jugador = jugador;
        this.evaluadorEncuentro = evaluadorEncuentro;
        this.tutorialCompletado = false;

        // Inicia con la fábrica respetando SOLID: OCP (Open/Closed Principle (Principio de Abierto/Cerrado))
        //  y DIP (Dependency Inversion Principle (Principio de Inversión de Dependencias))
        this.escenarioActual = EscenarioFactory.crearEscenario(TipoEscenario.CARRETA);
        this.escenarioActual.iniciarEscenario(this.jugador);
    }

    /**
     * Mueve al jugador a una nueva posición dentro del mapa y evalúa eventos.
     */
    public void moverJugador(int nuevoX, int nuevoY) {
        jugador.setX(nuevoX);
        jugador.setY(nuevoY);

        if (tutorialCompletado) {
            verificarTransicionDeMapas(nuevoX, nuevoY);
            if (evaluadorEncuentro.hayEncuentro(nuevoX, nuevoY)) {
                System.out.println("¡Un enemigo apareció entre la hierba alta!");
            }
        }
    }

    /**
     * Controla las fronteras para cambiar de bioma
     */
    private void verificarTransicionDeMapas(int x, int y) {
        if (x >= 95) {
            System.out.println("Entrando a la cueva...");
            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.CALABOZO), 10, 50);
        } else if (x <= 5) {
            System.out.println("Entrando al pantano...");
            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.PANTANO), 90, 50);
        }
    }

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

    /**
     * Cambia la referencia del escenario actual y reubica al jugador
     */
    public void cambiarEscenario(Escenario nuevoEscenario, int spawnX, int spawnY) {
        this.escenarioActual = nuevoEscenario;
        this.jugador.setX(spawnX);
        this.jugador.setY(spawnY);

        this.escenarioActual.iniciarEscenario(jugador);
        this.escenarioActual.aplicarEfectoAmbiente(jugador);
    }

    // Getters
    public Escenario getEscenarioActual() {
        return escenarioActual;
    }

    public boolean isTutorialCompletado() {
        return tutorialCompletado;
    }
}

/*  Este archivo es la clase controladora central de la navegación y flujo del juego 
(GestorEscenarios.java), responsable de conectar las acciones del jugador en el mapa 2D 
con la lógica de los biomas y eventos.

Qué hace paso a paso?
1_ Inicialización e Inyección de Dependencias (Constructor):
  .Recibe el Hero y el EvaluadorEncuentro desde afuera (Inyección de Dependencias).
  .Arranca la partida en el escenario inicial de la CARRETA instanciándolo 
   mediante EscenarioFactory.
  .Inicializa la bandera tutorialCompletado = false.
2_ Movimiento del Jugador (moverJugador):
  .Actualiza las coordenadas del jugador.
  .Si el tutorial ya terminó, verifica si el jugador cruzó los límites del mapa para cambiar de bioma.
  .Consulta al EvaluadorEncuentro si hay un encuentro en la nueva posición.
3_ Transición de Mapas (verificarTransicionDeMapas):
  .Si el jugador cruza los límites del mapa (x >= 95 o x <= 5), cambia al escenario correspondiente 
  (CALABOZO o PANTANO) y lo reubica. 
4_ Fin del Tutorial (procesarFinTutorial):
  .Detecta si el jugador fue derrotado durante la batalla de la carreta. 
  .Si el jugador muere durante el tutorial, se activa un evento narrativo que lo rescata y lo 
  transporta al BOSQUE.
5_ Cambio de Escenario (cambiarEscenario):
   Reemplaza el objeto escenarioActual por el nuevo bioma, reubica las coordenadas del personaje 
   en el nuevo punto de aparición (spawn) e inicializa los efectos del entorno.
 */