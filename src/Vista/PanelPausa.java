package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelPausa extends JPanel {

    public PanelPausa(Runnable accionContinuar, Runnable accionOpciones, Runnable accionSalir) {
        setLayout(new GridBagLayout());

        JPanel menu = new JPanel(new GridLayout(3, 1, 0, 10));//3 filas 1 columna
        menu.setPreferredSize(new Dimension(250, 180));

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(e -> accionContinuar.run());

        JButton btnOpciones = new JButton("Opciones");
        btnOpciones.addActionListener(e -> accionOpciones.run());

        JButton btnSalir = new JButton("Salir del juego");
        btnSalir.addActionListener(e -> accionSalir.run());

        menu.add(btnContinuar);
        menu.add(btnOpciones);
        menu.add(btnSalir);

        add(menu); //al no tener constraints centra el panel
    }
}