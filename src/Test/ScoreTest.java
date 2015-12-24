package Test;

import Model.GameState.GameConstants;
import Model.Score.Score;
import View.Score.ScoreListFrame;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        List<Score> scoreList = new ArrayList<>();

        scoreList.add(new Score(Duration.ofSeconds(100), GameConstants.GAME_DIFFICULTIES.get(0)));
        scoreList.add(new Score(Duration.ofSeconds(180), GameConstants.GAME_DIFFICULTIES.get(1)));

        new ScoreListFrame(scoreList);
    }
}
