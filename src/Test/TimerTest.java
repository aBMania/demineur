package test;

import model.Timer.TimerModel;
import view.Graphical.TimerView.TimerView;

import javax.swing.*;
import java.awt.*;

public class TimerTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        TimerModel timer = new TimerModel();
        TimerView timerView = new TimerView(timer);
        f.add(timerView, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
