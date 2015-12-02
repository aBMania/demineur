package View.Graphical.GameMenu;

import javax.swing.*;

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
        this.add(gameMenu);

        newMenu = new JMenu("New");
        gameMenu.add(newMenu);

        beginnerMenuItem = new JMenuItem("Beginner");
        newMenu.add(beginnerMenuItem);

        intermediateMenuItem = new JMenuItem("Intermediate");
        newMenu.add(intermediateMenuItem);

        expertMenuItem = new JMenuItem("Expert");
        newMenu.add(expertMenuItem);

        customMenuItem = new JMenuItem("Custom");
        newMenu.add(customMenuItem);

        quitMenuItem = new JMenuItem("Quit");
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
