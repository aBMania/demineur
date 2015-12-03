package Controller.Graphical.Components;

import View.Graphical.Components.CellView;
import View.Graphical.Components.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridController {


    public GridController(GridView gridView) {
        for(CellView cellView : gridView.getCellsViews())
        {
            new CellController(cellView);
        }
    }
}
