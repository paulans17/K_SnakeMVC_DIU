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
        return switch (comboTamano.getSelectedIndex()) {
            case 0 -> 10;
            case 1 -> 15;
            case 2 -> 20;
            default -> 15; // valor por defecto
        };
    }

    public boolean isModoDaltonico() {
        return checkDaltonico.isSelected();
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void setVelocidad(int valor) {
        sliderVelocidad.setValue(valor);
    }

    public void setTamano(int tamanoReal) {
        int index;
        if (tamanoReal == 10) index = 0;
        else if (tamanoReal == 15) index = 1;
        else if (tamanoReal == 20) index = 2;
        else index = 1; // valor por defecto

        comboTamano.setSelectedIndex(index);
    }

    public void setModoDaltonico(boolean activado) {
        checkDaltonico.setSelected(activado);
    }

}
