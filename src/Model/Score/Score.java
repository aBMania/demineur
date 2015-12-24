package Model.Score;

import Model.GameState.GameDifficulty;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

public class Score implements Serializable{
    Date date;
    Duration duration;
    GameDifficulty gameDifficulty;

    public Score(Duration duration, GameDifficulty gameDifficulty) {
        this.duration = duration;
        this.gameDifficulty = gameDifficulty;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Duration getDuration() {
        return duration;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void register() {
        ScoreList.getInstance().addScore(this);
    }
}
