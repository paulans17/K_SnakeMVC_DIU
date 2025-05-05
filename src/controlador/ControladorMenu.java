package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaMenu;
import interfaces.Controlador;

import javax.swing.*;

public class ControladorMenu implements Controlador {

    private JFrame ventana;
    private VistaMenu vista;

    public ControladorMenu(JFrame ventana) {
        this.ventana = ventana;
        this.vista = new VistaMenu();
    }

    @Override
    public void inicializar() {

        //Mostrar vista del menú
        ventana.setContentPane(vista);
        ventana.revalidate();
        ventana.repaint();

        //LISTENERS
        vista.getBtnJugar().addActionListener(e -> {
            ControladorJuego cj = new ControladorJuego(ventana);
            cj.inicializar();
        });

        vista.getBtnConfiguracion().addActionListener(e -> {
            ControladorConfiguracion cc = new ControladorConfiguracion(ventana);
            cc.inicializar();
        });

        vista.getBtnRanking().addActionListener(e -> {
            ControladorRanking cr = new ControladorRanking(ventana);
            cr.inicializar();
        });

        vista.getBtnAyuda().addActionListener(e -> {
            ControladorTutorial ct = new ControladorTutorial(ventana);
            ct.inicializar();
        });
    }
}
