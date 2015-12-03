package Controller.Graphical;

import Model.GameCell.GameCell;
import View.Graphical.GameComponents.CellView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicalCellController extends MouseAdapter {
    private final CellView cellView;

    public GraphicalCellController(CellView cellView) {
        this.cellView = cellView;
        cellView.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent mouseEvent){
        CellView cellView = (CellView) mouseEvent.getSource();
        GameCell cell = cellView.getCell();

        if(SwingUtilities.isLeftMouseButton(mouseEvent))
            cellView.fireDiscoverCell();

        if(SwingUtilities.isRightMouseButton(mouseEvent))
        {
            switch (cell.getState())
            {
                case HIDDEN:
                    cellView.fireMarkCellWithExclamationMark();
                    break;
                case FLAG_EXCLAMATIONMARK:
                    cellView.fireMarkCellWithQuestionMark();
                    break;
                case FLAG_QUESTIONMARK:
                    cellView.fireClearCellMark();
                    break;
                case VISIBLE:
                default:
                    break;
            }
        }
    }
}


