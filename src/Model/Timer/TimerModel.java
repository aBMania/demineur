package Model.Timer;

import javafx.scene.paint.Stop;

import java.sql.Time;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {
    private Duration duration = Duration.ZERO;
    TimerTask incrementTimerTask = new TimerTask() {
        @Override
        public void run() {
            duration = duration.plusSeconds(1);
        }
    };
    private Timer t = new Timer();

    public void start(){
        t.schedule(incrementTimerTask, 1000, 1000);
    }

    public void stop(){
        t.cancel();
    }

    public Duration getDuration() {
        return duration;
    }
}
