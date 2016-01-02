package test;

import model.GameState.GameConstants;
import model.Score.Score;
import service.ScoreManagerService;
import view.Score.ScoresFrame;

public class ScoreTest {
    public static void main(String[] args) {

        // Run multiple times to see remebered scores

        ScoreManagerService.addScore(new Score(100, GameConstants.GAME_DIFFICULTIES.get(0)));
        ScoreManagerService.addScore(new Score(110, GameConstants.GAME_DIFFICULTIES.get(0)));
        ScoreManagerService.addScore(new Score(90, GameConstants.GAME_DIFFICULTIES.get(0)));

        ScoreManagerService.addScore(new Score(180, GameConstants.GAME_DIFFICULTIES.get(1)));
        ScoreManagerService.addScore(new Score(185, GameConstants.GAME_DIFFICULTIES.get(1)));
        ScoreManagerService.addScore(new Score(185, GameConstants.GAME_DIFFICULTIES.get(1)));

        new ScoresFrame(ScoreManagerService.getScoreLists());
    }
}
