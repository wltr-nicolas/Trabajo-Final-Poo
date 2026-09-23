package Modelo.Boton.boton_finalizar_turno;

import Controlador.GestorDeBatalla;
import Modelo.Boton.Accion;

public class FinalizarTurno implements Accion {

    private GestorDeBatalla gestorDeBatalla;

    public FinalizarTurno(GestorDeBatalla gestorDeBatalla) {
        this.gestorDeBatalla = gestorDeBatalla;
    }

    @Override
    public void ejecutar() {
        gestorDeBatalla.finalizarTurno();
    }
}