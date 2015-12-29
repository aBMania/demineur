package Model.Score;

import Model.GameState.GameDifficulty;
import java.util.TreeSet;

public class ScoreList extends TreeSet<Score> {
    private GameDifficulty difficulty;

    public ScoreList(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }
}
