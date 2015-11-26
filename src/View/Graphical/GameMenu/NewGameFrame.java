package View.Graphical.GameMenu;

import javax.swing.*;

public class NewGameFrame extends JFrame{
    private NewGamePanel newGamePanel;

    public NewGameFrame() {
        this.newGamePanel = new NewGamePanel();

        add(this.newGamePanel);
        pack();
        setVisible(true);
    }
}
