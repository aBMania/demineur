package view.Score;

import model.Score.Score;

import javax.swing.*;

public class ScoreView extends JPanel{
    private Score score;

    public ScoreView(Score score, Integer order) {
        this.score = score;

        long s = score.getDuration().getSeconds();
        String durationString = String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));

        String fullString = "";

        if(order > 0)
        {
            fullString =  fullString + order.toString() + " : ";
        }

        fullString = fullString + durationString + "(" + score.getDifficulty().toString() + ")";

        add(new JLabel(fullString));
    }

    public ScoreView(Score score) {
        this(score, 0);
    }
}
