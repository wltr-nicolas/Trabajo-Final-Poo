package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelLog extends JPanel {

    private BufferedImage fondo;
    private JTextArea areaTexto;

    public PanelLog() {
        setLayout(new BorderLayout());

        try {
            fondo = ImageIO.read(getClass().getResourceAsStream("/Assets/FondosInterfaz/LadrillosEnmarcados.png"));
        } catch (IOException e) {
            System.out.println("No se pudo cargar el marco del log: " + e.getMessage());
        }

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setOpaque(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setFont(new Font("Serif", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

        // ESTE panel envolvente lleva el margen, NO el areaTexto de adentro
        JPanel contenedorConMargen = new JPanel(new BorderLayout());
        contenedorConMargen.setOpaque(false);
        contenedorConMargen.setBorder(BorderFactory.createEmptyBorder(30, 30, 25, 30));
        contenedorConMargen.add(scroll, BorderLayout.CENTER);

        add(contenedorConMargen, BorderLayout.CENTER);
    }

    public void agregar(String mensaje) {
        areaTexto.append(mensaje + "\n");
        areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}