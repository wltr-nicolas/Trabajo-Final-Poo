package Modelo.Boton.boton_fin_dialogo;

import Modelo.Boton.Accion;

public class Fin_dialogo implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Finalizar dialogo");
    }
}