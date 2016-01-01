package controller;

import model.GameCell.GameCellEvent;
import model.GameCell.GameCellListener;
import model.GameState.GameState;
import view.GameView;

abstract public class GameController implements GameCellListener {
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

    @Override
    public void clearCellMark(GameCellEvent e){
        gameState.clearCellMarkAction(e.getGameCell());
    }

    public GameState getGameState() {
        return gameState;
    }

}
