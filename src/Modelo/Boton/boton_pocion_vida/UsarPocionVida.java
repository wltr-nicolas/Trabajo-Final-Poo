package Modelo.Boton.boton_pocion_vida;

import Controlador.GestorDeBatalla;
import Modelo.Boton.Accion;
import Modelo.Dado;

public class UsarPocionVida implements Accion {

    private GestorDeBatalla gestorDeBatalla;
    private Dado dadoVida;

    public UsarPocionVida(GestorDeBatalla gestorDeBatalla) {
        this.gestorDeBatalla = gestorDeBatalla;
        this.dadoVida = new Dado(6);//se puede agrandar el rango del dado para que llegue a curar mas
    }

    @Override
    public void ejecutar() {
        gestorDeBatalla.turnoJugadorUsarPocionVida(dadoVida);
    }
}