package Model.GameState;

import Model.GameCell.GameCell;
import Model.GameCell.GameCellState;
import Model.Score.Score;
import Model.Timer.TimerModel;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class GameState extends Observable {
    private GameDifficulty gameDifficulty;
    private Score score;
    private List<GameStateRow> gameStateRows;
    private TimerModel timer = new TimerModel();
    private Integer sizeX;
    private Integer sizeY;
    private boolean won = false;
    private boolean lost = false;
    private boolean bombsPlaced = false;
    private Integer nFlag = 0;
    private Integer nBombs = 0;

    public GameState(List<GameStateRow> gameStateRows, Integer nBombs) {
        this.setSizeY(gameStateRows.size());
        this.setSizeX(gameStateRows.get(0).getCellRow().size());
        this.setNBombs(nBombs);

        this.gameStateRows = gameStateRows;
    }

    public GameCell getXYCell(int x, int y){
        if(x >= getSizeX() || y >= getSizeY() || x < 0 || y < 0)
            throw new IllegalArgumentException("No cells at x: " + x + ", y: " + y);

        return gameStateRows.get(y).getCellRow().get(x);
    }

    public void discoverCell(GameCell cell){
        if(isFinished())
            return;

        if(!bombsPlaced){
            timer.start();
            placeBomb(cell);
        }

        if(cell.isMined())
            endGame(false);

        showCell(cell);

        if(checkWon())
            endGame(true);

        setChanged();
        notifyObservers();
    }

    public void clearCellMark(GameCell cell){
        if(isFinished())
            return;

        if(cell.isVisible())
            return;

        if(cell.getState() != GameCellState.HIDDEN)
            setChanged();

        if(cell.getState() == GameCellState.FLAG_EXCLAMATIONMARK)
            setNFlag(getNFlag() - 1);

        cell.setState(GameCellState.HIDDEN);
    }

    public void clearCellMarkAction(GameCell cell){
        if(isFinished())
            return;

        clearCellMark(cell);
        notifyObservers();
    }

    public void markCellWithQuestionMark(GameCell cell){
        if(isFinished())
            return;

        if(cell.isVisible())
            return;

        clearCellMark(cell);
        cell.setState(GameCellState.FLAG_QUESTIONMARK);

        setChanged();
        notifyObservers();
    }

    public void markCellWithExclamationMark(GameCell cell){
        if(isFinished())
            return;

        if(cell.isVisible())
            return;

        if(getNFlag() >= getNBombs())
            return; // On ne peux pas marquer plus qu'il n'y a de bombes

        clearCellMark(cell);
        cell.setState(GameCellState.FLAG_EXCLAMATIONMARK);
        setNFlag(getNFlag() + 1);

        setChanged();
        notifyObservers();
    }

    private void showCell(GameCell cell) {

        if(cell.isVisible())
            return;

        cell.setState(GameCellState.VISIBLE);

        if(cell.getNumberBombsNear() == 0) {
            cell.getNeighbor()
                .stream()
                .filter(neighbor -> neighbor.isHidden() && !neighbor.isMined())
                .forEach(this::showCell);
        }
    }

    public void placeBomb(GameCell cellToAvoid){

        if(bombsPlaced) return;

        bombsPlaced = true;

        int x = this.getSizeX();
        int y = this.getSizeY();
        Integer nCells = x * y;
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

    private void setNFlag(Integer nFlag) {
        this.nFlag = nFlag;
    }

    public Integer getNFlag() {
        return nFlag;
    }

    public boolean isFinished() {
        return isLost() || isWon();
    }

    public boolean isWon() {
        return won;
    }

    private void endGame(boolean won){
        if(won)
            this.won = true;
        else
            this.won = false;

        if(won && gameDifficulty != null) {
            score = new Score(timer.getDuration(), gameDifficulty);
            score.register();
        }

        timer.stop();
    }

    public boolean isLost() {
        return lost;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    private void setNBombs(Integer nBombs) {
        this.nBombs = nBombs;
    }

    public Integer getNBombs() {
        return nBombs;
    }

    public boolean checkWon(){
        for (GameStateRow row:gameStateRows){
            for (GameCell cell:row.getCellRow()){
                if(cell.getState() != GameCellState.VISIBLE && !cell.isMined()){
                    return false;
                }
            }
        }
        return true;
    }

    public int getRemainingFlag() {
        return nBombs - nFlag;
    }

    public TimerModel getTimer() {
        return timer;
    }

    public Score getScore() { return score; }
}