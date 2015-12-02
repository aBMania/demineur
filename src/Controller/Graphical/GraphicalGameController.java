package Controller.Graphical;

import Controller.GameController;
import View.Graphical.GraphicalGameView;


public class GraphicalGameController extends GameController{
    private final GraphicalGameView view;
    private final GraphicalGridController gridController;
    private final GraphicalMenuController menuController;

    public GraphicalGameController(GraphicalGameView view) {
        super(view);

        this.view = view;
        this.gridController = new GraphicalGridController(this);
        this.menuController = new GraphicalMenuController(this);
    }

    public GraphicalGameView getView() {
        return view;
    }
}
