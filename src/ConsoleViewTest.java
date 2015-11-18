public class ConsoleViewTest {

    public static void main(String[] args) {
        GameState gs = GameStateGenerator.newGame(25, 20, 10);

        ConsoleView view = new ConsoleView(gs, true);
        view.printGameState();

        System.out.println();

        gs.discoverCell(1, 1);
        view.printGameState();
    }
}