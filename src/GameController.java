public class GameController {

    private GameState gameState;

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    public void discoverCell(int x, int y){
        GameCell cell = this.gameState.getXYCell(x, y);

        if(cell.isMined()) {
            gameState.setLost(true);
            return;
        }

        showCell(cell);
    }

    private void showCell(GameCell cell) {

        if(cell.getNumberBombsNear() > 0) {
            cell.setState(GameCellState.VISIBLE);
            return;
        }

        for(GameCell neighbor : cell.getNeighbor()) {
            showCell(cell);
        }

    }
}