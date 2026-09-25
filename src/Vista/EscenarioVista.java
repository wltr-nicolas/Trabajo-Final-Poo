package Vista;

import javax.swing.*;
import java.awt.*;
import Controlador.GestorEscenarios;

public class EscenarioVista extends JFrame {

    private GestorEscenarios gestorEscenarios;
    private MapaPersonaje mapaPersonaje;

    public EscenarioVista(GestorEscenarios gestorEscenarios) {
        super("juego RPG 2D");
        this.gestorEscenarios = gestorEscenarios;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        // NORTH: turno + vida enemigo
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel labelTurno = new JLabel("Turno: 1", SwingConstants.CENTER);
        JLabel labelVidaEnemigo = new JLabel("Vida enemigo: --/--", SwingConstants.RIGHT);
        panelSuperior.add(labelTurno, BorderLayout.CENTER);
        panelSuperior.add(labelVidaEnemigo, BorderLayout.EAST);
        panelSuperior.setPreferredSize(new Dimension(800, 60));//defino el alto de la zona, para que no use la que tiene por defecto

        //CENTER: donde aparece el mapa donde se mueve el personaje
        mapaPersonaje = new MapaPersonaje(gestorEscenarios);

        //SOUTH: log de combate + acciones de combate/opciones dialogo + matriz de inventario 3x3
        JPanel panelInferior = new JPanel(new GridLayout(1, 3));//disenio pensado originalmente en el orden que se describe arriba 1x3
        panelInferior.setPreferredSize(new Dimension(800, 150));

        JTextArea log = new JTextArea("Historial del juego\nLog de combate");
        log.setEditable(false);
        panelInferior.add(new JScrollPane(log));//JscrollPane hace que se puede scrollear en el log de combate, ya que va a tener mucho texto

        JPanel menuAcciones = new JPanel(new GridLayout(2, 1));
        menuAcciones.add(new JButton("Atacar"));//se agrega boton atacar
        menuAcciones.add(new JButton("Usar poción"));//se agrega boton pocion
        panelInferior.add(menuAcciones);//se agrega panel

        JPanel inventario = new JPanel(new GridLayout(3, 3));//panel 3x3
        for (int i = 0; i < 9; i++) inventario.add(new JLabel("[ ]"));
        panelInferior.add(inventario);

        //estructuracion final de la pantalla
        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(mapaPersonaje, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);

        this.addKeyListener(new ManejadorTecladoMapa(gestorEscenarios, mapaPersonaje));
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
}