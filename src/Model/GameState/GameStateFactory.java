package Model.GameState;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellState;

import java.util.*;


public class GameStateFactory {


    private static final Integer MAX_PERCENTAGE = 85;

    public static GameState newGameState(Integer x, Integer y, Integer perCent) {

        if(perCent >= MAX_PERCENTAGE)
        {
            throw new RuntimeException("You cannot have more than " + MAX_PERCENTAGE + "% of bombs");
        }

        List<GameStateRow> gameStateRows = new ArrayList<>(y);

        for (int j = 0; j < y; j++) {
            GameStateRow row;
            List<GameCell> cells = new ArrayList<>(x);

            for (int i = 0; i < x; i++) {
                cells.add(new GameCell(i, j, false, GameCellState.HIDDEN));
            }

            row = new GameStateRow(cells);
            gameStateRows.add(row);
        }

        GameState gs = new GameState(gameStateRows);

        gs.updateNeighbors();
        gs.setPerCent(perCent);

        return gs;
    }

}
