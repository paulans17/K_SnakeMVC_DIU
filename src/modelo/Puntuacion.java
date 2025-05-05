package modelo;

public class Puntuacion {

    private int puntos;

    public Puntuacion() {
        this.puntos = 0;
    }

    public void aumentar(int cantidad) {
        puntos += cantidad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void reiniciar(){
        puntos = 0;
    }
}
