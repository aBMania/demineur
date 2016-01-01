package controller.Graphical.Menu;

import model.GameState.GameConstants;
import view.Graphical.Menu.CustomGamePanel;
import view.Graphical.Menu.CustomGameParameterRow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CustomGamePanelController implements ChangeListener{
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

        column.addChangeListener(this);
        rows.addChangeListener(this);
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

    @Override
    public void stateChanged(ChangeEvent e) {
        minesController.updateMaxValue(GameConstants.getCustomMaxMines(column.getValue(), rows.getValue()));
    }
}
