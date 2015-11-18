public class GameCell {
    private boolean mined = false; // true if cell is mined
    private GameCellState state = null;
    private Integer x = 0;
    private Integer y = 0;
    private GameCell eastGameCell = null;
    private GameCell westGameCell = null;
    private GameCell northGameCell = null;
    private GameCell southGameCell = null;

    public GameCell(Integer x, Integer y, GameCell eastGameCell, GameCell westGameCell, GameCell northGameCell, GameCell southGameCell) {
        this.x = x;
        this.y = y;
        this.eastGameCell = eastGameCell;
        this.westGameCell = westGameCell;
        this.northGameCell = northGameCell;
        this.southGameCell = southGameCell;
        this.state = GameCellState.HIDDEN;
    }

    public GameCell(boolean mined, Integer x, Integer y, GameCell eastGameCell, GameCell westGameCell, GameCell northGameCell, GameCell southGameCell) {
        this.x = x;
        this.y = y;
        this.eastGameCell = eastGameCell;
        this.westGameCell = westGameCell;
        this.northGameCell = northGameCell;
        this.southGameCell = southGameCell;
        this.state = GameCellState.HIDDEN;
        this.mined = mined;
    }

    public boolean isMined() {
        return mined;
    }

    public void setMined(boolean mined) {
        this.mined = mined;
    }

    public GameCellState getState() {
        return state;
    }

    public void setState(GameCellState state) {
        this.state = state;
    }

    public GameCell getEastGameCell() {
        return eastGameCell;
    }

    public void setEastGameCell(GameCell eastGameCell) {
        this.eastGameCell = eastGameCell;
    }

    public GameCell getWestGameCell() {
        return westGameCell;
    }

    public void setWestGameCell(GameCell westGameCell) {
        this.westGameCell = westGameCell;
    }

    public GameCell getNorthGameCell() {
        return northGameCell;
    }

    public void setNorthGameCell(GameCell northGameCell) {
        this.northGameCell = northGameCell;
    }

    public GameCell getSouthGameCell() {
        return southGameCell;
    }

    public void setSouthGameCell(GameCell southGameCell) {
        this.southGameCell = southGameCell;
    }
}
