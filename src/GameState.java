import java.util.*;

public class GameState {
    private List<GameStateRow> gameStateRows;
    private Integer sizeX;
    private Integer sizeY;

    public GameState(List<GameStateRow> gameStateRows) {
        this.gameStateRows = gameStateRows;

        this.setSizeY(gameStateRows.size());
        this.setSizeX(gameStateRows.get(0).getCellRow().size());
    }

    public GameState(Integer sizeX, Integer sizeY) {
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
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

}
