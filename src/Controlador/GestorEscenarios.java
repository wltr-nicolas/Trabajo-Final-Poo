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
    private boolean tutorialCompletado;
    private EvaluadorEncuentro evaluadorEncuentro;

    public GestorEscenarios(Hero jugador, EvaluadorEncuentro evaluadorEncuentro) {
        this.jugador = jugador;
        this.evaluadorEncuentro = evaluadorEncuentro;
        this.tutorialCompletado = false;

        this.escenarioActual = EscenarioFactory.crearEscenario(TipoEscenario.CARRETA);
        this.escenarioActual.iniciarEscenario(this.jugador);
    }

    public void moverJugador(int nuevoX, int nuevoY) {
        jugador.setX(nuevoX);
        jugador.setY(nuevoY);

        if (tutorialCompletado) {
            verificarTransicionDeMapas(nuevoX, nuevoY);
            if (evaluadorEncuentro.hayEncuentro(nuevoX, nuevoY)) {
                // acá después conectamos con la Vista para avisar el encuentro
            }
        }
    }

    private void verificarTransicionDeMapas(int x, int y) {
        if (x >= 95) {
            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.CALABOZO), 10, 50);
        } else if (x <= 5) {
            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.PANTANO), 90, 50);
        }
    }

    public void procesarFinTutorial() {
        if (!tutorialCompletado && !jugador.estaVivo()) {
            jugador.curar(jugador.getVidaMaxima()); // usa el curar() pendiente, en vez del truco de daño negativo
            this.tutorialCompletado = true;
            cambiarEscenario(EscenarioFactory.crearEscenario(TipoEscenario.BOSQUE), 50, 50);
        }
    }

    public void cambiarEscenario(Escenario nuevoEscenario, int spawnX, int spawnY) {
        this.escenarioActual = nuevoEscenario;
        this.jugador.setX(spawnX);
        this.jugador.setY(spawnY);
        this.escenarioActual.iniciarEscenario(jugador);
        this.escenarioActual.aplicarEfectoAmbiente(jugador);
    }

    public Escenario getEscenarioActual(){
        if ()
    }

    public boolean isTutorialCompletado() { return tutorialCompletado; }
}
