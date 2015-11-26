package View.Graphical;

import Model.GameState.GameState;

import javax.swing.*;

public class GraphicalFooterView extends JPanel{

    private GameState gameState;
    private JTextArea sentence;

    public GraphicalFooterView(GameState gameState) {
        this.gameState = gameState;
        sentence = new JTextArea("");
        this.add(sentence);
    }

    public void refresh(){
        sentence.setText("Drapeaux restant : " + (gameState.getNBombs()-gameState.getNFlag()));
    }

    private GameState getGameState() {
        return gameState;
    }
}