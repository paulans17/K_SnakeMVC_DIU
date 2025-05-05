package modelo;

public class Configuracion {

    private int velocidad;
    private int tamanoTablero;
    private boolean modoDaltonico;

    //Valores por defecto
    public Configuracion () {

    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getTamanoTablero() {
        return tamanoTablero;
    }

    public void setTamanoTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
    }

    public boolean isModoDaltonico() {
        return modoDaltonico;
    }

    public void setModoDaltonico(boolean modoDaltonico) {
        this.modoDaltonico = modoDaltonico;
    }
}
