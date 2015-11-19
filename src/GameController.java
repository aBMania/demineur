public class GameController implements GameCellListener {
    private GameState gameState;
    private GameView view;

    public GameController(GameView view, GameState gameState) {
        this.view = view;
        this.gameState = gameState;

        view.addGameListener(this);
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
