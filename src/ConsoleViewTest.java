public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gameState = GameStateGenerator.newGameState(25, 20, 10);

        ConsoleView debugView = new ConsoleView(gameState, true);
        GameController consoleController = new GameController(debugView, gameState);

        debugView.printGameState();

    }
}