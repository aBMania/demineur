package view.Score;

import model.Score.ScoreList;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


public class ScoresFrame extends JFrame {
    public ScoresFrame(Map<String, ScoreList> scoreLists) {
        super("Score list");
        setLayout(new FlowLayout());

        scoreLists.forEach((difficultyName, scoreList) -> add(new ScoreListPanel(scoreList)));

        pack();
        setVisible(true);
    }
}
