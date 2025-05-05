package controlador;

//IMPORTACIONES Y LIBRERÍAS
import modelo.Serpiente;
import modelo.Direccion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControladorTeclado extends KeyAdapter {

    private Serpiente serpiente;

    public ControladorTeclado(Serpiente serpiente) {
        this.serpiente = serpiente;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> serpiente.setDireccionActual(Direccion.ARRIBA);
            case KeyEvent.VK_DOWN -> serpiente.setDireccionActual(Direccion.ABAJO);
            case KeyEvent.VK_LEFT -> serpiente.setDireccionActual(Direccion.IZQUIERDA);
            case KeyEvent.VK_RIGHT -> serpiente.setDireccionActual(Direccion.DERECHA);
        }
    }
}
