package View.Graphical.Menu;

import javax.swing.*;

public class CustomGamePanelWrapper extends JPanel{

    private CustomGamePanel customGamePanel;
    private JButton start;

    public CustomGamePanelWrapper() {
        customGamePanel = new CustomGamePanel();
        add(customGamePanel);
        start = new JButton("Start");
        add(start);
    }

    public CustomGamePanel getCustomGamePanel() {
        return customGamePanel;
    }

    public JButton getStart() {
        return start;
    }
}
