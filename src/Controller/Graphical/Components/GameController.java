package Controller.Graphical.Components;

import Controller.Graphical.Menu.GameFrameController;
import View.Graphical.GameView;


public class GameController extends Controller.GameController {

    public GameController(GameView view) {
        super(view);
        new GameFrameController(view.getGameFrame());
    }
}
