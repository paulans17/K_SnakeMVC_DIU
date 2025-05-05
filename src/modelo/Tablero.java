package modelo;

public class Tablero {

    private int ancho;
    private int alto;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    /////////////TEMPORAL//////////
    public boolean colisionConPared(Serpiente s){
        return false;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
