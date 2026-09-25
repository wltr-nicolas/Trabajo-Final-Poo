package Vista;

import Controlador.GestorEscenarios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class ManejadorTecladoMapa extends KeyAdapter {
    private GestorEscenarios gestorEscenarios;
    private MapaPersonaje mapaPersonaje;

    public ManejadorTecladoMapa(GestorEscenarios gestorEscenarios, MapaPersonaje mapaPersonaje) {
        this.gestorEscenarios = gestorEscenarios;
        this.mapaPersonaje = mapaPersonaje;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = gestorEscenarios.getPosicionJugadorX();
        int y = gestorEscenarios.getPosicionJugadorY();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                y--;
                break;
            case KeyEvent.VK_S:
                y++;
                break;
            case KeyEvent.VK_A:
                x--;
                break;
            case KeyEvent.VK_D:
                x++;
                break;
        }

        gestorEscenarios.moverJugador(x, y);

        this.mapaPersonaje.repaint(); // Redibuja la vista inmediatamente con la nueva posición

    }


    }



