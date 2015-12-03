package View.Graphical.GameComponents;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.Graphical.GraphicalGameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GridView extends JPanel {

    public static final int CELL_SIZE = 50;
    private GameFrame gameFrame;

    public List<CellView> getCellsViews() {
        return cellsViews;
    }

    private List<CellView> cellsViews;
    private Dimension cellDimension;

    public GridView(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.cellsViews = new ArrayList<>();
        this.cellDimension = new Dimension(CELL_SIZE, CELL_SIZE);

        setLayout(new GridLayout(getGameState().getSizeY(), getGameState().getSizeX()));

        for(int y = 0; y < getGameState().getSizeY(); y++){
            for(int x = 0; x < getGameState().getSizeX(); x++){

                GameCell cell = getGameState().getXYCell(x, y);
                CellView cellView = new CellView(this, cell, cellDimension);

                this.cellsViews.add(cellView);
                add(cellView);
            }
        }
    }

    public void refresh(){
        cellsViews.forEach(CellView::refresh);
    }

    public GameState getGameState() {
        return gameFrame.getGameState();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public void fireMarkCellWithQuestionMark(GameCell cell) {
        gameFrame.fireMarkCellWithQuestionMark(cell);
    }

    public void fireClearCellMark(GameCell cell) {
        gameFrame.fireClearCellMark(cell);
    }

    public void fireMarkCellWithExclamationMark(GameCell cell) {
        gameFrame.fireMarkCellWithExclamationMark(cell);
    }

    public void fireDiscoverCell(GameCell cell) {
        gameFrame.fireDiscoverCell(cell);
    }
}
