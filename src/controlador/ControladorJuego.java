package controlador;

import vista.VistaJuego;
import modelo.Configuracion;
import modelo.Serpiente;
import modelo.Fruta;
import modelo.Tablero;
import interfaces.Controlador;
import vista.ColoresAccesibles.ModoColor;
import modelo.Direccion;
import modelo.Puntuacion;

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
    private Puntuacion puntuacion;
    private long tiempoUltimaManzana;

    public ControladorJuego(JFrame ventana) {
        this.ventana = ventana;

        Configuracion cfg = ControladorConfiguracion.getConfiguracion();
        ModoColor modo = cfg.getModoColor();
        int tamano = cfg.getTamanoTablero();

        serpiente = new Serpiente();
        fruta = new Fruta();
        puntuacion = new Puntuacion();
        tablero = new Tablero(tamano, tamano);
        fruta.generarNueva(tablero.getAncho(), tablero.getAlto());

        tiempoUltimaManzana = System.currentTimeMillis();

        vista = new VistaJuego(modo, serpiente, fruta, tamano, tamano, puntuacion);
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

                int puntosFinales = puntuacion.getPuntos();

                if (ControladorRanking.entraEnTop(puntosFinales)) {
                    String nombre = JOptionPane.showInputDialog(ventana, "¡Nuevo récord! Introduce tus iniciales (3 letras):");
                    if (nombre != null && !nombre.trim().isEmpty()) {
                        nombre = nombre.trim().toUpperCase();
                        if (nombre.length() > 3) {
                            nombre = nombre.substring(0, 3);
                        }
                        ControladorRanking.guardarPuntuacion(nombre, puntosFinales);
                    }
                }

                // Mostrar top 5 después de perder
                JOptionPane.showMessageDialog(ventana,
                        "Has perdido con " + puntosFinales + " puntos.\n\n" + ControladorRanking.obtenerTopFormateado());

                new ControladorMenu(ventana).inicializar();
                return;
            }

            if (cabeza.equals(fruta.getPosicion())) {
                serpiente.crecer();

                long tiempoActual = System.currentTimeMillis();
                long segundos = (tiempoActual - tiempoUltimaManzana) / 1000;

                int puntos = switch ((int) segundos) {
                    case 0, 1 -> 70;
                    case 2, 3 -> 50;
                    case 4, 7 -> 20;
                    default -> 10;
                };

                puntuacion.aumentar(puntos);
                vista.mostrarMensajePuntos("+" + puntos);
                tiempoUltimaManzana = tiempoActual;

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
