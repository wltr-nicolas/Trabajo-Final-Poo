package Controlador;

import Modelo.Escenario.EvaluadorEncuentro;
import Modelo.Escenario.TipoEscenario;
import Modelo.Escenario.Escenario;
import Modelo.Personaje.Hero;
import Modelo.Escenario.EscenarioFactory;
import Modelo.Escenario.TransicionMapa;

public class GestorEscenarios {

    private Escenario escenarioActual;
    private Hero jugador;
    private EvaluadorEncuentro evaluadorEncuentro;
    private boolean tutorialCompletado = false;

   public GestorEscenarios(Hero jugador, EvaluadorEncuentro evaluadorEncuentro) {
    this.jugador = jugador;
    this.evaluadorEncuentro = evaluadorEncuentro;
    this.escenarioActual = EscenarioFactory.crearEscenario(TipoEscenario.CARRETA);
    this.posicionInicial();
   }

public boolean procesarFinTutorial() {
    if (!tutorialCompletado && !jugador.estaVivo()) {
        jugador.curar(jugador.getVidaMaxima());
        this.tutorialCompletado = true;
        cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.BOSQUE), 50, 50);
        return true; // Informa que el tutorial finalizó en este llamado
    }
    return false; // Informa que el tutorial no ha acabado
}
    

public void posicionInicial() {
    this.jugador.setX(escenarioActual.getSpawnX());
    this.jugador.setY(escenarioActual.getSpawnY());
   }

public boolean moverJugador(int nuevoX, int nuevoY) {
    boolean huboRescate = procesarFinTutorial(); //  llamada, resultado guardado
    if (huboRescate) {
        return true; // cortamos ACÁ, antes de tocar la posición con nuevoX/nuevoY
    }

    this.jugador.setX(nuevoX);
    this.jugador.setY(nuevoY);

    if (evaluadorEncuentro.hayEncuentro(nuevoX, nuevoY)) {
        return true; // Se encontró un encuentro, se detiene el movimiento y se inicia el combate
        // acá se conecta el combate más adelante
    } else {
         // No hay encuentro, el jugador puede seguir moviéndose
        verificarTransicionDeMapas(nuevoX, nuevoY);
        return false; // No hubo encuentro, el jugador puede seguir moviéndose  
    }
}

public enum ResultadoMovimiento {
    ENCUENTRO, 
    RESCATE_TUTORIAL, 
    TRANSICION_ESCENARIO,
    SIN_EVENTO
}


private boolean verificarTransicionDeMapas(int x, int y) {
    for (TransicionMapa transicion : escenarioActual.getTransiciones()) {
        if (transicion.estaEnZonaTransicion(x, y)) {
            cambiarEscenario(
                EscenarioFactory.crearEscenario(transicion.getEscenarioDestino()),
                transicion.getSpawnX(),
                transicion.getSpawnY()
            );
            return true; // La transición fue realizada
        }
    }
    return false; // No hubo transición de mapa
}

    public void cambiarEscenario(Escenario nuevoEscenario, int spawnX, int spawnY) {
        this.escenarioActual = nuevoEscenario;
        this.jugador.setX(spawnX);
        this.jugador.setY(spawnY);
        this.escenarioActual.iniciarEscenario(jugador);
        this.escenarioActual.aplicarEfectoAmbiente(jugador);
    }


public Escenario getEscenarioActual() { return escenarioActual; }
}


