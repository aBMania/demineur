package Controller.Graphical;

import Controller.GameController;
import Model.GameCell.GameCell;
import View.Graphical.GameComponents.CellView;
import View.Graphical.GraphicalGameView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicalGameController extends GameController implements MouseListener {
    private GraphicalGameView view;

    public GraphicalGameController(GraphicalGameView view) {
        super(view);
        this.view = view;

        for(CellView cellView : view.getGrid().getCellsViews()){
            cellView.addMouseListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Object source = mouseEvent.getSource();

        if(source instanceof CellView)
        {
            CellView cellView = (CellView) mouseEvent.getSource();
            GameCell cell = cellView.getCell();

            if(SwingUtilities.isLeftMouseButton(mouseEvent))
                view.fireDiscoverCell(cell);

            if(SwingUtilities.isRightMouseButton(mouseEvent))
            {
                switch (cell.getState())
                {
                    case HIDDEN:
                        view.fireMarkCellWithExclamationMark(cell);
                        break;
                    case FLAG_EXCLAMATIONMARK:
                        view.fireMarkCellWithQuestionMark(cell);
                        break;
                    case FLAG_QUESTIONMARK:
                        view.fireClearCellMark(cell);
                        break;
                    case VISIBLE:
                    default:
                        break;
                }
            }
        }
    }



    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
