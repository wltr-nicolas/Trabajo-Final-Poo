package Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import Controlador.GestorEscenarios;

public class EscenarioVista extends JFrame {
    
     
    private GestorEscenarios gestorEscenarios;
    private String nombreEscenario;


    public EscenarioVista(GestorEscenarios gestorEscenarios) {
        super( "juego RPG 2D" );
        
        this.gestorEscenarios = gestorEscenarios;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombreEscenario = gestorEscenarios.getEscenarioActual().getNombre();
        this.add(new JLabel("Nombre del escenario: " + this.nombreEscenario));
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);     
        this.setVisible(true);
    }

}
