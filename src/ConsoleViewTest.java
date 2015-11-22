public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gameState = GameStateGenerator.newGameState(5, 4, 85);

        ConsoleView debugView = new ConsoleView(gameState, true);
        new GameController(debugView, gameState);

        debugView.start();

    }
}