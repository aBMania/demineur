package Test;

import View.Graphical.GamePanel.NewGamePanel;

import javax.swing.*;

public class NewGamePanelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NewGamePanel panel = new NewGamePanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);


    }
}
