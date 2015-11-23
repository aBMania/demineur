package View;

import Model.GameCell.GameCell;
import Model.GameState.GameState;

import java.util.Observable;
import java.util.Observer;

public class ConsoleView extends GameView implements Observer {

    private boolean debug = false;
    private boolean quit = false;
    private GameState gameState;

    public ConsoleView(GameState gameState) {
        this.gameState = gameState;
        gameState.addObserver(this);
    }

    public ConsoleView(GameState gameState, boolean debug) {
        this(gameState);
        this.debug = debug;
    }

    public String getCellRepresentation(GameCell gameCell) {

        switch (gameCell.getState()){
            case VISIBLE:
                if(gameCell.isMined()){
                    return "x";
                }
                else{
                    if(gameCell.getNumberBombsNear() == 0){
                        return ".";
                    }
                    else{
                        return Integer.toString(gameCell.getNumberBombsNear());
                    }
                }
            case FLAG_EXCLAMATIONMARK:
                return "!";
            case FLAG_QUESTIONMARK:
                return "?";
        }

        if(gameCell.isHidden()){
            if(this.debug && gameCell.isMined())
                return "x";
            return "#";
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }


    public void printHelp() {
        System.out.println("Voici les commandes :");
        System.out.println("d i j   : Dévoiler la case i j");
        System.out.println("m i j x : Marquer la case i j comme contenant une mine");
        System.out.println("m i j ? : Marquer la case i j comme étant indécise");
        System.out.println("q       : Quitter le jeu");
        System.out.println("help(h) : Afficher les commandes");
    }

    public void printBienvenue() {
        System.out.println("Bienvenue !");
    }

    public void printGameState(){
        for(int y = 0; y < this.gameState.getSizeY(); y++){
            for(int x = 0; x < this.gameState.getSizeX();x++){
                System.out.print(getCellRepresentation(this.gameState.getXYCell(x, y)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.printGameState();

        if(this.gameState.isWon())
        {
            System.out.println("Vous avez gagné !");
            quit();
        }

        if(this.gameState.isLost())
        {
            System.out.println("Vous avez perdu !");
            quit();
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void quit(){
        this.quit = true;
    }

    public boolean haveToQuit(){
        return quit;
    }
}
