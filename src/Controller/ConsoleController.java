package Controller;

import Model.GameCell.GameCell;
import Model.GameState.GameState;
import View.ConsoleView;

import java.util.Scanner;

public class ConsoleController extends GameController {

    private ConsoleView consoleView;

    public ConsoleController(ConsoleView view) {
        super(view);
        this.consoleView = view;

        start();
    }

    public void start(){
        this.consoleView.printBienvenue();
        this.consoleView.printHelp();
        this.consoleView.printGameState();

        while(!consoleView.haveToQuit()){
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
                consoleView.printHelp();
                break;
            case "q":
                consoleView.quit();
                break;
            case "d":
                if(parts.length != 3 || !parts[1].matches("\\d+") || !parts[2].matches("\\d+"))
                    throw new Exception("Le format de la commande est : d i j");

                cell = this.getGameState().getXYCell(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                consoleView.fireDiscoverCell(cell);
                break;
            case "m":
                if(parts.length != 4 || !parts[1].matches("\\d+") || !parts[2].matches("\\d+"))
                    throw new Exception("Le format de la commande est : m i j x ou m i j ?");

                cell = this.getGameState().getXYCell(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));

                switch (parts[3])
                {
                    case "x":
                        consoleView.fireMarkCellWithExclamationMark(cell);
                        break;
                    case "?":
                        consoleView.fireMarkCellWithQuestionMark(cell);
                        break;
                }

                break;
            default:
                throw new Exception("Commande inconnue");
        }

    }
}