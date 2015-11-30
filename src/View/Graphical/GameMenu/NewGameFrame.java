package View.Graphical.GameMenu;

import javax.swing.*;
import java.awt.*;

public class NewGameFrame extends JFrame{
    private NewGamePanel newGamePanel;

    public NewGameFrame() {
        this.newGamePanel = new NewGamePanel();
        Dimension d = new Dimension(350, 300);
        newGamePanel.setPreferredSize(d);
        add(this.newGamePanel);
        pack();
        setVisible(true);
    }
}
