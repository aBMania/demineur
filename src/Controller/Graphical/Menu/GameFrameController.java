package Controller.Graphical.Menu;

import Controller.Graphical.Components.GridController;
import View.Graphical.Components.GameFrame;

public class GameFrameController {
    public GameFrameController(GameFrame gameFrame) {
        new GridController(gameFrame.getGrid());
        new MenuController(gameFrame.getMenu());
    }
}
