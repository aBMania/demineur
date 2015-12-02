package Controller;

import View.GameView;
import View.Graphical.GraphicalGameView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicalGameController extends GameController implements MouseListener {
    private GraphicalGameView viewGraphic;

    public GraphicalGameController(GraphicalGameView view) {
        super(view);
        viewGraphic = view;
        view.getGrid().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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
