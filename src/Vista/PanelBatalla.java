package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelBatalla extends JPanel {

    private BufferedImage fondo;

    public PanelBatalla(List<String> nombresEnemigos) {
        setLayout(new GridLayout(1, nombresEnemigos.size() + 1));

        try {
            fondo = ImageIO.read(getClass().getResourceAsStream("/Assets/FondosEscenarios/Mazmorra.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar el fondo de batalla: " + e.getMessage());
        }

        JPanel columnaHeroe = new JPanel();
        columnaHeroe.setOpaque(false);
        columnaHeroe.add(crearFigura("Héroe"));
        add(columnaHeroe);

        for (String nombreEnemigo : nombresEnemigos) {
            add(crearColumnaEnemigo(nombreEnemigo));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private JPanel crearColumnaEnemigo(String nombre) {
        JPanel columna = new JPanel(new BorderLayout());
        columna.setOpaque(false);

        JPanel barraVida = new JPanel();
        barraVida.setBackground(Color.RED);
        barraVida.setPreferredSize(new Dimension(100, 15));

        JPanel contenedorBarra = new JPanel();
        contenedorBarra.setOpaque(false);
        contenedorBarra.add(barraVida);

        columna.add(contenedorBarra, BorderLayout.NORTH);
        columna.add(crearFigura(nombre), BorderLayout.CENTER);

        return columna;
    }

    private JLabel crearFigura(String texto) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return label;
    }
}