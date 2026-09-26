package Vista;

import java.awt.*;
import javax.swing.*;

public class PanelAccionesCombate extends JPanel {

    public PanelAccionesCombate(Runnable accionAtacar, Runnable accionPocionVida, Runnable accionPocionArmadura, Runnable accionFinalizarTurno) {
        setLayout(new GridLayout(4, 1));

        JButton btnAtacar = new JButton("Atacar");
        btnAtacar.addActionListener(e -> accionAtacar.run());

        JButton btnPocionVida = new JButton("Poción de vida");
        btnPocionVida.addActionListener(e -> accionPocionVida.run());

        JButton btnPocionArmadura = new JButton("Poción de armadura");
        btnPocionArmadura.addActionListener(e -> accionPocionArmadura.run());

        JButton btnFinalizarTurno = new JButton("Finalizar turno");
        btnFinalizarTurno.addActionListener(e -> accionFinalizarTurno.run());

        add(btnAtacar);
        add(btnPocionVida);
        add(btnPocionArmadura);
        add(btnFinalizarTurno);
    }
}