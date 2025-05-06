package modelo;

import java.util.LinkedList;
import java.awt.Point;

public class Serpiente {

    private LinkedList<Point> cuerpoSerpiente;
    private Direccion direccionActual;

    public Serpiente() {
        cuerpoSerpiente = new LinkedList<>();
        cuerpoSerpiente.add(new Point(5, 5));
        cuerpoSerpiente.add(new Point(5, 6));
        cuerpoSerpiente.add(new Point(5, 7));
        direccionActual = Direccion.ARRIBA;
    }

    public void mover() {
        Point cabeza = cuerpoSerpiente.getFirst();
        Point nueva = new Point(cabeza);

        switch (direccionActual) {
            case ARRIBA -> nueva.translate(0, -1);
            case ABAJO -> nueva.translate(0, 1);
            case IZQUIERDA -> nueva.translate(-1, 0);
            case DERECHA -> nueva.translate(1, 0);
        }

        cuerpoSerpiente.addFirst(nueva);
        cuerpoSerpiente.removeLast(); // No crece aún
    }

    public void crecer() {
        Point cabeza = cuerpoSerpiente.getFirst();
        Point nueva = new Point(cabeza);

        switch (direccionActual) {
            case ARRIBA -> nueva.translate(0, -1);
            case ABAJO -> nueva.translate(0, 1);
            case IZQUIERDA -> nueva.translate(-1, 0);
            case DERECHA -> nueva.translate(1, 0);
        }

        cuerpoSerpiente.addFirst(nueva);
        // No quitamos la cola, por eso crece
    }

    public boolean colisionaConCuerpo() {
        Point cabeza = cuerpoSerpiente.getFirst();
        for (int i = 1; i < cuerpoSerpiente.size(); i++) {
            if (cabeza.equals(cuerpoSerpiente.get(i))) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Point> getCuerpo() {
        return cuerpoSerpiente;
    }

    public Direccion getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(Direccion direccion) {
        this.direccionActual = direccion;
    }
}
