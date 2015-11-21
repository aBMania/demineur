public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gameState = GameStateGenerator.newBlankGameState( 5, 4,25);

        ConsoleView debugView = new ConsoleView(gameState);
        new GameController(debugView, gameState);

        debugView.start();

    }
}