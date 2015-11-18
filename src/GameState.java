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
        if(x >= getSizeX() || y >= getSizeY() || x < 0 || y < 0)
            throw new RuntimeException("");

        return gameStateRows.get(y).getCellRow().get(x);
    }

    public void updateNeighbors() {
        int x = 0;
        for(GameStateRow row : gameStateRows)
        {
            int y = 0;
            for(GameCell cell : row.getCellRow()) {

                int xMin = (x-1) > 0 ? (x-1) : 0;
                int xMax = (x+1) < getSizeX() ? (x+1) : 0;

                for(int i = xMin; i < xMax; i++){

                    int yMin = (y-1) > 0 ? (y-1) : 0;
                    int yMax = (y+1) < getSizeY() ? (y+1) : 0;

                    for(int j = yMin; j < yMax; j++){
                        if(i != j){
                                cell.addNeighbor(getXYCell(i, j));
                        }
                    }
                }

                y++;
            }
            x++;
        }
    }
}
