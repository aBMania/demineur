public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gs = GameStateGenerator.newGame(5, 6, 6);

        ConsoleView view = new ConsoleView(gs, true);
        view.printGameState();

        System.out.println();

        GameController gc = new GameController(gs);
        gc.discoverCell(1, 1);
        view.printGameState();
    }
}