package modelo;

//LIBRERÍAS
import java.util.LinkedList;
import java.awt.Point;

public class Serpiente {

    private LinkedList<Point> cuerpoSerpiente;
    private Direccion direccionActual;

    //Constructor
    public Serpiente() {

    }

    //Mover la serpiente
    public void mover() {

    }

    //Añadir segmento
    public void crecer(){

    }

    //////////TEMPORAL///////////
    public boolean colisionaConCuerpo() {
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
