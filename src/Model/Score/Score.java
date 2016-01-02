package model.Score;

import model.GameState.GameDifficulty;

import java.io.Serializable;
import java.util.Date;

public class Score implements Serializable, Comparable<Score>{
    Date date;
    long duration;
    GameDifficulty difficulty;

    public Score() {
    }

    public Score(long duration, GameDifficulty gameDifficulty) {
        this.duration = duration;
        this.difficulty = gameDifficulty;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    @Override
    public int compareTo(Score score) {
        int durationComparison = Long.compare(duration, score.getDuration());

        if(durationComparison != 0) // If the duration isn't the same
            return durationComparison;

        // If the duration is the same, the most recent is the worst
        return date.compareTo(score.getDate());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
