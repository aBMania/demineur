package Model.Timer;

import javafx.scene.paint.Stop;

import java.sql.Time;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {
    private Duration duration;
    private Timer t;

    public TimerModel(){
        t = new Timer();
        duration = duration.ofSeconds(0);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                 duration = duration.plusSeconds(1);
            }
        };
        t.schedule(task, 1000, 1000);
    }
    public void Stop(){
        t.cancel();
    }

    public Duration getDuration() {
        return duration;
    }
}
