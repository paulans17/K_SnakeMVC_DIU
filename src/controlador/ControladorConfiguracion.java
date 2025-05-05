package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaConfiguracion;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorConfiguracion implements Controlador {

    private JFrame ventana;
    private VistaConfiguracion vista;

    public ControladorConfiguracion(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaConfiguracion();
    }

    @Override
    public void inicializar(){
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        vista.getTamano();
    }
}
