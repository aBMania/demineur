package Controller;

import Model.GameCell.GameCellEvent;
import Model.GameCell.GameCellListener;
import Model.GameState.GameState;
import View.GameView;

public class GameController implements GameCellListener {
    private GameState gameState;

    public GameController(GameView view) {
        this.gameState = view.getGameState();
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

    public GameState getGameState() {
        return gameState;
    }

}
