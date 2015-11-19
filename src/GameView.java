import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public abstract class GameView {

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


}
