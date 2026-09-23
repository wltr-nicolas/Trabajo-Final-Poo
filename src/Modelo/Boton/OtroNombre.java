package Modelo.Boton;

import Modelo.Boton.boton_fin_dialogo.Fin_dialogo;

public class OtroNombre {
    public static void otroNombre(String[] args) {
        Boton finDialogo = new Boton.Builder("Finalizar diálogo")
            .setColor("blue")
            .setAccion(new Fin_dialogo())
            .build();

        finDialogo.click();
    }
}