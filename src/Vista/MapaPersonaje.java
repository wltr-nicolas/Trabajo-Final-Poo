package Vista;

import Controlador.GestorEscenarios;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapaPersonaje extends JPanel {

    private GestorEscenarios gestorEscenarios;
    private BufferedImage spritePersonaje;
    private BufferedImage fondo;

    public MapaPersonaje(GestorEscenarios gestorEscenarios) {
        this.gestorEscenarios = gestorEscenarios;

        try {
            this.spritePersonaje = ImageIO.read(getClass().getResourceAsStream("/Assets/sprite/south.png"));
            this.fondo = ImageIO.read(getClass().getResourceAsStream("/Assets/ImagenesVarias/TopDownBosque1.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar una imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (fondo != null) {
            g2.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }

        int pixelX = gestorEscenarios.getPosicionJugadorX() * 8;
        int pixelY = gestorEscenarios.getPosicionJugadorY() * 6;
        g2.drawImage(spritePersonaje, pixelX, pixelY, this);
    }

    public int getAnchoSprite() { return spritePersonaje.getWidth(); }
    public int getAltoSprite() { return spritePersonaje.getHeight(); }
}