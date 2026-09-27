package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelAccionesCombate extends JPanel {

    public PanelAccionesCombate(Runnable accionAtacar, Runnable accionPocionVida, Runnable accionPocionArmadura, Runnable accionFinalizarTurno) {
        setLayout(new GridLayout(4, 1));

        String rutaTextura = "/Assets/FondosInterfaz/TexturaBoton.png";

        ImageIcon iconoAtacar = escalarIcono("/Assets/ImagenesVarias/espadasCruzadasX.png", 32, 32);
        ImageIcon iconoPocionVida = escalarIcono("/Assets/ImagenesVarias/pocionRoja.png", 32, 32);
        ImageIcon iconoPocionArmadura = escalarIcono("/Assets/ImagenesVarias/pocionGris.png", 32, 32);

        BotonConTextura btnAtacar = new BotonConTextura("Atacar", iconoAtacar, rutaTextura);
        btnAtacar.addActionListener(e -> accionAtacar.run());

        BotonConTextura btnPocionVida = new BotonConTextura("Poción de vida", iconoPocionVida, rutaTextura);
        btnPocionVida.addActionListener(e -> accionPocionVida.run());

        BotonConTextura btnPocionArmadura = new BotonConTextura("Poción de armadura", iconoPocionArmadura, rutaTextura);
        btnPocionArmadura.addActionListener(e -> accionPocionArmadura.run());

        BotonConTextura btnFinalizarTurno = new BotonConTextura("Finalizar turno", rutaTextura);
        btnFinalizarTurno.addActionListener(e -> accionFinalizarTurno.run());

        add(btnAtacar);
        add(btnPocionVida);
        add(btnPocionArmadura);
        add(btnFinalizarTurno);
    }

    private ImageIcon escalarIcono(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(ruta));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}