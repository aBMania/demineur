package service;

import Controller.Graphical.Components.GameController;
import Controller.Graphical.Menu.NewGamePanelController;
import Model.GameState.GameConstants;
import Model.GameState.GameDifficulty;
import Model.GameState.GameState;
import Model.GameState.GameStateFactory;
import View.Console.ConsoleGameView;
import View.Graphical.GameView;
import View.Graphical.Menu.NewGameFrame;

public class MineSweeperService{

    public final static boolean DEBUG = true;

    public static void newGame(GameDifficulty gameDifficulty) {
        newCustomGame(gameDifficulty.getCols(), gameDifficulty.getRows(), gameDifficulty.getMines());
    }

    public static void newCustomGame(){
        NewGameFrame gameFrame = new NewGameFrame("Please choose a difficulty");
        new NewGamePanelController(gameFrame.getNewGamePanel());
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
