package View.Graphical.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameMenu extends JMenuBar {
    private final JMenu gameMenu;
    private final JMenu newMenu;
    private final JMenuItem beginnerMenuItem;
    private final JMenuItem intermediateMenuItem;
    private final JMenuItem expertMenuItem;
    private final JMenuItem customMenuItem;
    private final JMenuItem quitMenuItem;

    public GameMenu() {
        gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        this.add(gameMenu);

        newMenu = new JMenu("New");
        newMenu.setMnemonic(KeyEvent.VK_N);
        gameMenu.add(newMenu);

        beginnerMenuItem = new JMenuItem("Beginner");
        beginnerMenuItem.setMnemonic(KeyEvent.VK_B);

        beginnerMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        newMenu.add(beginnerMenuItem);

        intermediateMenuItem = new JMenuItem("Intermediate");
        intermediateMenuItem.setMnemonic(KeyEvent.VK_I);
        intermediateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        newMenu.add(intermediateMenuItem);

        expertMenuItem = new JMenuItem("Expert");
        expertMenuItem.setMnemonic(KeyEvent.VK_E);
        expertMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        newMenu.add(expertMenuItem);

        customMenuItem = new JMenuItem("Custom");
        customMenuItem.setMnemonic(KeyEvent.VK_C);
        customMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        newMenu.add(customMenuItem);

        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.setMnemonic(KeyEvent.VK_Q);
        gameMenu.add(quitMenuItem);
    }

    public JMenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

    public JMenuItem getCustomMenuItem() {
        return customMenuItem;
    }

    public JMenuItem getExpertMenuItem() {
        return expertMenuItem;
    }

    public JMenuItem getIntermediateMenuItem() {
        return intermediateMenuItem;
    }

    public JMenuItem getBeginnerMenuItem() {
        return beginnerMenuItem;
    }

    public JMenu getNewMenu() {
        return newMenu;
    }

    public JMenu getGameMenu() {
        return gameMenu;
    }

}
