package View.Graphical;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GraphicalGridView grid;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        grid = new GraphicalGridView(gameState);

        frame.add(grid);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        grid.refresh();
    }
}
