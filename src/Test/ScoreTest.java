package Test;

import Model.GameState.GameConstants;
import Model.Score.Score;
import Model.Score.ScoreList;
import View.Score.ScoreListFrame;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        ScoreList scoreList = ScoreList.getInstance();

        scoreList.addScore(new Score(Duration.ofSeconds(100), GameConstants.GAME_DIFFICULTIES.get(0)));
        scoreList.addScore(new Score(Duration.ofSeconds(180), GameConstants.GAME_DIFFICULTIES.get(1)));

        new ScoreListFrame(scoreList.getScoreList());
    }
}
