package Model.Score;

import Model.GameState.GameDifficulty;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

public class Score implements Serializable, Comparable<Score>{
    Date date;
    Duration duration;
    GameDifficulty difficulty;

    public Score(Duration duration, GameDifficulty gameDifficulty) {
        this.duration = duration;
        this.difficulty = gameDifficulty;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Duration getDuration() {
        return duration;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public int compareTo(Score score) {
        int durationComparison = duration.compareTo(score.getDuration());

        if(durationComparison != 0) // If the duration isn't the same
            return durationComparison;

        // If the duration is the same, the most recent is the worst
        return date.compareTo(score.getDate());
    }

}
