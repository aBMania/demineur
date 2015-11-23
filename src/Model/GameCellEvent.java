package Model;

public class GameCellEvent{
    private GameCell gameCell;

    public GameCellEvent(GameCell gameCell) {
        this.gameCell = gameCell;
    }

    public GameCell getGameCell() {
        return gameCell;
    }
}
