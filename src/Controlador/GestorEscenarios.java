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

   public GestorEscenarios(Hero jugador, EvaluadorEncuentro evaluadorEncuentro) {
    this.jugador = jugador;
    this.evaluadorEncuentro = evaluadorEncuentro;
    this.escenarioActual = EscenarioFactory.crearEscenario(TipoEscenario.CARRETA);
    this.posicionInicial();
   }

public void posicionInicial() {
    this.jugador.setX(escenarioActual.getSpawnX());
    this.jugador.setY(escenarioActual.getSpawnY());
   }

      public void moverJugador(int nuevoX, int nuevoY) {
    this.jugador.setX(nuevoX);
    this.jugador.setY(nuevoY);

    if (evaluadorEncuentro.hayEncuentro(nuevoX, nuevoY)) {
        // Aquí se puede agregar la lógica para manejar el encuentro
        //this.combate()
    }else {
        verificarTransicionDeMapas(nuevoX, nuevoY);
        }

    }

private void verificarTransicionDeMapas(int x, int y) {
    for (TransicionMapa transicion : escenarioActual.getTransiciones()) {
        if (transicion.estaEnZonaTransicion(x, y)) {
            cambiarEscenario(
                EscenarioFactory.crearEscenario(transicion.getEscenarioDestino()),
                transicion.getSpawnX(),
                transicion.getSpawnY()
            );
            break; // ya encontramos la transición correcta, no hace falta seguir revisando las demás
        }
    }
}

    public void cambiarEscenario(Escenario nuevoEscenario, int spawnX, int spawnY) {
        this.escenarioActual = nuevoEscenario;
        this.jugador.setX(spawnX);
        this.jugador.setY(spawnY);
        this.escenarioActual.iniciarEscenario(jugador);
        this.escenarioActual.aplicarEfectoAmbiente(jugador);
    }
}

