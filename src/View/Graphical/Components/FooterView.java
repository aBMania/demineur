package View.Graphical.Components;

import Model.GameState.GameState;
import Model.Timer.TimerModel;
import View.Graphical.TimerView.TimerView;

import javax.swing.*;

public class FooterView extends JPanel{

    private GameFrame gameFrame;
    private JLabel sentence;
    private JLabel imageFlag;
    private TimerView timer;

    public FooterView(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        sentence = new JLabel("");

        imageFlag = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ressources/images/drap.png")));
        timer = new TimerView(getGameState().getTimer());

        this.add(timer);
        this.add(imageFlag);
        this.add(sentence);
    }

    public void refresh() {
        sentence.setText("Drapeaux restant : " + (getGameState().getRemainingFlag()));
    }

    private GameState getGameState() {
        return gameFrame.getGameState();
    }
}