package Controller.Graphical.Menu;

import View.Graphical.Menu.CustomGameParameterRow;

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

