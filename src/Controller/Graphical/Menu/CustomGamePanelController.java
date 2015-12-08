package Controller.Graphical.Menu;

import View.Graphical.Menu.CustomGamePanel;
import View.Graphical.Menu.CustomGameParameterRow;

public class CustomGamePanelController{
    private final CustomGameParameterRow rows;
    private final CustomGameParameterRow column;
    private final CustomGameParameterRow mines;

    private final CustomGameParameterRowController rowsController;
    private final CustomGameParameterRowController columnController;
    private final CustomGameParameterRowController minesController;

    public CustomGamePanelController(CustomGamePanel customGamePanel) {

        rows = customGamePanel.getRowsPanel();
        rowsController = new CustomGameParameterRowController(rows);

        column = customGamePanel.getColumnPanel();
        columnController = new CustomGameParameterRowController(column);

        mines = customGamePanel.getMinesPanel();
        minesController = new CustomGameParameterRowController(mines);
    }

    public void updateMinesMaxValue(int value){
        minesController.updateMaxValue(value);
    }

    public CustomGameParameterRowController getRowsController() {
        return rowsController;
    }

    public CustomGameParameterRowController getColumnController() {
        return columnController;
    }

    public CustomGameParameterRowController getMinesController() {
        return minesController;
    }
}
