package vista;

import javax.swing.*;
import java.awt.*;

public class VistaConfiguracion extends JPanel {

    private JSlider sliderVelocidad;
    private JComboBox<String> comboTamano;
    private JCheckBox checkDaltonico;
    private JButton btnVolver;

    public VistaConfiguracion() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Elementos
        sliderVelocidad = new JSlider(1, 10, 5);
        comboTamano = new JComboBox<>(new String[]{"Pequeño", "Medio", "Grande"});
        checkDaltonico = new JCheckBox("Modo daltónico");
        btnVolver = new JButton("Volver");

        gbc.insets = new Insets(10, 10, 10, 10); // márgenes

        //Velocidad
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Velocidad:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(sliderVelocidad, gbc);

        //Tamaño
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Tamaño del tablero:"), gbc);

        gbc.gridx = 1;
        add(comboTamano, gbc);

        //Daltonismo
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(checkDaltonico, gbc);

        //Botón Volver
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(btnVolver, gbc);
    }

    public int getVelocidad() {
        return sliderVelocidad.getValue();
    }

    public int getTamano() {
        return comboTamano.getSelectedIndex();
    }

    public boolean isModoDaltonico() {
        return checkDaltonico.isSelected();
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}
