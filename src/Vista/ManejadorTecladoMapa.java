package Vista;

import Controlador.GestorEscenarios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManejadorTecladoMapa implements KeyListener {
    private GestorEscenarios gestorEscenarios;

    public ManejadorTecladoMapa(GestorEscenarios gestorEscenarios) {
        this.gestorEscenarios = gestorEscenarios;
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
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        // No se necesita implementar
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita implementar
    }


}