package View.Graphical.GameComponents;

import Model.GameState.GameState;

import javax.swing.*;

public class FooterView extends JPanel{

    private GameState gameState;
    private JLabel sentence;
    private JLabel image;

    public FooterView(GameState gameState) {

        this.gameState = gameState;
        sentence = new JLabel("");

        java.net.URL imgURL = getClass().getResource("images/drap.png");
        image = new JLabel(new ImageIcon(imgURL));


        this.add(image);
        this.add(sentence);
    }

    public void refresh() {
        sentence.setText("Drapeaux restant : " + (gameState.getRemainingFlag()));
    }

    private GameState getGameState() {
        return gameState;
    }
}