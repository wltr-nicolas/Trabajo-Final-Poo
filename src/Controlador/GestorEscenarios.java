package Controlador;

import Modelo.Escenario.EvaluadorEncuentro;
import Modelo.Escenario.TipoEscenario;
import Modelo.Escenario.Escenario;
import Modelo.Personaje.Hero;
import Modelo.Escenario.EscenarioFactory;
import Modelo.Escenario.TransicionMapa;
import Modelo.Personaje.Enemigo;
import Modelo.Dado;
import java.util.ArrayList;

public class GestorEscenarios {

    private Escenario escenarioActual;
    private Hero jugador;
    private EvaluadorEncuentro evaluadorEncuentro;
    private boolean tutorialCompletado = false;
    private EstadoJuego estadoJuego = EstadoJuego.MAPA; // Estado inicial del juego

   public GestorEscenarios(Hero jugador, EvaluadorEncuentro evaluadorEncuentro) {
    this.jugador = jugador;
    this.evaluadorEncuentro = evaluadorEncuentro;
    this.escenarioActual = EscenarioFactory.crearEscenario(TipoEscenario.CARRETA);
    this.posicionInicial();
   }

public GestorDeBatalla iniciarCombate() {
    ArrayList<Enemigo> disponibles = escenarioActual.getEnemigosDisponibles();

    if (disponibles.isEmpty()) {
        throw new IllegalStateException("El escenario " + escenarioActual.getNombre() + " no tiene enemigos configurados.");
    }

    Dado dadoSeleccion = new Dado(disponibles.size());
    Enemigo enemigoElegido = disponibles.get(dadoSeleccion.lanzar() - 1);

    return new GestorDeBatalla(jugador, enemigoElegido);
}//se agrega el gestor de batalla

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

public ResultadoMovimiento moverJugador(int nuevoX, int nuevoY) {
    boolean huboRescate = procesarFinTutorial();
    if (huboRescate) {
        return ResultadoMovimiento.RESCATE_TUTORIAL;
    }
    // si llegamos hasta acá, es porque NO hubo rescate (el return de arriba ya filtró ese case)

    this.jugador.setX(nuevoX);
    this.jugador.setY(nuevoY);

    if (evaluadorEncuentro.hayEncuentro(nuevoX, nuevoY)) {
        return ResultadoMovimiento.ENCUENTRO;
    }
    // si llegamos hasta acá, es porque NO hubo rescate NI encuentro

    boolean huboTransicion = verificarTransicionDeMapas(nuevoX, nuevoY);
    if (huboTransicion) {
        return ResultadoMovimiento.TRANSICION_ESCENARIO;
    } else {
        return ResultadoMovimiento.SIN_EVENTO;
    }
}

public enum ResultadoMovimiento { //PREGUNTARLE AL PROFESOR SI LO SACO (HACER UN ENUM.JAVA EN CONTROLADORES O MODELOS) O ESTA BIEN DEJARLO
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
public EstadoJuego getEstadoJuego() { return estadoJuego; }

public int getPosicionJugadorX() { return jugador.getX(); }
public int getPosicionJugadorY() { return jugador.getY(); }
}


