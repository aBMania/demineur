package controller.Graphical.Menu;

import controller.Graphical.Components.GridController;
import view.Graphical.Components.GameFrame;

public class GameFrameController {
    public GameFrameController(GameFrame gameFrame) {
        new GridController(gameFrame.getGrid());
        new MenuController(gameFrame.getMenu());
    }
}
