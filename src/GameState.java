import java.util.*;

public class GameState {
    private List<GameStateRow> gameStateRows;
    private Integer sizeX;
    private Integer sizeY;

    public GameState(List<GameStateRow> gameStateRows) {
        this.setSizeY(gameStateRows.size());
        this.setSizeX(gameStateRows.get(0).getCellRow().size());

        this.gameStateRows = gameStateRows;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        if(sizeX <= 0)
            throw new RuntimeException("GameState X size cannot be null or negative");
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        if(sizeY <= 0)
            throw new RuntimeException("GameState X size cannot be null or negative");

        this.sizeY = sizeY;
    }

    public GameCell getXYCell(int x, int y){
        return gameStateRows.get(y).getCellRow().get(x);
    }

    public void updateNeighbors() {
        int x = 0;
        for(GameStateRow row : gameStateRows)
        {
            int y = 0;
            for(GameCell cell : row.getCellRow()) {

                for(int i=(x-1); i<(x+1); i++){
                    for(int j=(y-1); j<(y+1); j++){
                        if(i != j){
                            GameCell neighbor = getXYCell(i, j);

                            if(neighbor != null)
                                cell.addNeighbor(neighbor);
                        }
                    }
                }

                y++;
            }
            x++;
        }
    }
}
