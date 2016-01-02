package model.GameState;

import model.GameCell.GameCell;

import java.util.List;

public class GameStateRow {
    private List<GameCell> cellRow;

    public GameStateRow(List<GameCell> cellRow) {
        this.setCellRow(cellRow);
    }

    public void setCellRow(List<GameCell> cellRow) {
        this.cellRow = cellRow;
    }

    public List<GameCell> getCellRow(){
        return this.cellRow;

    }
}
