package View.Graphical.Components;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.Graphical.Menu.GameMenu;
import View.Graphical.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    private GameView gameView;
    private GameMenu menu;
    private GridView grid;
    private FooterView footer;
    private final static String TITLE = "Demineur";

    public GameFrame(GameView gameView){
        super(TITLE);

        this.gameView = gameView;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        menu = new GameMenu();
        grid = new GridView(this);
        footer = new FooterView(this);

        setJMenuBar(menu);
        add(grid, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void refresh() {
        if(getGameState().isLost())
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        grid.refresh();
        footer.refresh();
    }

    public GameState getGameState() {
        return gameView.getGameState();
    }

    public GameView getGameView() {
        return gameView;
    }

    public GameMenu getMenu() {
        return menu;
    }

    public GridView getGrid() {
        return grid;
    }
}
