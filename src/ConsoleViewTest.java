public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gs = GameStateGenerator.newGame(60, 2, 4);

        ConsoleView view = new ConsoleView(gs, true);
        view.printGameState();

        System.out.println();

        GameController gc = new GameController(gs);
        gc.discoverCell(1, 1);
        view.printGameState();
    }
}