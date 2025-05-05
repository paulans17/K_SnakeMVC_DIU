package vista;

import java.awt.*;

public class ColoresAccesibles {

    public enum ModoColor {
        NORMAL,
        DALTÓNICO
    }

    public static Color getColorFondo(ModoColor modo) {
        return switch (modo) {
            case DALTÓNICO -> Color.DARK_GRAY;
            default -> Color.BLACK;
        };
    }

    public static Color getColorSerpiente(ModoColor modo) {
        return switch (modo) {
            case DALTÓNICO -> new Color(0, 255, 255); // Cian brillante
            default -> Color.GREEN;
        };
    }

    public static Color getColorFruta(ModoColor modo) {
        return switch (modo) {
            case DALTÓNICO -> Color.ORANGE;
            default -> Color.RED;
        };
    }
}
