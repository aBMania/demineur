package View.Score;

import Model.Score.Score;

import javax.swing.*;

public class ScoreView extends JPanel{
    private Score score;

    public ScoreView(Score score) {
        this.score = score;

        long s = score.getDuration().getSeconds();
        String durationString = String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));

        add(new JLabel(durationString + " : " + score.getGameDifficulty().toString()));
    }
}
