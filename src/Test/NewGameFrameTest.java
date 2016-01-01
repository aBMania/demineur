package test;

import controller.Graphical.Menu.NewGamePanelController;
import view.Graphical.Menu.NewGameFrame;

public class NewGameFrameTest {
    public static void main(String[] args) {
        NewGameFrame gameFrame = new NewGameFrame("New Game");
        new NewGamePanelController(gameFrame.getNewGamePanel());
    }
}
