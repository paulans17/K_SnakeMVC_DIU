package vista;

//IMPORTACIONES Y LIBRERÍAS
import javax.swing.*;
import java.awt.*;

import vista.ColoresAccesibles.ModoColor;

public class VistaJuego extends JPanel {

    private ModoColor modoColor;

    public VistaJuego(ModoColor modoColor) {
        this.modoColor = modoColor;
        setPreferredSize(new Dimension(400, 400));
        setBackground(ColoresAccesibles.getColorFondo(modoColor));
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
