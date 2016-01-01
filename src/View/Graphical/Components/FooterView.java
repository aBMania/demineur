package view.Graphical.Components;

import model.GameState.GameState;
import view.Graphical.TimerView.TimerView;

import javax.swing.*;

public class FooterView extends JPanel{

    private GameFrame gameFrame;
    private JLabel sentence;
    private JLabel imageFlag;
    private JLabel imageTimer;
    private TimerView timer;

    public FooterView(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        sentence = new JLabel("");

        imageFlag = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ressources/images/drap.png")));
        imageTimer = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ressources/images/timer.png")));
        timer = new TimerView(getGameState().getTimer());

        add(imageTimer);
        add(timer);
        add(imageFlag);
        add(sentence);
    }

    public void refresh() {
        sentence.setText("Drapeaux restant : " + (getGameState().getRemainingFlag()));
    }

    private GameState getGameState() {
        return gameFrame.getGameState();
    }
}