package controller.Graphical.Components;

import model.GameCell.GameCell;
import view.Graphical.Components.CellView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellController extends MouseAdapter{
    private final CellView cellView;

    public CellController(CellView cellView) {
        this.cellView = cellView;
        cellView.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent mouseEvent){
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


