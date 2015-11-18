public class ConsoleViewTest {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView(GameStateGenerator.newGame(80, 10, 20), true);
        view.printGameState();
    }
}