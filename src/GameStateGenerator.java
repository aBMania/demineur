import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameStateGenerator {

    public static GameState newBlankGameState(Integer x, Integer y){

        List<GameStateRow> gameStateRows = new ArrayList<>(y);

        for(int i = 0; i < y; i++)
        {
            GameStateRow row;
            List<GameCell> cells = new ArrayList<>(x);

            for(int j = 0; j < x; j++) {
                cells.add(new GameCell(i, j, false, GameCellState.HIDDEN));
            }

            row = new GameStateRow(cells);
            gameStateRows.add(row);
        }

        GameState gs = new GameState(gameStateRows);
        gs.updateNeighbors();
        return gs;
    }
    public static GameState newGame(Integer perCent,Integer x, Integer y){
        GameState gs = newBlankGameState(x,y);
        Random rand = new Random();
        for(int i = 0; i < x; i++ ){
            for(int j = 0; j < y; j++){
                int randomNum = rand.nextInt((100) + 1);
                if(randomNum <= perCent ){
                    gs.getXYCell(i,j).setMined(true);
                }
            }
        }
        return gs;
    }
}
