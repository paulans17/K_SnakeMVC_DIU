package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaJuego;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorJuego  implements Controlador {

    private JFrame ventana;
    private VistaJuego vista;

    public ControladorJuego(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaJuego();
    }

    @Override
    public void inicializar(){
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        //FALTAN TEMPORIZADORRES LISTENERS...
    }
}
