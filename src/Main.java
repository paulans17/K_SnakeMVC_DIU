import controlador.ControladorMenu;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame("SnakeMVC");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500); // Ajusta según tu vista

        // Creamos el controlador del menú y su vista
        ControladorMenu controladorMenu = new ControladorMenu(ventana);
        controladorMenu.inicializar();

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
