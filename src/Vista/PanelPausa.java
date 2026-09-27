package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelPausa extends JPanel {

    private BufferedImage fondo;

    public PanelPausa(String textoPrimerBoton, String rutaFondo, Runnable accionPrimerBoton, Runnable accionOpciones, Runnable accionSalir) {
        setLayout(new GridBagLayout());

        try {
            fondo = ImageIO.read(getClass().getResourceAsStream("/Assets/Portada/pantallaInicio.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar el fondo del menú: " + e.getMessage());
        }

        JPanel menu = new JPanel(new GridLayout(3, 1, 0, 10));
        menu.setOpaque(false);
        menu.setPreferredSize(new Dimension(250, 180));

        JButton btnPrimero = new JButton(textoPrimerBoton);
        btnPrimero.addActionListener(e -> accionPrimerBoton.run());

        JButton btnOpciones = new JButton("Opciones");
        btnOpciones.addActionListener(e -> accionOpciones.run());

        JButton btnSalir = new JButton("Salir del juego");
        btnSalir.addActionListener(e -> accionSalir.run());

        menu.add(btnPrimero);
        menu.add(btnOpciones);
        menu.add(btnSalir);

        add(menu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}