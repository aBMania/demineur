package View.Graphical.GamePanel;

import javax.swing.*;

public class CustomGameFrame extends JFrame {

    CustomGamePanel customGamePanel;

    public CustomGameFrame() {
        this.customGamePanel = new CustomGamePanel();

        add(this.customGamePanel);
        pack();
        setVisible(true);
    }
}
