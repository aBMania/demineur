package Controller.Graphical;

import View.Graphical.GameMenu.CustomGamePanel;

import javax.swing.*;

public class GraphicalCustomGamePanelController {
    private final JTextField rows;
    private final JTextField column;
    private final JTextField mines;

    public GraphicalCustomGamePanelController(CustomGamePanel customGamePanel) {
        rows = customGamePanel.getRowsPanel().getField();
        column = customGamePanel.getColumnPanel().getField();
        mines = customGamePanel.getMinesPanel().getField();
    }
}
