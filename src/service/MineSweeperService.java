package service;

import controller.Graphical.Components.GameController;
import controller.Graphical.Menu.CustomGameFrameController;
import controller.Graphical.Menu.NewGamePanelController;
import model.GameState.GameDifficulty;
import model.GameState.GameState;
import model.GameState.GameStateFactory;
import view.Console.ConsoleGameView;
import view.Graphical.GameView;
import view.Graphical.Menu.CustomGameFrame;
import view.Graphical.Menu.NewGameFrame;

public class MineSweeperService{
    public final static boolean DEBUG = false;

    private MineSweeperService(){}

    public static void newGame(GameDifficulty gameDifficulty) {
        newCustomGame(gameDifficulty.getCols(), gameDifficulty.getRows(), gameDifficulty.getMines());
    }

    public static void newGame(){
        NewGameFrame gameFrame = new NewGameFrame();
        new NewGamePanelController(gameFrame.getNewGamePanel());
    }

    public static void newCustomGame(){
        CustomGameFrame gameFrame = new CustomGameFrame();
        new CustomGameFrameController(gameFrame);
    }

    public static void newCustomGame(int x, int y, int nBombs){
        // Make model
        GameState gameState = GameStateFactory.newGameState(x, y, nBombs);

        // Attach view
        GameView graphicalView = new GameView(gameState);

        // Attach controller
        new GameController(graphicalView);


        // Attach debug console
        if(DEBUG) {
            new ConsoleGameView(gameState, DEBUG);
        }

    }
}
