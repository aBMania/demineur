package Controller.Graphical;

import Controller.GameController;
import View.Graphical.GraphicalGameView;


public class GraphicalGameController extends GameController{

    public GraphicalGameController(GraphicalGameView view) {
        super(view);
        new GraphicalGameFrameController(view.getGameFrame());
    }
}
