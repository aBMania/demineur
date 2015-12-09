package View.Graphical.TimerView;

import Model.GameState.GameState;
import Model.Timer.TimerModel;
import View.Graphical.Components.GameFrame;

import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 * Created by ISEN on 09/12/2015.
 */
public class TimerView extends JLabel {
    private String sentence;
    private TimerModel timerModel = new TimerModel();

    public TimerView() {
        this.setText(sentence);
        Timer t = new java.util.Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        };
        t.schedule(task, 1000, 1000);

    }

    public void refresh() {
        int t = (int) timerModel.getDuration().getSeconds();
        setText(t + " ");
    }

}


