package View;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellEvent;
import Model.GameCell.GameCellListener;
import Model.GameState.GameState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public abstract class GameView  implements Observer {

    private GameState gameState;

    private Collection<GameCellListener> gameListenersList = new ArrayList<>();

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
