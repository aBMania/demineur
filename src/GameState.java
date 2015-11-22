import java.util.*;

public class GameState extends Observable {
    private List<GameStateRow> gameStateRows;
    private Integer sizeX;
    private Integer sizeY;
    private boolean won = false;
    private boolean lost = false;
    private boolean bombesPlaced = false;
    private Integer perCent;


    public GameState(List<GameStateRow> gameStateRows) {
        this.setSizeY(gameStateRows.size());
        this.setSizeX(gameStateRows.get(0).getCellRow().size());

        this.gameStateRows = gameStateRows;
    }

    public GameCell getXYCell(int x, int y){
        if(x >= getSizeX() || y >= getSizeY() || x < 0 || y < 0)
            throw new RuntimeException("No cells at x: " + x + ", y: " + y);

        return gameStateRows.get(y).getCellRow().get(x);
    }

    public void discoverCell(int x, int y){
        GameCell cell = this.getXYCell(x, y);
        discoverCell(cell);
    }

    public void discoverCell(GameCell cell){
        if(!bombesPlaced){
            placeBomb(cell);
        }
        if(cell.isMined())
            this.setLost(true);

        showCell(cell);

        setChanged();
        notifyObservers();
    }

    public void markCellWithQuestionMark(int x, int y){
        GameCell cell = this.getXYCell(x, y);
        markCellWithQuestionMark(cell);
    }

    public void markCellWithQuestionMark(GameCell cell){
        if(cell.isHidden()) {
            cell.setState(GameCellState.FLAG_QUESTIONMARK);
            setChanged();
        }
        notifyObservers();
    }

    public void markCellWithExclamationMark(int x, int y){
        GameCell cell = this.getXYCell(x, y);
        markCellWithExclamationMark(cell);
    }

    public void markCellWithExclamationMark(GameCell cell){
        if(cell.isHidden()) {
            cell.setState(GameCellState.FLAG_EXCLAMATIONMARK);
            setChanged();
        }
        notifyObservers();
    }

    private void showCell(GameCell cell) {

        //if(cell.isMined()) return;

        cell.setState(GameCellState.VISIBLE);

        if(cell.getNumberBombsNear() == 0) {
            for(GameCell neighbor : cell.getNeighbor()) {
                if(neighbor.isHidden() && !neighbor.isMined())
                    showCell(neighbor);
            }
        }
    }

    public void placeBomb(GameCell cellToAvoid){
        int x = this.getSizeX();
        int y = this.getSizeY();
        Integer nCells = x * y;
        Integer nBombs = nCells * this.getPerCent() / 100;
        List<Integer> cells = new LinkedList<>();

        /*
         * Pour distribuer les bombes, nous créons un tableau et y ajoutons pour chaque cellule un entier qui lui correspondra.
         * Pour éviter que le premier coup soit perdant, nous retirons l'entier correspondant à la première case découverte
         * Nous mélangeons ensuite le tableau et prenons les n premieres valeurs, qui seront les entiers correspondant aux cases minées
         */

        for (int i = 0; i < nCells; i++) {
            if(cellToAvoid == null || cellToAvoid.getX() * y + cellToAvoid.getY() != i)
                cells.add(i);
        }

        Collections.shuffle(cells);

        for (int i = 0; i < nBombs; i++) {
            Integer cellNumber = cells.get(i);

            int cellY = cellNumber % y;
            int cellX = (cellNumber - cellY) / y;

            GameCell cell = this.getXYCell(cellX, cellY);
            cell.setMined(true);

            for (GameCell neighbor : cell.getNeighbor()) {
                neighbor.setNumberBombsNear(neighbor.getNumberBombsNear() + 1);
            }
        }
    }

    public void updateNeighbors() {

        for(GameStateRow row : gameStateRows)
        {
            for(GameCell cell : row.getCellRow()) {

                Integer x = cell.getX();
                Integer y = cell.getY();

                int yMin = (y-1) < 0 ? 0 : (y-1);
                int yMax = (y+1) > getSizeY()-1 ? getSizeY()-1 : (y+1);

                for(int j = yMin; j <= yMax; j++){

                    int xMin = (x-1) < 0 ? 0 : (x-1);
                    int xMax = (x+1) > getSizeX()-1 ? getSizeX()-1 : (x+1);

                    for(int i = xMin; i <= xMax; i++) {
                        if(i != x || j != y){
                            cell.addNeighbor(getXYCell(i, j));
                        }
                    }
                }

            }
        }
    }
    public Integer getPerCent() {
        return perCent;
    }

    public void setPerCent(Integer perCent) {
        this.perCent = perCent;
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

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}
