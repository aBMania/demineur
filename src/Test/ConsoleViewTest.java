package Test;

import Controller.GameController;
import Model.GameState;
import Model.GameStateFactory;
import View.ConsoleView;


public class ConsoleViewTest {

    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        GameState gameState = GameStateFactory.newGameState(5, 4, 20);

        ConsoleView debugView = new ConsoleView(gameState, DEBUG);
        new GameController(debugView, gameState);

        debugView.start();

    }
}