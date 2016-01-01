package controller.Graphical.Components;

import view.Graphical.Components.CellView;
import view.Graphical.Components.GridView;

public class GridController {


    public GridController(GridView gridView) {
        for(CellView cellView : gridView.getCellsViews())
        {
            new CellController(cellView);
        }
    }
}
