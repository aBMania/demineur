package View.Graphical.Menu;

import Model.GameState.GameConstants;

import javax.swing.*;
import java.awt.*;

public class CustomGamePanel extends JPanel{

    private CustomGameParameterRow rowsPanel;
    private CustomGameParameterRow columnPanel;
    private CustomGameParameterRow minesPanel;

    public CustomGamePanel() {
        setLayout(new BorderLayout());

        rowsPanel   = new CustomGameParameterRow("Rows", GameConstants.CUSTOM_MIN_ROW, GameConstants.CUSTOM_MAX_ROW, GameConstants.CUSTOM_DEFAULT_ROW);
        add(rowsPanel, BorderLayout.NORTH);

        columnPanel = new CustomGameParameterRow("Columns", GameConstants.CUSTOM_MIN_COLS, GameConstants.CUSTOM_MAX_COLS, GameConstants.CUSTOM_DEFAULT_COLS);
        add(columnPanel, BorderLayout.CENTER);

        int y = Integer.valueOf(rowsPanel.getField().getText());
        int x = Integer.valueOf(columnPanel.getField().getText());
        System.out.print(x+" ,"+y);

        minesPanel  = new CustomGameParameterRow("Mines", GameConstants.CUSTOM_MIN_MINES, GameConstants.getCustomMaxMines(x,y),GameConstants.CUSTOM_DEFAULT_MINES);
        add(minesPanel, BorderLayout.SOUTH);

    }

    public CustomGameParameterRow getRowsPanel() {
        return rowsPanel;
    }

    public CustomGameParameterRow getColumnPanel() {
        return columnPanel;
    }

    public CustomGameParameterRow getMinesPanel() {
        return minesPanel;
    }
}
