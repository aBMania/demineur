package View.Graphical.GameMenu;

import javax.swing.*;
import java.awt.*;

public class CustomGamePanel extends JPanel{

    private CustomGameParameterRow rowsPanel;
    private CustomGameParameterRow columnPanel;
    private CustomGameParameterRow minesPanel;

    public CustomGamePanel() {
        setLayout(new BorderLayout());

        rowsPanel   = new CustomGameParameterRow("Rows", 9, 24, 9);
        add(rowsPanel, BorderLayout.NORTH);

        columnPanel = new CustomGameParameterRow("Columns", 9, 30, 19);
        add(columnPanel, BorderLayout.CENTER);

        minesPanel  = new CustomGameParameterRow("Mines", 10, (int) Math.floor(0.85*9*19), 76);
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
