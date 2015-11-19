import java.util.List;
import java.util.ArrayList;


public class GameCell {
    private Integer x = 0;
    private Integer y = 0;
    private boolean mined = false; // true if cell is mined
    private GameCellState state = null;
    private List<GameCell> neighbor;
    private Integer numberBombsNear = 0;

    public GameCell(Integer x, Integer y, boolean mined, GameCellState state, List<GameCell> neighbors) {
        this.x = x;
        this.y = y;
        this.mined = mined;
        this.state = state;
        this.neighbor = neighbors;
    }

    public GameCell(Integer x, Integer y, boolean mined, GameCellState state) {
        this(x, y, mined, state, new ArrayList<>());
    }

    public void addNeighbor(GameCell cell) {
        neighbor.add(cell);
    }

    public boolean isMined() {
        return this.mined;
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

    public boolean isHidden() {
        return this.getState().equals(GameCellState.HIDDEN);
    }

    public boolean isVisible() {
        return !isHidden();
    }

    public int getNumberBombsNear() {
        return numberBombsNear;
    }

    public void setNumberBombsNear(Integer numberBombsNear) {
        this.numberBombsNear = numberBombsNear;
    }


    public List<GameCell> getNeighbor() {
        return neighbor;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
