package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelDialogo extends JPanel {

    public PanelDialogo(Runnable accionComun, Runnable accionMision, Runnable accionTienda, Runnable accionAdios) {
        setLayout(new GridLayout(4, 1));

        JButton btnComun = new JButton("Hablar");
        btnComun.addActionListener(e -> accionComun.run());

        JButton btnMision = new JButton("Preguntar por misión");
        btnMision.addActionListener(e -> accionMision.run());

        JButton btnTienda = new JButton("Tienda");
        btnTienda.addActionListener(e -> accionTienda.run());

        JButton btnAdios = new JButton("Adiós");
        btnAdios.addActionListener(e -> accionAdios.run());

        add(btnComun);
        add(btnMision);
        add(btnTienda);
        add(btnAdios);
    }
}