package controlador;

// IMPORTACIONES Y LIBRERÍAS
import vista.VistaJuego;
import modelo.Configuracion;
import interfaces.Controlador;
import vista.ColoresAccesibles.ModoColor;

import javax.swing.*;

public class ControladorJuego implements Controlador {

    private JFrame ventana;
    private VistaJuego vista;

    public ControladorJuego(JFrame ventana) {
        this.ventana = ventana;

        // Obtener configuración actual
        Configuracion cfg = ControladorConfiguracion.getConfiguracion();
        ModoColor modo = cfg.getModoColor();

        // Crear la vista con el modo de color
        this.vista = new VistaJuego(modo);
    }

    @Override
    public void inicializar(){
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        // FALTAN TEMPORIZADORES, LISTENERS...
    }
}
