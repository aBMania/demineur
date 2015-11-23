import Controller.GameController;
import Model.GameState;
import Model.GameStateFactory;
import View.ConsoleView;

public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gameState = GameStateFactory.newGameState(5, 4, 20);

        ConsoleView debugView = new ConsoleView(gameState, true);
        new GameController(debugView, gameState);

        debugView.start();

    }
}