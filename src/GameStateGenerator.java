import java.util.ArrayList;
import java.util.List;

public class GameStateGenerator {
    public static GameState newBlankGameState(Integer x, Integer y){

        List<GameStateRow> gameStateRows = new ArrayList<GameStateRow>(y);

        for(int i = 0; i < y; i++)
        {
            GameStateRow row;
            List<GameCell> cells = new ArrayList<GameCell>(x);

            for(int j = 0; j < y; j++) {
                cells.add(new GameCell(i, j, false, GameCellState.HIDDEN));
            }

            row = new GameStateRow(cells);
            gameStateRows.add(row);
        }

        GameState gs = new GameState(gameStateRows);
        gs.updateNeighbors();
        return gs;
    }
}
