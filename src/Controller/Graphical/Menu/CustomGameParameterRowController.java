package Controller.Graphical.Menu;

import Model.GameState.GameConstants;
import View.Graphical.Menu.CustomGameParameterRow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomGameParameterRowController{

    private CustomGameParameterRow customGameParameterRow;

    public CustomGameParameterRowController(CustomGameParameterRow customGameParameterRow) {
        this.customGameParameterRow = customGameParameterRow;
    }

    public CustomGameParameterRow getCustomGameParameterRow() {
        return customGameParameterRow;
    }

    public void updateMaxValue(int value) {
        customGameParameterRow.updateMaxValue(value);
    }

    public int getValue() {
        return customGameParameterRow.getValue();
    }
}

