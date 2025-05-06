package controlador;

//IMPORTACIONES Y LIBRERÍAS
import modelo.Configuracion;
import vista.VistaConfiguracion;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorConfiguracion implements Controlador {

    private static Configuracion configuracion = new Configuracion(); //para guardar los cambios
    private JFrame ventana;
    private VistaConfiguracion vista;

    public ControladorConfiguracion(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaConfiguracion();
    }

    public static Configuracion getConfiguracion() {
        return configuracion;
    }

    @Override
    public void inicializar(){
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        vista.getTamano();

        vista.getBtnVolver().addActionListener(e -> {

            //Guardar valores en el modelo
            configuracion.setVelocidad(vista.getVelocidad());
            configuracion.setTamanoTablero(vista.getTamano());
            configuracion.setModoDaltonico(vista.isModoDaltonico());

            ControladorMenu menu = new ControladorMenu(ventana);
            menu.inicializar();
        });
    }
}
