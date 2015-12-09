package View.Graphical.Menu;

import javax.swing.*;
import java.awt.*;

public class NewGameFrame extends JFrame{
    private NewGamePanel newGamePanel;

    public NewGamePanel getNewGamePanel() {
        return newGamePanel;
    }

    public NewGameFrame(String title, Dimension d) {
        super(title);
        newGamePanel = new NewGamePanel();

        newGamePanel.setPreferredSize(d);
        add(newGamePanel);
        pack();
        setVisible(true);
        setResizable(false);
    }

    public NewGameFrame(String title) {
        this(title, new Dimension(350, 300));
    }
}
