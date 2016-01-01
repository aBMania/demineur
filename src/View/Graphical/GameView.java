package view.Graphical;

import model.GameState.GameState;
import view.Graphical.Components.GameFrame;

import java.util.Observable;

public class GameView extends view.GameView {

    private GameFrame gameFrame;

    public GameView(GameState gameState) {
        super(gameState);

        gameFrame = new GameFrame(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        gameFrame.refresh();
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }
}
