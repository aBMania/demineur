package Test;

import Controller.ConsoleController;
import Model.GameState.GameState;
import Model.GameState.GameStateFactory;
import View.ConsoleView;


public class ConsoleViewTest {

    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        GameState gameState = GameStateFactory.newGameState(5, 4, 20);
        ConsoleView debugView = new ConsoleView(gameState, DEBUG);

        new ConsoleController(debugView);
    }
}