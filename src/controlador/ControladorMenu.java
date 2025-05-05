package controlador;

//IMPORTACIONES Y LIBRERÍAS
import vista.VistaMenu;
import interfaces.Controlador;

import javax.swing.*;
import java.awt.event.ActionListener;

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
        vista.getBtnJugar().addActionListener(e ->
                System.out.println("Iniciar juego"));

        vista.getBtnConfiguracion().addActionListener(e ->
                System.out.println("Configuración"));

        vista.getBtnRanking().addActionListener(e ->
                System.out.println("Ranking"));

        vista.getBtnAyuda().addActionListener(e ->
                System.out.println("Ayuda"));
    }
}
