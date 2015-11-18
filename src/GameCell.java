public class GameCell {
    private boolean mined; // true if cell is mined
    private GameCellState state;
    private Integer x;
    private Integer y;
    private GameCell eastGameCell;
    private GameCell westGameCell;
    private GameCell northGameCell;
    private GameCell southGameCell;

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
