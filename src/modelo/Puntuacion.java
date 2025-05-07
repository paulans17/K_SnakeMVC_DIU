package modelo;

public class Puntuacion {
    private int puntos;
    private int manzanas;
    private long ultimoTiempo;

    public Puntuacion() {
        this.puntos = 0;
        this.manzanas = 0;
        this.ultimoTiempo = System.currentTimeMillis();
    }

    public void aumentar(int puntosExtra) {
        puntos += puntosExtra;
        manzanas++;
        ultimoTiempo = System.currentTimeMillis();
    }

    public int getPuntos() {
        return puntos;
    }

    public int getManzanas() {
        return manzanas;
    }

    public void reiniciar() {
        puntos = 0;
        manzanas = 0;
        ultimoTiempo = System.currentTimeMillis();
    }
}
