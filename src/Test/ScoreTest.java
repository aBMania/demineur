package test;

import model.GameState.GameConstants;
import model.Score.Score;
import view.Score.ScoresFrame;
import service.ScoreManagerService;

import java.time.Duration;

public class ScoreTest {
    public static void main(String[] args) {


        ScoreManagerService.addScore(new Score(Duration.ofSeconds(100), GameConstants.GAME_DIFFICULTIES.get(0)));
        ScoreManagerService.addScore(new Score(Duration.ofSeconds(110), GameConstants.GAME_DIFFICULTIES.get(0)));
        ScoreManagerService.addScore(new Score(Duration.ofSeconds(90), GameConstants.GAME_DIFFICULTIES.get(0)));

        ScoreManagerService.addScore(new Score(Duration.ofSeconds(180), GameConstants.GAME_DIFFICULTIES.get(1)));
        ScoreManagerService.addScore(new Score(Duration.ofSeconds(185), GameConstants.GAME_DIFFICULTIES.get(1)));
        ScoreManagerService.addScore(new Score(Duration.ofSeconds(180), GameConstants.GAME_DIFFICULTIES.get(1)));

        new ScoresFrame(ScoreManagerService.getScoreLists());
    }
}
