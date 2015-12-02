package View.Graphical;

import Model.GameState.GameState;
import View.GameView;
import View.Graphical.GameComponents.FooterView;
import View.Graphical.GameComponents.GridView;
import View.Graphical.GameMenu.GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private GridView grid;
    private FooterView footer;
    private final static String FRAME_TITLE = "Demineur";


    public GridView getGrid() {
        return grid;
    }

    public GraphicalGameView(GameState gameState) {
        super(gameState);

        initFrame();

        frame.setJMenuBar(new GameMenu());

        grid = new GridView(gameState);
        footer = new FooterView(gameState);

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
