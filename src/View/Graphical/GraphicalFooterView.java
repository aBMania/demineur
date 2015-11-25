package View.Graphical;

import Model.GameState.GameState;

import javax.swing.*;

public class GraphicalFooterView extends JPanel{

    private GameState gameState;

    public GraphicalFooterView(GameState gameState) {
        this.gameState = gameState;
    }

    private GameState getGameState() {
        return gameState;
    }
}