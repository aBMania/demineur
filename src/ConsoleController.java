public class ConsoleController implements GameCellListener {
    private ConsoleView view;
    private GameState gameState;

    public ConsoleController(ConsoleView view) {
        view.addGameListener(this);
        this.view = view;
        this.gameState = view.getGameState();
    }

    @Override
    public void markCellWithQuestionMark(GameCellEvent e) {
        gameState.markCellWithQuestionMark(e.getGameCell());
    }

    @Override
    public void markCellWithExclamationMark(GameCellEvent e) {
        gameState.markCellWithExclamationMark(e.getGameCell());
    }

    @Override
    public void discoverCell(GameCellEvent e) {
        gameState.discoverCell(e.getGameCell());
    }
}
