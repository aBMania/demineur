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

        this.add(image);
        this.add(sentence);
    }

    public void refresh(){
        java.net.URL imgURL = getClass().getResource("images/drap.png");
        sentence.setText("Drapeaux restant : " + (gameState.getRemainingFlag()));
        if(image == null)
            image = new JLabel(new ImageIcon(imgURL));
    }

    private GameState getGameState() {
        return gameState;
    }
}