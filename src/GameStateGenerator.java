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
    public static GameState StartNewGame(Integer per_cent,Integer x, Integer y){
        GameState gs = newBlankGameState(x,y);
        Random rand = new Random();
        for(int i = 0; i<x; i++ ){
            for(int j = 0; j < y; j++){
                int randomNum = rand.nextInt((100 - 0) + 1) + 0;
                if(randomNum <= per_cent ){
                    gs.getXYCell(i,j).setMined(true);
                }
            }
        }
        return gs;
    }
}
