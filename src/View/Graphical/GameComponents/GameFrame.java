package View.Graphical.GameComponents;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.Graphical.GameMenu.GameMenu;
import View.Graphical.GraphicalGameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GameFrame extends JFrame {
    private GraphicalGameView gameView;
    private GameMenu menu;
    private GridView grid;
    private FooterView footer;
    private final static String TITLE = "Demineur";

    public GameFrame(GraphicalGameView gameView){
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

    public void fireMarkCellWithQuestionMark(GameCell cell) {
        gameView.fireMarkCellWithQuestionMark(cell);
    }

    public void fireClearCellMark(GameCell cell) {
        gameView.fireClearCellMark(cell);
    }

    public void fireMarkCellWithExclamationMark(GameCell cell) {
        gameView.fireMarkCellWithExclamationMark(cell);
    }

    public void fireDiscoverCell(GameCell cell) {
        gameView.fireDiscoverCell(cell);
    }

    public GameMenu getMenu() {
        return menu;
    }

    public GridView getGrid() {
        return grid;
    }
}
