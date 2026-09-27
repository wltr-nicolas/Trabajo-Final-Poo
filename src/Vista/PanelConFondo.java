package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelConFondo extends JPanel {

    private BufferedImage imagenFondo;

    public PanelConFondo(LayoutManager layout, String rutaImagen) {
        super(layout);
        try {
            imagenFondo = ImageIO.read(getClass().getResourceAsStream(rutaImagen));
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("No se pudo cargar el fondo: " + rutaImagen + " -> " + e.getMessage());
        }
        setOpaque(false); // importante: dejamos que nuestro propio dibujo se vea
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}