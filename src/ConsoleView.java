import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer {

    private boolean debug = false;
    private GameState gs;

    public ConsoleView(GameState gameState) {
        this.gs = gameState;
        gameState.addObserver(this);
    }

    public ConsoleView(GameState gameState, boolean debug) {
        this(gameState);
        this.debug = debug;
    }


    public String getCellRepresentation(GameCell gameCell) {

        if(gameCell.isHidden()){
            if(this.debug && gameCell.isMined())
                return "x";
            return "#";
        }

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
                return "?";
            case FLAG_QUESTIONMARK:
                return "!";
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }

    public void printGameState(){
        for(int y = 0; y < this.gs.getSizeY(); y++){
            for(int x = 0; x < this.gs.getSizeX();x++){
                System.out.print(getCellRepresentation(this.gs.getXYCell(x, y)) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.printGameState();
    }
}
