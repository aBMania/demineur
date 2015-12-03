package View.Graphical;

import Model.GameState.GameState;
import View.Graphical.Components.GameFrame;

import java.util.Observable;

public class GameView extends View.GameView {

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
