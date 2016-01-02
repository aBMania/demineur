package view.Graphical.Components;

import model.GameState.GameState;
import service.MineSweeperService;
import view.Graphical.GameView;
import view.Graphical.Menu.GameMenu;

import javax.swing.*;
import java.awt.*;

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
        grid.refresh();
        footer.refresh();

        if(getGameState().isFinished())
            actionOnGameFinished();
    }

    public void actionOnGameFinished(){
        String message = "";

        if(getGameState().isLost())
            message = "You lost";

        if(getGameState().isWon())
            message = "You won in " + getGameState().getTimer().getDuration().getSeconds() + " seconds";

        message = message + "\nContinue?";

        int option = JOptionPane.showConfirmDialog(this, message, "Continue?", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.NO_OPTION)
            System.exit(0);

        if (option == JOptionPane.YES_OPTION){
            MineSweeperService.newGame();
            dispose();
        }
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
