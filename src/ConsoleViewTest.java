public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gameState = GameStateGenerator.newGameState(25, 5, 4);

        ConsoleView debugView = new ConsoleView(gameState);
        new GameController(debugView, gameState);

        debugView.start();

    }
}