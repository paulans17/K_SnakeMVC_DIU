package modelo;

//IMPORTACIONES Y LIBRERÍAS
import vista.ColoresAccesibles.ModoColor;

public class Configuracion {

    private int velocidad;
    private int tamanoTablero;
    private ModoColor modoColor;

    //Valores por defecto
    public Configuracion () {
        this.velocidad = 5;
        this.tamanoTablero = 20;
        this.modoColor = ModoColor.NORMAL;
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

    public ModoColor getModoColor() {
        return modoColor;
    }

    public void setModoColor(ModoColor modoColor) {
        this.modoColor = modoColor;
    }
}
