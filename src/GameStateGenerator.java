import java.util.*;


public class GameStateGenerator {


    public static GameState newBlankGameState(Integer x, Integer y,Integer perCent) {

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
