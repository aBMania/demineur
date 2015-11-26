package View.Graphical.GameMenu;

import javax.swing.*;

public class CustomGameParameterRow extends JPanel {

    private static final int FIELD_SIZE = 4;

    public CustomGameParameterRow(String parameterName, int min, int max, Integer defaultValue) {
        JLabel name = new JLabel(parameterName);
        add(name);

        JSlider slider = new JSlider(min, max);
        slider.setMajorTickSpacing((max-min)/5);
        slider.setMinorTickSpacing((max-min)/10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        JTextField field = new JTextField(defaultValue.toString(), FIELD_SIZE);
        add(field);
    }
}