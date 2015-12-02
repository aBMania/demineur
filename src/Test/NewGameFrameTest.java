package Test;

import Controller.Graphical.GraphicalNewGamePanelController;
import View.Graphical.GameMenu.NewGameFrame;

public class NewGameFrameTest {
    public static void main(String[] args) {
        NewGameFrame gameFrame = new NewGameFrame();
        new GraphicalNewGamePanelController(gameFrame);

    }
}
