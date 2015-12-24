package Model.GameState;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellState;

import java.util.ArrayList;
import java.util.List;


public class GameStateFactory {

    public static final int MAX_PERCENTAGE = 85;
    public static final int MIN_SIZE = 2;

    public static GameState newGameState(GameDifficulty gameDifficulty) {
        GameState gameState= newGameState(gameDifficulty.getCols(), gameDifficulty.getRows(), gameDifficulty.getMines());
        gameState.setGameDifficulty(gameDifficulty);
        return gameState;
    }

    public static GameState newGameState(Integer x, Integer y, Integer nBombs) {
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

        GameState gs = new GameState(gameStateRows, nBombs);

        gs.updateNeighbors();

        return gs;
    }


    public static GameState newGameStateByPercentage(Integer x, Integer y, Integer perCent) {

        if(perCent >= MAX_PERCENTAGE)
        {
            throw new IllegalArgumentException("Vous devez avoir au maximum " + MAX_PERCENTAGE + "% de mines");
        }

        if(x < MIN_SIZE || y < MIN_SIZE)
        {
            throw new IllegalArgumentException("Les tailles du plateau doivent être au minimum de " + MIN_SIZE);
        }

        return newGameState(x, y, perCent*x*y/100);
    }

}
