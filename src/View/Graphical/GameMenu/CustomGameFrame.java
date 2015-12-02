package View.Graphical.GameMenu;

import javax.swing.*;
import java.awt.*;

public class CustomGameFrame extends JFrame {

    private CustomGamePanel customGamePanel;

    public CustomGamePanel getCustomGamePanel() {
        return customGamePanel;
    }

    public CustomGameFrame() {
        this.customGamePanel = new CustomGamePanel();
        this.setSize(100,100);
        add(this.customGamePanel);
        pack();
        setVisible(true);
    }

    public void addComponentListener() {
    }
}
