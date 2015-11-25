package View.Graphical;

import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GraphicalGridView grid;
    private GraphicalFooterView footer;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        initFrame();

        frame.setJMenuBar(new GraphicalMenuView());

        grid = new GraphicalGridView(gameState);
        footer = new GraphicalFooterView(gameState);

        frame.add(grid, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public void initFrame(){
        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(frame != null && getGameState() != null && getGameState().isLost())
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        grid.refresh();
        footer.refresh();
    }
}
