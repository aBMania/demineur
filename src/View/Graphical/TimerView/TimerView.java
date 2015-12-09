package View.Graphical.TimerView;

import Model.GameState.GameState;
import Model.Timer.TimerModel;
import View.Graphical.Components.GameFrame;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

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


