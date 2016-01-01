package controller.Graphical.Components;

import controller.Graphical.Menu.GameFrameController;
import view.Graphical.GameView;


public class GameController extends controller.GameController {

    public GameController(GameView view) {
        super(view);
        new GameFrameController(view.getGameFrame());
    }
}
