package view;

import model.GameCell.GameCell;
import model.GameCell.GameCellEvent;
import model.GameCell.GameCellListener;
import model.GameState.GameState;

import java.util.*;

public abstract class GameView  implements Observer {

    private GameState gameState;

    private List<GameCellListener> gameListenersList = new ArrayList<>();

    public GameView(GameState gameState) {
        gameState.addObserver(this);
        this.gameState = gameState;
    }

    public void addGameListener(GameCellListener listener) {
        gameListenersList.add(listener);
    }

    public void fireMarkCellWithQuestionMark(GameCell gameCell){
        GameCellEvent event = new GameCellEvent(gameCell);

        for(GameCellListener listener : getGameListenersList()){
            listener.markCellWithQuestionMark(event);
        }
    }

    public void fireMarkCellWithExclamationMark(GameCell gameCell){
        GameCellEvent event = new GameCellEvent(gameCell);

        for(GameCellListener listener : getGameListenersList()){
            listener.markCellWithExclamationMark(event);
        }
    }

    public void fireDiscoverCell(GameCell gameCell){
        GameCellEvent event = new GameCellEvent(gameCell);

        for(GameCellListener listener : getGameListenersList()){
            listener.discoverCell(event);
        }
    }

    public void fireClearCellMark(GameCell gameCell){
        GameCellEvent event = new GameCellEvent(gameCell);

        for(GameCellListener listener : getGameListenersList()){
            listener.clearCellMark(event);
        }
    }

    public Collection<GameCellListener> getGameListenersList() {
        return gameListenersList;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public abstract void update(Observable o, Object arg);
}
