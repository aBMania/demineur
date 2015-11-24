package Model.GameState;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellState;

import java.util.*;


public class GameStateFactory {


    public static final int MAX_PERCENTAGE = 85;
    public static final int MIN_SIZE = 2;

    public static GameState newGameState(Integer x, Integer y, Integer perCent) {

        if(perCent >= MAX_PERCENTAGE)
        {
            throw new IllegalArgumentException("Vous devez avoir au maximum " + MAX_PERCENTAGE + "% de mines");
        }

        if(x < MIN_SIZE || y < MIN_SIZE)
        {
            throw new IllegalArgumentException("Les tailles du plateau doivent être au minimum de " + MIN_SIZE);
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
