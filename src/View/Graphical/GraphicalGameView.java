package View.Graphical;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class GraphicalGameView extends GameView {

    private JFrame frame;
    private final static String FRAME_TITLE = "Demineur";


    public GraphicalGameView(GameState gameState) {
        super(gameState);

        frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(gameState.getSizeY(), gameState.getSizeX()));

        for(int x = 0; x < getGameState().getSizeX();x++){
            for(int y = 0; y < getGameState().getSizeY(); y++){
                GameCell cell = getGameState().getXYCell(x, y);
                frame.add(new GraphicalCellView(cell));
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
