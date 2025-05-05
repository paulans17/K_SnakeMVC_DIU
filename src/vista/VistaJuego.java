package vista;

//LIBRERÍAS
import javax.swing.*;
import java.awt.*;

public class VistaJuego extends JPanel {

    public VistaJuego() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //para dibujar la serpiente frutas y eso
    }

    public void actualizarVista() {
        repaint();
    }

}
