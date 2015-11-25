package View.Graphical;

import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GraphicalGridView grid;
    private GraphicalFooterView footer;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        grid = new GraphicalGridView(gameState);
        footer = new GraphicalFooterView(gameState);

        frame.setJMenuBar(new GraphicalMenuView());
        frame.add(grid, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

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
