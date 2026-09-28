package Vista;

public class ElementoCarreta extends ElementoEscenario {

    public ElementoCarreta(String rutaImagen, int x, int y) {
        super(rutaImagen, x, y);
    }

    @Override
    public void actualizar(int xHero, int yHero) { // Elemento estático, no requiere actualización de posición 
    }
}
