package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaTutorial;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorTutorial implements Controlador {

    private JFrame ventana;
    private VistaTutorial vista;

    public ControladorTutorial(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaTutorial();
    }

    @Override
    public void inicializar() {
        // Cargar la vista en la ventana
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        // Listener para volver al menú
        vista.getBtnVolver().addActionListener(e -> {
            ControladorMenu menu = new ControladorMenu(ventana);
            menu.inicializar();
        });
    }
}
