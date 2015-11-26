package View.Graphical.GameMenu;

import javax.swing.*;

public class CustomGameFrame extends JFrame {

    private CustomGamePanel customGamePanel;

    public CustomGameFrame() {
        this.customGamePanel = new CustomGamePanel();

        add(this.customGamePanel);
        pack();
        setVisible(true);
    }
}
