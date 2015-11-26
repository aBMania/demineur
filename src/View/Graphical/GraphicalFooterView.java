package View.Graphical;

import Model.GameState.GameState;

import javax.swing.*;

public class GraphicalFooterView extends JPanel{

    private GameState gameState;
    private JLabel sentence;

    public GraphicalFooterView(GameState gameState) {
        this.gameState = gameState;
        sentence = new JLabel("");
        this.add(sentence);
    }

    public void refresh(){
        sentence.setText("Drapeaux restant : " + (gameState.getnBombs() - gameState.getnFlag()));
    }

    private GameState getGameState() {
        return gameState;
    }
}