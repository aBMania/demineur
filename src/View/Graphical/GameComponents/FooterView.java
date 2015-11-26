package View.Graphical.GameComponents;

import Model.GameState.GameState;

import javax.swing.*;

public class FooterView extends JPanel{

    private GameState gameState;
    private JLabel sentence;

    public FooterView(GameState gameState) {
        this.gameState = gameState;
        sentence = new JLabel("");
        this.add(sentence);
    }

    public void refresh(){
        sentence.setText("Drapeaux restant : " + (gameState.getRemainingFlag()));
    }

    private GameState getGameState() {
        return gameState;
    }
}