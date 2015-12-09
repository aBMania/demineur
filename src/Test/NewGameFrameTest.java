package Test;

import Controller.Graphical.Menu.NewGamePanelController;
import View.Graphical.Menu.NewGameFrame;

public class NewGameFrameTest {
    public static void main(String[] args) {
        NewGameFrame gameFrame = new NewGameFrame("New Game");
        new NewGamePanelController(gameFrame.getNewGamePanel());
    }
}
