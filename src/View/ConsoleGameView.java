package View;

import Model.GameCell.GameCell;
import Model.GameState.GameState;

import java.util.Observable;
import java.util.Observer;

public class ConsoleGameView extends GameView implements Observer {

    private boolean debug = false;
    private boolean quit = false;

    public ConsoleGameView(GameState gameState) {
        super(gameState);
        gameState.addObserver(this);
    }

    public ConsoleGameView(GameState gameState, boolean debug) {
        super(gameState);
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
        for(int y = 0; y < getGameState().getSizeY(); y++){
            for(int x = 0; x < getGameState().getSizeX();x++){
                System.out.print(getCellRepresentation(getGameState().getXYCell(x, y)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.printGameState();

        if(getGameState().isWon())
        {
            System.out.println("Vous avez gagné !");
            quit();
        }

        if(getGameState().isLost())
        {
            System.out.println("Vous avez perdu !");
            quit();
        }
    }

    public GameState getGameState() {
        return super.getGameState();
    }

    public void quit(){
        this.quit = true;
    }

    public boolean haveToQuit(){
        return quit;
    }
}
