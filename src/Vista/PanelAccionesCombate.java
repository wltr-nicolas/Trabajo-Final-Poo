package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelAccionesCombate extends JPanel {

    public PanelAccionesCombate(Runnable accionAtacar, Runnable accionPocionVida, Runnable accionPocionArmadura, Runnable accionFinalizarTurno) {
        setLayout(new GridLayout(4, 1));

        ImageIcon iconoAtacar = escalarIcono("/Assets/ImagenesVarias/espadasCruzadasX.png", 32, 32);
        ImageIcon iconoPocionVida = escalarIcono("/Assets/ImagenesVarias/pocionRoja.png", 32, 32);
        ImageIcon iconoPocionArmadura = escalarIcono("/Assets/ImagenesVarias/pocionGris.png", 32, 32);

        JButton btnAtacar = new JButton("Atacar", iconoAtacar);
        btnAtacar.addActionListener(e -> accionAtacar.run());

        JButton btnPocionVida = new JButton("Poción de vida", iconoPocionVida);
        btnPocionVida.addActionListener(e -> accionPocionVida.run());

        JButton btnPocionArmadura = new JButton("Poción de armadura", iconoPocionArmadura);
        btnPocionArmadura.addActionListener(e -> accionPocionArmadura.run());

        JButton btnFinalizarTurno = new JButton("Finalizar turno");
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