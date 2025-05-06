package vista;

import modelo.Serpiente;
import modelo.Fruta;
import vista.ColoresAccesibles.ModoColor;
import modelo.Direccion;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class VistaJuego extends JPanel {

    private Serpiente serpiente;
    private Fruta fruta;
    private ModoColor modoColor;

    private Image imgCabeza;
    private Image imgCuerpo;
    private Image imgFruta;

    private int tamanoCasilla;
    private int filas;
    private int columnas;

    private Image imgFondo;

    public VistaJuego(ModoColor modoColor, Serpiente serpiente, Fruta fruta, int filas, int columnas) {
        this.modoColor = modoColor;
        this.serpiente = serpiente;
        this.fruta = fruta;
        this.filas = filas;
        this.columnas = columnas;

        int dimension = 640;
        this.tamanoCasilla = dimension / Math.max(filas, columnas);
        setPreferredSize(new Dimension(tamanoCasilla * columnas, tamanoCasilla * filas));
        setBackground(ColoresAccesibles.getColorFondo(modoColor));

        // Cargar imágenes
        imgCabeza = new ImageIcon(getClass().getResource("/img/CabezaSerpiente.png")).getImage();
        imgCuerpo = new ImageIcon(getClass().getResource("/img/CuerpoSerpiente.png")).getImage();
        imgFruta = new ImageIcon(getClass().getResource("/img/Manzana.png")).getImage();
        imgFondo = new ImageIcon(getClass().getResource("/img/FondoJuego.png")).getImage();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2dF = (Graphics2D) g.create();

        // Dibujar fondo
        if (imgFondo != null) {
            g2dF.drawImage(imgFondo, 0, 0, getWidth(), getHeight(), this);
        }

        List<Point> cuerpo = serpiente.getCuerpo();

        // Dibujar cabeza rotada según la dirección
        if (!cuerpo.isEmpty()) {
            Point cabeza = cuerpo.get(0);
            Direccion dir = serpiente.getDireccionActual();

            double angulo = switch (dir) {
                case ARRIBA -> 180;
                case DERECHA -> 270;
                case ABAJO -> 0;
                case IZQUIERDA -> 90;
            };

            Graphics2D g2d = (Graphics2D) g.create();
            int x = cabeza.x * tamanoCasilla;
            int y = cabeza.y * tamanoCasilla;

            g2d.rotate(Math.toRadians(angulo), x + tamanoCasilla / 2.0, y + tamanoCasilla / 2.0);
            g2d.drawImage(imgCabeza, x, y, tamanoCasilla, tamanoCasilla, this);
            g2d.dispose();

            // Dibujar cuerpo
            for (int i = 1; i < cuerpo.size(); i++) {
                Point actual = cuerpo.get(i);
                Point anterior = cuerpo.get(i - 1);

                int dx = anterior.x - actual.x;
                int dy = anterior.y - actual.y;

                double anguloCuerpo = switch (dx + "," + dy) {
                    case "0,1" -> Math.PI;          // izquierda
                    case "0,-1"  -> 0;                   // derecha
                    case "1,0" -> 3 * Math.PI / 2;        // arriba
                    case "-1,0"  -> Math.PI / 2;          // abajo
                    default     -> 0;
                };

                int xCuerpo = actual.x * tamanoCasilla;
                int yCuerpo = actual.y * tamanoCasilla;

                Graphics2D g2dC = (Graphics2D) g.create();
                g2dC.translate(xCuerpo + tamanoCasilla / 2.0, yCuerpo + tamanoCasilla / 2.0);
                g2dC.rotate(anguloCuerpo);
                g2dC.drawImage(imgCuerpo, -tamanoCasilla / 2, -tamanoCasilla / 2, tamanoCasilla, tamanoCasilla, this);
                g2dC.dispose();
            }

        }

        // Dibujar fruta
        Point f = fruta.getPosicion();
        if (f != null) {
            g.drawImage(imgFruta, f.x * tamanoCasilla, f.y * tamanoCasilla, tamanoCasilla, tamanoCasilla, this);
        }
    }
}
