package view.Graphical.TimerView;

import model.Timer.TimerModel;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerView extends JLabel {
    private TimerModel timerModel;

    public TimerView(TimerModel timerModel) {
        this.timerModel = timerModel;
        Timer t = new java.util.Timer();

        TimerTask refreshTask = new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        };
        t.schedule(refreshTask, 1000, 1000);

    }

    public void refresh() {
        int t = (int) timerModel.getDuration().getSeconds();
        setText(t + " ");
    }

}


