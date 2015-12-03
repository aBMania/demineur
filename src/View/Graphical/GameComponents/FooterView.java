package View.Graphical.GameComponents;

import Model.GameState.GameState;

import javax.swing.*;

public class FooterView extends JPanel{

    private GameFrame gameFrame;
    private JLabel sentence;
    private JLabel image;

    public FooterView(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        sentence = new JLabel("");

        image = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ressources/images/drap.png")));


        this.add(image);
        this.add(sentence);
    }

    public void refresh() {
        sentence.setText("Drapeaux restant : " + (getGameState().getRemainingFlag()));
    }

    private GameState getGameState() {
        return gameFrame.getGameState();
    }
}