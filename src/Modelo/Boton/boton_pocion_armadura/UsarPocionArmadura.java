package Modelo.Boton.boton_pocion_armadura;

import Controlador.GestorDeBatalla;
import Modelo.Boton.Accion;

public class UsarPocionArmadura implements Accion {

    private GestorDeBatalla gestorDeBatalla;

    public UsarPocionArmadura(GestorDeBatalla gestorDeBatalla) {
        this.gestorDeBatalla = gestorDeBatalla;
    }

    @Override
    public void ejecutar() {
        gestorDeBatalla.turnoJugadorUsarPocionArmadura();
    }
}