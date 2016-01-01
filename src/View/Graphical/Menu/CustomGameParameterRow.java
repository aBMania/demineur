package view.Graphical.Menu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

public class CustomGameParameterRow extends JPanel {

    private static final int FIELD_SIZE = 4;
    private List<ChangeListener> changeListenerList = new ArrayList<>();
    private final JTextField field;
    private final JSlider slider;
    private int min,max;
    private int value;

    public void addChangeListener(ChangeListener listener) {
        changeListenerList.add(listener);
    }

    public CustomGameParameterRow(String parameterName, int min, int max, Integer defaultValue) {
        JLabel name = new JLabel(parameterName);
        add(name);
        this.value = defaultValue;
        this.min = min;
        this.max = max;

        slider = new JSlider(min, max);
        slider.setMajorTickSpacing((max - min) / 2);
        slider.setMinorTickSpacing((max - min) / 5);
        slider.setValue(defaultValue);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        field = new JTextField(defaultValue.toString(), FIELD_SIZE);
        add(field);

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try{
                    value = Integer.valueOf(field.getText());
                    updateValue(value);
                }
                catch (Exception exception){

                }
            }
        });

        slider.addChangeListener(e -> updateValue(slider.getValue()));
    }

    private void updateValue(Integer value) {
        if(value > max || value < min) {
            return;
        }

        slider.setValue(value);
        field.setText(value.toString());

        this.value = value;
        fireStateChanged();
    }

    protected void fireStateChanged() {
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : changeListenerList) {
            listener.stateChanged(event);
        }
    }

    public int getValue() {
        return value;
    }

    public void updateMaxValue(int max) {
        this.max = max;
        slider.setMaximum(max);

        if(this.value > max)
            updateValue(max);
    }
}