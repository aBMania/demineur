package View.Graphical;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GraphicalGridView grid;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        grid = new GraphicalGridView(gameState);

        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(grid);

        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
//        if(getGameState().isLost())
//            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        grid.refresh();
    }
}
