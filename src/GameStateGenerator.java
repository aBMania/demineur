import java.util.*;


public class GameStateGenerator {

    public static GameState newBlankGameState(Integer x, Integer y){

        List<GameStateRow> gameStateRows = new ArrayList<>(y);

        for(int j = 0; j < y; j++)
        {
            GameStateRow row;
            List<GameCell> cells = new ArrayList<>(x);

            for(int i = 0; i < x; i++) {
                cells.add(new GameCell(i, j, false, GameCellState.HIDDEN));
            }

            row = new GameStateRow(cells);
            gameStateRows.add(row);
        }

        GameState gs = new GameState(gameStateRows);
        gs.updateNeighbors();
        return gs;
    }
    public static GameState newGame(Integer perCent, Integer x, Integer y){

        GameState gs = newBlankGameState(x,y);
        Integer nCells = x*y;
        Integer nBombs = nCells*perCent/100;
        List<Integer> cells = new LinkedList<>();

        for(int i = 0; i < nCells; i++) {
            cells.add(i);
        }

        // On mélange un tableau contenant les n premiers chiffres, n le nombre de cellules dans le jeu
        // On selectionne alors les x premièrs chiffres et on mine les cellules associées
        Collections.shuffle(cells);

        for(int i = 0; i < nBombs; i++){
            Integer cellNumber = cells.get(i);

            int cellY = cellNumber % y;
            int cellX = (cellNumber-cellY)/y;

            gs.getXYCell(cellX, cellY).setMined(true);
        }

        return gs;
    }
}
