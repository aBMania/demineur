package View.Graphical.GameMenu;

import javax.swing.*;

public class CustomGameParameterRow extends JPanel {

    private static final int FIELD_SIZE = 4;
    private final JTextField field;
    private final JSlider slider;

    public CustomGameParameterRow(String parameterName, int min, int max, Integer defaultValue) {
        JLabel name = new JLabel(parameterName);
        add(name);

        slider = new JSlider(min, max);
        slider.setMajorTickSpacing((max-min)/5);
        slider.setMinorTickSpacing((max - min) / 10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        field = new JTextField(defaultValue.toString(), FIELD_SIZE);
        add(field);
    }

    public JTextField getField() {
        return field;
    }

    public JSlider getSlider() {
        return slider;
    }


}