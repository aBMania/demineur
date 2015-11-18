public class GameCell {
    private Integer x = 0;
    private Integer y = 0;
    private boolean mined = false; // true if cell is mined
    private GameCellState state = null;
    private GameCell eastGameCell = null;
    private GameCell westGameCell = null;
    private GameCell northGameCell = null;
    private GameCell southGameCell = null;


    public GameCell(Integer x, Integer y, boolean mined, GameCellState state) {
        this.x = x;
        this.y = y;
        this.mined = mined;
        this.state = state;
    }

    public GameCell(boolean mined, Integer x, Integer y, GameCell eastGameCell, GameCell westGameCell, GameCell northGameCell, GameCell southGameCell) {
        this(x, y, mined, state);
²
        this.eastGameCell = eastGameCell;
        this.westGameCell = westGameCell;
        this.northGameCell = northGameCell;
        this.southGameCell = southGameCell;
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
    public Integer getNumberBombsNear(){
        Integer nbBonbsNear = 0;
        if (this.getEastGameCell() != null && this.getEastGameCell().isMined() == true){
            nbBonbsNear++;
        }
        if (this.getNorthGameCell() != null && this.getNorthGameCell().isMined() == true){
            nbBonbsNear++;
        }
        if (this.getSouthGameCell() != null && this.getSouthGameCell().isMined() == true){
            nbBonbsNear++;
        }
        if (this.getWestGameCell() != null && this.getWestGameCell().isMined() == true){
            nbBonbsNear++;
        }

        if (this.getWestGameCell() != null && this.getWestGameCell().isMined() == true){
            nbBonbsNear++;
        }
        if (this.getWestGameCell() != null && this.getWestGameCell().isMined() == true){
            nbBonbsNear++;
        }
    }

    public boolean isHidden() {
        return this.getState().equals(GameCellState.HIDDEN);
    }
}
