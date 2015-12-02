package Controller.Graphical;

import Controller.GameController;
import Model.GameCell.GameCell;
import View.Graphical.GameComponents.CellView;
import View.Graphical.GraphicalGameView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicalGameController extends GameController{
    private GraphicalGameView view;
    private GraphicalGridController gridController;

    public GraphicalGameController(GraphicalGameView view) {
        super(view);

        this.view = view;
        this.gridController = new GraphicalGridController(this);
    }

    public GraphicalGameView getView() {
        return view;
    }
}
