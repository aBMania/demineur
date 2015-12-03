package Controller.Graphical;

import View.Graphical.GameComponents.GameFrame;

public class GraphicalGameFrameController {
    public GraphicalGameFrameController(GameFrame gameFrame) {
        GraphicalGridController gridController = new GraphicalGridController(gameFrame.getGrid());
        GraphicalMenuController menuController = new GraphicalMenuController(gameFrame.getMenu());
    }
}
