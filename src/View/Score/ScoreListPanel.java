package View.Score;

import Model.Score.Score;
import Model.Score.ScoreList;

import javax.swing.*;
import java.awt.*;

public class ScoreListPanel extends JPanel {
    public ScoreListPanel(ScoreList scoreList) {
        setLayout(new GridLayout(scoreList.size() + 1 , 1));

        add(new JLabel(scoreList.getDifficulty().getName()));


        for(Score score : scoreList){
            add(new ScoreView(score));
        }
    }
}
