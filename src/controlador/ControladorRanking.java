package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaRanking;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorRanking implements Controlador {

    private JFrame ventana;
    private VistaRanking vista;

    public ControladorRanking(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaRanking();
    }

    @Override
    public void inicializar() {
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        //luego se caragan los datos desde un fichero
        vista.getAreaRanking().setText("");

        vista.getBtnVolver().addActionListener(e -> {
            ControladorMenu menu = new ControladorMenu(ventana);
            menu.inicializar();
        });
    }
}
