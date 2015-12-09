package View.Score;

import Model.Score.Score;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScoreListPanel extends JPanel {
    public ScoreListPanel(List<Score> scoreList) {
        setLayout(new GridLayout(scoreList.size(), 1));

        int i = 1;
        for(Score score : scoreList){
            add(new ScoreView(score, i));
            i++;
        }
    }
}
