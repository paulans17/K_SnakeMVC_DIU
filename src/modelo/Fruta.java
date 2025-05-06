package modelo;

import java.awt.Point;
import java.util.Random;

public class Fruta {

    private Point posicion;
    private Random random;

    public Fruta() {
        random = new Random();
        posicion = new Point(10, 10); // Valor por defecto, se puede sobrescribir con generarNueva()
    }

    public Point getPosicion() {
        return posicion;
    }

    // Genera una nueva posición aleatoria
    public void generarNueva(int ancho, int alto) {
        int x = random.nextInt(ancho);
        int y = random.nextInt(alto);
        posicion = new Point(x, y);
    }
}
