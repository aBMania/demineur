package Controller.Graphical.Menu;

import Model.GameState.GameConstants;
import View.Graphical.Menu.CustomGameParameterRow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomGameParameterRowController {

    private JTextField textField;
    private JSlider slider;
    private int value;
    private boolean isMineRow = false;

    public CustomGameParameterRowController(CustomGameParameterRow customGameParameterRow) {
        slider = customGameParameterRow.getSlider();
        textField = customGameParameterRow.getField();
        this.isMineRow = isMineRow;

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTextField(slider.getValue());
                if(isMineRow == false){

                }
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                    value = Integer.valueOf(textField.getText());
                    updateSlider(value);
                }
                catch (NumberFormatException exception){

                }
            }
        });
    }

    public JTextField getTextField() {
        return textField;
    }

    public void updateMaxValue(int value) {
        slider.setMaximum(value);
    }

    private void updateTextField(Integer value) {
        textField.setText(value.toString());
    }

    private void updateSlider(Integer value) {
        slider.setValue(value);
    }

    public int getValue() {
        return value;
    }
}

