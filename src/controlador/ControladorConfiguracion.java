package controlador;

import modelo.Configuracion;
import vista.VistaConfiguracion;
import interfaces.Controlador;
import vista.ColoresAccesibles.ModoColor;

import javax.swing.*;

public class ControladorConfiguracion implements Controlador {

    private static Configuracion configuracion = new Configuracion(); // mantiene los ajustes
    private JFrame ventana;
    private VistaConfiguracion vista;

    public ControladorConfiguracion(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaConfiguracion();

        // Recuperar valores guardados
        vista.setVelocidad(configuracion.getVelocidad());
        vista.setTamano(configuracion.getTamanoTablero());
        vista.setModoDaltonico(configuracion.getModoColor() == ModoColor.DALTÓNICO);
    }

    public static Configuracion getConfiguracion() {
        return configuracion;
    }

    @Override
    public void inicializar(){
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        vista.getBtnVolver().addActionListener(e -> {
            configuracion.setVelocidad(vista.getVelocidad());
            configuracion.setTamanoTablero(vista.getTamano());
            configuracion.setModoColor(
                    vista.isModoDaltonico() ? ModoColor.DALTÓNICO : ModoColor.NORMAL
            );

            System.out.println("CONFIG GUARDADA: velocidad=" + configuracion.getVelocidad()
                    + ", tamano=" + configuracion.getTamanoTablero()
                    + ", modo=" + configuracion.getModoColor());

            new ControladorMenu(ventana).inicializar();
        });

        vista.setVelocidad(configuracion.getVelocidad());
        vista.setTamano(configuracion.getTamanoTablero());
        vista.setModoDaltonico(configuracion.getModoColor() == ModoColor.DALTÓNICO);

    }
}
