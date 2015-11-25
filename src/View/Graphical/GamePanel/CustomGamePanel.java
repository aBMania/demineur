package View.Graphical.GamePanel;

import javax.swing.*;
import java.awt.*;

public class CustomGamePanel extends JPanel{

    private GamePanelParameterRow rowsPanel;
    private GamePanelParameterRow columnPanel;
    private GamePanelParameterRow minesPanel;

    public CustomGamePanel() {
        setLayout(new BorderLayout());

        rowsPanel   = new GamePanelParameterRow("Rows", 9, 24, 9);
        add(rowsPanel, BorderLayout.NORTH);

        columnPanel = new GamePanelParameterRow("Columns", 9, 30, 19);
        add(columnPanel, BorderLayout.CENTER);

        minesPanel  = new GamePanelParameterRow("Mines", 10, (int) Math.floor(0.85*9*19), 76);
        add(minesPanel, BorderLayout.SOUTH);

    }
}
