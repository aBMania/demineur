package Test;

import Model.Timer.TimerModel;
import View.Graphical.TimerView.TimerView;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class TimerTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        TimerModel timer = new TimerModel();
        TimerView timerView = new TimerView(timer);
        f.add(timerView, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
