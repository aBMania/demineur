package View.Graphical.Components;

import Model.GameState.GameState;
import View.Graphical.GameView;
import View.Graphical.Menu.GameMenu;
import service.MineSweeperService;

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
            MineSweeperService.newCustomGame();
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
