package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BotonConTextura extends JButton {

    private BufferedImage textura;

    public BotonConTextura(String texto, Icon icono, String rutaTextura) {
        super(texto, icono);
        try {
            textura = ImageIO.read(getClass().getResourceAsStream(rutaTextura));
        } catch (IOException e) {
            System.out.println("No se pudo cargar la textura del boton: " + e.getMessage());
        }
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
    }

    public BotonConTextura(String texto, String rutaTextura) {
        this(texto, null, rutaTextura);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (textura != null) {
            g.drawImage(textura, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
}