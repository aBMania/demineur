package Controller.Graphical;

import Model.GameCell.GameCell;
import View.Graphical.GameComponents.CellView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicalCellController extends MouseAdapter {
    private final CellView cellView;
    private final GraphicalGridController gridController;

    public GraphicalCellController(GraphicalGridController gridController, CellView cellView) {
        this.gridController = gridController;
        this.cellView = cellView;
        cellView.addMouseListener(this);
    }

    public GraphicalGridController getGridController() {
        return gridController;
    }

    public void mouseClicked(MouseEvent mouseEvent){
        CellView cellView = (CellView) mouseEvent.getSource();
        GameCell cell = cellView.getCell();

        if(SwingUtilities.isLeftMouseButton(mouseEvent))
            gridController.getGameController().getView().fireDiscoverCell(cell);

        if(SwingUtilities.isRightMouseButton(mouseEvent))
        {
            switch (cell.getState())
            {
                case HIDDEN:
                    gridController.getGameController().getView().fireMarkCellWithExclamationMark(cell);
                    break;
                case FLAG_EXCLAMATIONMARK:
                    gridController.getGameController().getView().fireMarkCellWithQuestionMark(cell);
                    break;
                case FLAG_QUESTIONMARK:
                    gridController.getGameController().getView().fireClearCellMark(cell);
                    break;
                case VISIBLE:
                default:
                    break;
            }
        }
    }
}


