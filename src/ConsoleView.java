import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

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

    public void start(){
        printBienvenue();
        printHelp();
        printGameState();

        while(!quit){
            try {
                waitForCommand();
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    private void waitForCommand() throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        if(parts.length <= 0) {
            throw new Exception("Commande inconnue");
        }

        GameCell cell;

        switch (parts[0]){
            case "help":
            case "h":
                printHelp();
                break;
            case "q":
                this.quit = true;
                break;
            case "d":
                if(parts.length != 3 || !parts[1].matches("\\d+") || !parts[2].matches("\\d+"))
                    throw new Exception("Le format de la commande est : d i j");

                cell = this.gameState.getXYCell(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                fireDiscoverCell(cell);
                break;
            case "m":
                if(parts.length != 4 || !parts[1].matches("\\d+") || !parts[2].matches("\\d+"))
                    throw new Exception("Le format de la commande est : m i j x ou m i j ?");

                cell = this.gameState.getXYCell(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));

                switch (parts[3])
                {
                    case "x":
                        fireMarkCellWithExclamationMark(cell);
                        break;
                    case "?":
                        fireMarkCellWithQuestionMark(cell);
                        break;
                }

                break;
            default:
                throw new Exception("Commande inconnue");
        }

    }

    private void printHelp() {
        System.out.println("Voici les commandes :");
        System.out.println("d i j   : Dévoiler la case i j");
        System.out.println("m i j x : Marquer la case i j comme contenant une mine");
        System.out.println("m i j ? : Marquer la case i j comme étant indécise");
        System.out.println("q       : Quitter le jeu");
        System.out.println("help(h) : Afficher les commandes");
    }

    private void printBienvenue() {
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
        if(this.gameState.isWon())
        {
            System.out.println("Vous avez gagné !");
            this.quit = true;
        }

        this.printGameState();

        if(this.gameState.isLost())
        {
            System.out.println("Vous avez perdu !");
            this.quit = true;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}
