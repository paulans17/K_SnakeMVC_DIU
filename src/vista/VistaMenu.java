package vista;

//LIBRERÍAS
import javax.swing.*;
import java.awt.*;

public class VistaMenu extends JPanel {

    private JButton
            btnJugar,
            btnConfiguracion,
            btnRanking,
            btnAyuda;

    public VistaMenu() {
        setLayout (new GridLayout (4,1));

        btnJugar = new JButton("Jugar");
        btnConfiguracion = new JButton("Configuracion");
        btnRanking = new JButton("Ranking");
        btnAyuda = new JButton("Ayuda");

        add(btnJugar);
        add(btnConfiguracion);
        add(btnRanking);
        add(btnAyuda);
    }

    public JButton getBtnJugar() {
        return btnJugar;
    }

    public JButton getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public JButton getBtnRanking() {
        return btnRanking;
    }

    public JButton getBtnAyuda() {
        return btnAyuda;
    }
}
