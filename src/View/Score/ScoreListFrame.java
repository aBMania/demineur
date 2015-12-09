package View.Score;

import Model.Score.Score;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ScoreListFrame extends JFrame {
    public ScoreListFrame(List<Score> scoreList) throws HeadlessException {
        super("Score list");
        add(new ScoreListPanel(scoreList));

        pack();
        setVisible(true);
    }
}
