package vista;

import javax.swing.*;
import java.awt.*;

public class VistaConfiguracion extends JPanel {

    private JSlider sliderVelocidad;
    private JComboBox<String> comboTamano;
    private JCheckBox checkDaltonico;
    private JButton btnVolver;

    public VistaConfiguracion() {
        sliderVelocidad = new JSlider(1, 10, 5);
        comboTamano = new JComboBox<>(new String[]{"Pequeño", "Medio", "Grande"});
        checkDaltonico = new JCheckBox("Modo daltónico");

        add(new JLabel("Velocidad:"));
        add(sliderVelocidad);
        add(new JLabel("Tamaño del tablero:"));
        add(comboTamano);
        add(checkDaltonico);

        btnVolver = new JButton("Volver");
        add(btnVolver, BorderLayout.SOUTH);
    }

    public int getVelocidad() {
        return sliderVelocidad.getValue();
    }

    public String getTamano() {
        return (String) comboTamano.getSelectedItem();
    }

    public boolean isModoDaltonico() {
        return checkDaltonico.isSelected();
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
