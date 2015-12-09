package Test;

import Model.Timer.TimerModel;
import View.Graphical.TimerView.TimerView;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

/**
 * Created by ISEN on 09/12/2015.
 */
public class TimerTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        TimerView t = new TimerView();
        f.add(t, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
