package modelo;

//LIBRERÍAS
import java.awt.Point;

public class Tablero {

    private int ancho;
    private int alto;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    //Detecta las colisiones con esto
    public boolean colisionConPared(Point cabeza) {
        return cabeza.x < 0 || cabeza.y < 0 || cabeza.x >= ancho || cabeza.y >= alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
