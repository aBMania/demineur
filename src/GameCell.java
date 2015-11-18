import java.util.List;
import java.util.ArrayList;


public class GameCell {
    private Integer x = 0;
    private Integer y = 0;
    private boolean mined = false; // true if cell is mined
    private GameCellState state = null;
    private List<GameCell> neihgbor;


    public GameCell(Integer x, Integer y, boolean mined, GameCellState state) {
        this.x = x;
        this.y = y;
        this.mined = mined;
        this.state = state;
        this.neihgbor = new ArrayList<GameCell>();
    }

    public GameCell(Integer x, Integer y, boolean mined, GameCellState state, List<GameCell> neighbors) {
        this.x = x;
        this.y = y;
        this.mined = mined;
        this.state = state;
        this.neihgbor = neighbors;
    }
    public void addNeighboor(GameCell cell) {
        neihgbor.add(cell);
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

    public int getNumberBombsNear() {
        int nbBonbsNear = 0;
        for(GameCell cell : this.neihgbor ){
            if(cell.isMined()){
                nbBonbsNear++;
            }
        }
        return nbBonbsNear;
    }
    public boolean isHidden() {
        return this.getState().equals(GameCellState.HIDDEN);
    }
}
