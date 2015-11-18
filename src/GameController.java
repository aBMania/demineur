public class GameController {

    private GameState gameState;

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    public void discoverCell(int x, int y){
        GameCell cell = this.gameState.getXYCell(x, y);

    }
}