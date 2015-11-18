public class GameController {

    private GameState gameState;

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    public void discoverCell(int x, int y){
        GameCell cell = this.gameState.getXYCell(x, y);
        discoverCell(cell);
    }

    public void discoverCell(GameCell cell){

        if(cell.isMined()) {
            gameState.setLost(true);
            return;
        }

        showCell(cell);
    }

    public void markCellWithQuestionMark(int x, int y){
        GameCell cell = this.gameState.getXYCell(x, y);
        markCellWithQuestionMark(cell);
    }

    public void markCellWithQuestionMark(GameCell cell){
        if(cell.isVisible()) return;

        cell.setState(GameCellState.FLAG_QUESTIONMARK);
    }

    public void markCellWithExclamationMark(int x, int y){
        GameCell cell = this.gameState.getXYCell(x, y);
        markCellWithExclamationMark(cell);
    }

    public void markCellWithExclamationMark(GameCell cell){
        if(cell.isVisible()) return;

        cell.setState(GameCellState.FLAG_EXCLAMATIONMARK);
    }

    private void showCell(GameCell cell) {

        if(cell.isMined()) return;
        cell.setState(GameCellState.VISIBLE);

        if(cell.getNumberBombsNear() == 0) {
            for(GameCell neighbor : cell.getNeighbor()) {
                if(neighbor.isHidden() && !neighbor.isMined())
                    showCell(neighbor);
            }
        }

    }



}