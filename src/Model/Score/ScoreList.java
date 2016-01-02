package model.Score;

import model.GameState.GameDifficulty;

import java.util.TreeSet;

public class ScoreList extends TreeSet<Score> {
    private GameDifficulty difficulty;

    public ScoreList() {
    }

    public ScoreList(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
