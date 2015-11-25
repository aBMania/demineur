package View.Graphical;

import javax.swing.*;

public class GraphicalMenuView extends JMenuBar {
    public GraphicalMenuView() {
        JMenu gameMenu = new JMenu("Game");
        this.add(gameMenu);

        JMenu newMenu = new JMenu("New");
        gameMenu.add(newMenu);

        JMenuItem beginnerMenuItem = new JMenuItem("Beginner");
        newMenu.add(beginnerMenuItem);

        JMenuItem intermediateMenuItem = new JMenuItem("Intermediate");
        newMenu.add(intermediateMenuItem);

        JMenuItem expertMenuItem = new JMenuItem("Expert");
        newMenu.add(expertMenuItem);

        JMenuItem customMenuItem = new JMenuItem("Custom");
        newMenu.add(customMenuItem);

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        gameMenu.add(quitMenuItem);
    }
}
