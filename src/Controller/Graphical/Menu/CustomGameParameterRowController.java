package Controller.Graphical.Menu;

import View.Graphical.Menu.CustomGameParameterRow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomGameParameterRowController {

    JTextField textField;
    JSlider slider;

    public CustomGameParameterRowController(CustomGameParameterRow customGameParameterRow) {
        slider = customGameParameterRow.getSlider();
        textField = customGameParameterRow.getField();

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTextField(slider.getValue());
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    int value = Integer.valueOf(textField.getText());
                    updateSlider(value);
                }
                catch (Exception exception){

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try{
                    int value = Integer.valueOf(textField.getText());
                    updateSlider(value);
                }
                catch (Exception exception){

                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try{
                    int value = Integer.valueOf(textField.getText());
                    updateSlider(value);
                }
                catch (Exception exception){

                }
            }
        });
    }

    private void updateTextField(Integer value) {
        textField.setText(value.toString());
    }

    private void updateSlider(Integer value) {
        slider.setValue(value);
    }
}
