package View.Graphical.Menu;

import Model.GameCell.GameCellListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CustomGameParameterRow extends JPanel {

    private static final int FIELD_SIZE = 4;
    private List<ChangeListener> changeListener = new ArrayList<>();
    private final JTextField field;
    private final JSlider slider;
    private int min,max;


    public void addGameListener(ChangeListener listener) {
        changeListener.add(listener);
    }

    public CustomGameParameterRow(String parameterName, int min, int max, Integer defaultValue) {
        JLabel name = new JLabel(parameterName);
        add(name);
        this.min = min;
        this.max = max;

        slider = new JSlider(min, max);
        slider.setMajorTickSpacing((max - min)/5);
        slider.setMinorTickSpacing((max - min) / 10);
        slider.setValue(min);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        field = new JTextField(defaultValue.toString(), FIELD_SIZE);
        add(field);
    }


    public int getMax() {
        return max;
    }

    public JTextField getField() {
        return field;
    }

    public JSlider getSlider() {
        return slider;
    }


}