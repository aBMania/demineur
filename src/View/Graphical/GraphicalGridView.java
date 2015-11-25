package View.Graphical;

import Model.GameCell.GameCell;
import Model.GameState.GameState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicalGridView extends JPanel {

    public static final int CELL_SIZE = 50;

    private GameState gameState;
    private List<GraphicalCellView> cellsViews;
    private Dimension cellDimension;

    public GraphicalGridView(GameState gameState) {
        this.gameState = gameState;
        this.cellsViews = new ArrayList<>();
        this.cellDimension = new Dimension(CELL_SIZE, CELL_SIZE);

        setLayout(new GridLayout(getGameState().getSizeY(), getGameState().getSizeX()));

        for(int y = 0; y < getGameState().getSizeY(); y++){
            for(int x = 0; x < getGameState().getSizeX(); x++){

                GameCell cell = getGameState().getXYCell(x, y);
                GraphicalCellView cellView = new GraphicalCellView(cell, cellDimension);

                this.cellsViews.add(cellView);
                add(cellView);
            }
        }
    }

    public void refresh(){
        cellsViews.forEach(GraphicalCellView::refresh);
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
