package Vista;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public abstract class ElementoEscenario {

    protected int x;
    protected int y;
    protected BufferedImage imagen;

    public ElementoEscenario(String rutaImagen, int x, int y) {

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Las coordenadas iniciales (x, y) no pueden ser negativas.");
        }

        if (rutaImagen == null || rutaImagen.trim().isEmpty()) {
            throw new IllegalArgumentException("La ruta de la imagen no puede estar vacía o ser nula.");
        }
        this.x = x;
        this.y = y;

        try {
            InputStream stream = getClass().getResourceAsStream(rutaImagen);
            if (stream != null) {
                this.imagen = ImageIO.read(stream);
            } else {
                System.err.println("Error: No se encontró el recurso en la ruta: " + rutaImagen);
                this.imagen = null;
            }
        } catch (IOException e) {
            System.err.println("Error al procesar la imagen desde: " + rutaImagen);
            this.imagen = null;
        }
    }

    public abstract void actualizar(int xHero, int yHero);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImagen() {
        return imagen;

    }

}
