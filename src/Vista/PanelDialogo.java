package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelDialogo extends JPanel {

    public PanelDialogo(Runnable accionComun, Runnable accionMision, Runnable accionTienda, Runnable accionAdios) {
        setLayout(new GridLayout(4, 1));

        String rutaTextura = "/Assets/FondosInterfaz/TexturaBoton.png";

        BotonConTextura btnComun = new BotonConTextura("Hablar", rutaTextura);
        btnComun.addActionListener(e -> accionComun.run());

        BotonConTextura btnMision = new BotonConTextura("Preguntar por misión", rutaTextura);
        btnMision.addActionListener(e -> accionMision.run());

        BotonConTextura btnTienda = new BotonConTextura("Tienda", rutaTextura);
        btnTienda.addActionListener(e -> accionTienda.run());

        BotonConTextura btnAdios = new BotonConTextura("Adiós", rutaTextura);
        btnAdios.addActionListener(e -> accionAdios.run());

        add(btnComun);
        add(btnMision);
        add(btnTienda);
        add(btnAdios);
    }
}