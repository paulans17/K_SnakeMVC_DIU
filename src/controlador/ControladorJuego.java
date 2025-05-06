package controlador;

import vista.VistaJuego;
import modelo.Configuracion;
import modelo.Serpiente;
import modelo.Fruta;
import modelo.Tablero;
import interfaces.Controlador;
import vista.ColoresAccesibles.ModoColor;
import modelo.Direccion;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ControladorJuego implements Controlador {

    private JFrame ventana;
    private VistaJuego vista;
    private Serpiente serpiente;
    private Fruta fruta;
    private Tablero tablero;
    private Timer temporizador;

    public ControladorJuego(JFrame ventana) {
        this.ventana = ventana;

        Configuracion cfg = ControladorConfiguracion.getConfiguracion();
        ModoColor modo = cfg.getModoColor();
        int tamano = cfg.getTamanoTablero();

        serpiente = new Serpiente();
        fruta = new Fruta();
        tablero = new Tablero(tamano, tamano);
        fruta.generarNueva(tablero.getAncho(), tablero.getAlto());

        vista = new VistaJuego(modo, serpiente, fruta, tamano, tamano);
    }

    @Override
    public void inicializar() {
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        contenedor.setBackground(Color.BLACK);
        contenedor.add(vista);

        ventana.setContentPane(contenedor);
        ventana.pack();
        ventana.setLocationRelativeTo(null);

        int velocidad = ControladorConfiguracion.getConfiguracion().getVelocidad();
        int retraso = (int)(300 - velocidad * 20);

        temporizador = new Timer(retraso, e -> {
            serpiente.mover();
            Point cabeza = serpiente.getCuerpo().getFirst();

            if (tablero.colisionConPared(cabeza) || serpiente.colisionaConCuerpo()) {
                temporizador.stop();
                JOptionPane.showMessageDialog(ventana, "¡Has perdido!");
                new ControladorMenu(ventana).inicializar();
                return;
            }

            if (cabeza.equals(fruta.getPosicion())) {
                serpiente.crecer();
                fruta.generarNueva(tablero.getAncho(), tablero.getAlto());
            }

            vista.repaint();
        });
        temporizador.start();

        vista.setFocusable(true);
        vista.requestFocusInWindow();
        vista.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (serpiente.getDireccionActual() != Direccion.ABAJO)
                            serpiente.setDireccionActual(Direccion.ARRIBA);
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (serpiente.getDireccionActual() != Direccion.ARRIBA)
                            serpiente.setDireccionActual(Direccion.ABAJO);
                    }
                    case KeyEvent.VK_LEFT -> {
                        if (serpiente.getDireccionActual() != Direccion.DERECHA)
                            serpiente.setDireccionActual(Direccion.IZQUIERDA);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (serpiente.getDireccionActual() != Direccion.IZQUIERDA)
                            serpiente.setDireccionActual(Direccion.DERECHA);
                    }
                }
            }
        });
    }
}
