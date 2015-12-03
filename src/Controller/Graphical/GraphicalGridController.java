package Controller.Graphical;

import View.Graphical.GameComponents.CellView;
import View.Graphical.GameComponents.GridView;

import java.util.ArrayList;
import java.util.List;

public class GraphicalGridController {
    private List<GraphicalCellController> cellControllerList = new ArrayList<>();

    public GraphicalGridController(GridView gridView) {
        for(CellView cellView : gridView.getCellsViews())
        {
            GraphicalCellController cellController = new GraphicalCellController(cellView);
            cellControllerList.add(cellController);
        }
    }
}
