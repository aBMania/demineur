package View.Graphical;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GraphicalGridView grid;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        grid = new GraphicalGridView(gameState);
        JMenuBar menuBar = generateMenu();

        frame.setJMenuBar(menuBar);
        frame.add(grid, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar generateMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);

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

        return menuBar;
    }


    @Override
    public void update(Observable o, Object arg) {
//        if(getGameState().isLost())
//            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        grid.refresh();
    }
}
