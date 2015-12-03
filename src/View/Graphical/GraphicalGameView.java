package View.Graphical;

import Model.GameState.GameState;
import View.GameView;
import View.Graphical.GameComponents.FooterView;
import View.Graphical.GameComponents.GameFrame;
import View.Graphical.GameComponents.GridView;
import View.Graphical.GameMenu.GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private GameFrame gameFrame;

    public GraphicalGameView(GameState gameState) {
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
