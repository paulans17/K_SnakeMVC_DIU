package vista;

//LIBRERÍAS
import javax.swing.*;
import java.awt.*;

public class VistaTutorial extends JPanel {

    private JTextArea textoAyuda;
    private JButton btnVolver;

    public VistaTutorial() {
        setLayout(new BorderLayout());

        textoAyuda = new JTextArea();
        textoAyuda.setEditable(false);
        textoAyuda.setLineWrap(true);
        textoAyuda.setWrapStyleWord(true);
        textoAyuda.setFont(new Font("Monospaced", Font.PLAIN, 14));

        textoAyuda.setText(
                "Cómo jugar a Snake:\n\n" +
                        "- Usa las flechas ↑ ↓ ← → para mover la serpiente.\n" +
                        "- Come frutas para crecer y ganar puntos.\n" +
                        "- No choques contra tu propio cuerpo ni contra las paredes.\n" +
                        "- ¡Aguanta el máximo tiempo posible!\n\n" +
                        "Pulsa 'Volver' para regresar al menú."
        );


        btnVolver = new JButton("Volver");

        add(new JScrollPane(textoAyuda), BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
