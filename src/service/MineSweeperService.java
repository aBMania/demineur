package service;

import Controller.Graphical.GraphicalGameController;
import Model.GameState.GameConstants;
import Model.GameState.GameState;
import Model.GameState.GameStateFactory;
import View.Console.ConsoleGameView;
import View.Graphical.GraphicalGameView;

public class MineSweeperService {

    public final static boolean DEBUG = true;

    public static void newBeginnerGame(){
        newCustomGame(GameConstants.BEGINNER_COLS, GameConstants.BEGINNER_ROW, GameConstants.BEGINNER_MINES);
    }

    public static void newIntermediateGame(){
        newCustomGame(GameConstants.INTERMEDIATE_COLS, GameConstants.INTERMEDIATE_ROW, GameConstants.INTERMEDIATE_MINES);
    }

    public static void newExpertGame(){
        newCustomGame(GameConstants.EXPERT_COLS, GameConstants.EXPERT_ROW, GameConstants.EXPERT_MINES);
    }

    public static void newCustomGame(int x, int y, int nBombs){
        // Make model
        GameState gameState = GameStateFactory.newGameState(x, y, nBombs);

        // Attach view
        GraphicalGameView graphicalView = new GraphicalGameView(gameState);

        // Attach controller
        new GraphicalGameController(graphicalView);


        // Attach debug console
        if(DEBUG) {
            new ConsoleGameView(gameState, DEBUG);
        }

    }

    public static void newCustomGame() {

    }
}
