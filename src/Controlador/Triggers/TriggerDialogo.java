package Controlador.Triggers;
import Modelo.Boton.Accion;

public class TriggerDialogo implements Trigger {
    private Accion accion;
    
    public TriggerDialogo(Accion accion) {
        this.accion = accion;
    }

    @Override
    public void activar() {
        accion.ejecutar();
    }
}
