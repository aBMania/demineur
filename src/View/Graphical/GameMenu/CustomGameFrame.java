package View.Graphical.GameMenu;

import Model.GameState.GameState;
import Model.GameState.GameStateFactory;

import javax.swing.*;
import java.awt.*;

public class CustomGameFrame extends JFrame {

    private final CustomGamePanel customGamePanel;

    public CustomGamePanel getCustomGamePanel() {
        return customGamePanel;
    }

    public CustomGameFrame() {
        this.customGamePanel = new CustomGamePanel();
        this.setSize(100,100);
        add(this.customGamePanel);
        pack();
        setVisible(true);
    }

    public void addComponentListener() {

    }
    public GameState fireGameState(int x , int y , int Bombs){
        GameState gameState;
        gameState = GameStateFactory.newGameStateByPercentage(x, y, Bombs);
        return gameState;

    }
}
