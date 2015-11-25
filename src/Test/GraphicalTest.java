package Test;

import Controller.ConsoleGameController;
import Model.GameState.GameState;
import Model.GameState.GameStateFactory;
import View.ConsoleGameView;
import View.Graphical.GraphicalGameView;

public class GraphicalTest {

    public static void main(String[] args) {
        GameState gameState = GameStateFactory.newGameState(5, 5, 20);
        ConsoleGameView debugView = new ConsoleGameView(gameState, true);
        GraphicalGameView graphicalView = new GraphicalGameView(gameState);

        new ConsoleGameController(debugView);
    }
}
