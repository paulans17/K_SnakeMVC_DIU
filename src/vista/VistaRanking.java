package vista;

//LIBRERÍAS
import javax.swing.*;
import java.awt.*;

public class VistaRanking extends JPanel {

    private JTextArea areaRanking;
    private JButton btnVolver;

    public VistaRanking() {
        setLayout(new BorderLayout());

        areaRanking = new JTextArea();
        areaRanking.setEditable(false);
        areaRanking.setFont(new Font("Monospaced", Font.PLAIN, 14));

        btnVolver = new JButton("BACK");

        add(new JScrollPane(areaRanking), BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }

    public JTextArea getAreaRanking() {
        return areaRanking;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
