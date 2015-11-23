package View;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellEvent;
import Model.GameCell.GameCellListener;
import Model.GameState.GameState;

import java.util.ArrayList;
import java.util.Collection;

public abstract class GameView {

    private GameState gameState;

    private final Collection<GameCellListener> gameListenersList = new ArrayList<>();
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

    public Collection<GameCellListener> getGameListenersList() {
        return gameListenersList;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
