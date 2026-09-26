package Vista;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class PanelBatalla extends JPanel {

    public PanelBatalla(List<String> nombresEnemigos) {
        setLayout(new GridLayout(1, nombresEnemigos.size() + 1)); // +1 por la columna del héroe

        // Columna del héroe (siempre una sola, a la izquierda)
        JPanel columnaHeroe = new JPanel();
        columnaHeroe.setOpaque(false);
        columnaHeroe.add(crearFigura("Héroe"));
        add(columnaHeroe);

        // Una columna por cada enemigo de la lista
        for (String nombreEnemigo : nombresEnemigos) {
            add(crearColumnaEnemigo(nombreEnemigo));
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