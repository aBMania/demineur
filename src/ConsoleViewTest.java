public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gs = GameStateGenerator.newGame(25, 20, 10);

        ConsoleView debugView = new ConsoleView(gs, true);
        debugView.printGameState();

    }
}