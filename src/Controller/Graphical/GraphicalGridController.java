package Controller.Graphical;

import View.Graphical.GameComponents.CellView;
import View.Graphical.GameComponents.GridView;

import java.util.ArrayList;
import java.util.List;

public class GraphicalGridController {
    private GraphicalGameController gameController;
    private GridView gridView;
    private List<GraphicalCellController> cellControllerList = new ArrayList<>();

    public GraphicalGridController(GraphicalGameController gameController) {
        this.gameController = gameController;

        this.gridView = gameController.getView().getGrid();

        for(CellView cellView : gridView.getCellsViews())
        {
            GraphicalCellController cellController = new GraphicalCellController(this, cellView);
            cellControllerList.add(cellController);
        }
    }


    public GraphicalGameController getGameController() {
        return gameController;
    }
}
