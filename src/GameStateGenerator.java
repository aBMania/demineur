import java.util.ArrayList;
import java.util.List;

public class GameStateGenerator {
    public static GameState newBlankGameState(Integer x, Integer y){

        List<GameStateRow> gameStateRows = new ArrayList<>(y);

        for(int i = 0; i < y; i++)
        {
            GameStateRow row;
            List<GameCell> cells = new ArrayList<>(x);

            for(int j = 0; j < y; j++) {
                cells.add(new GameCell(i, j, false, GameCellState.FLAG_EXCLAMATIONMARK));
            }

            row = new GameStateRow(cells);
            gameStateRows.add(row);
        }

        GameState gs = new GameState(gameStateRows);
        gs.updateNeighbors();
        return gs;
    }
}
