package Vista;

import Controlador.GestorEscenarios;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

public class MapaPersonaje extends JPanel  {

    private GestorEscenarios gestorEscenarios;
    private BufferedImage spritePersonaje;    
    
    public MapaPersonaje (GestorEscenarios gestorEscenarios) {
        this.gestorEscenarios = gestorEscenarios;

        try {
            this.spritePersonaje = ImageIO.read(getClass().getResourceAsStream("/Assets/sprite/south.png"));
    //this.spritePersonaje = ImageIO.read(new File("src/Assets/sprite/south.png"));
} catch (IOException e) {
    System.out.println("No se pudo cargar el sprite del personaje: " + e.getMessage());
}
    }
    
    

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D g2 = (Graphics2D) g;

    int pixelX = gestorEscenarios.getPosicionJugadorX() * 8;
    int pixelY = gestorEscenarios.getPosicionJugadorY() * 6;

    g2.drawImage(spritePersonaje, pixelX, pixelY, this);
}

}
