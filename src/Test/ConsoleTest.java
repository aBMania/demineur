package test;

import controller.Console.ConsoleGameController;
import model.GameState.GameState;
import model.GameState.GameStateFactory;
import view.Console.ConsoleGameView;

import java.util.Scanner;


public class ConsoleTest {

    private static final boolean DEBUG = false;

    private static void printIntro() {
        System.out.println("Pour jouer, entrez la taille de la grille ainsi que le pourcentage de bombes");
        printFormat();
    }

    private static void printFormat() {
        System.out.println("Le format est le suivant : \"x y percentage\"");
    }

    private static void createGame() {
        Scanner scanner = new Scanner(System.in);
        boolean validEntry = false;

        while(!validEntry)
        {
            String line = scanner.nextLine();
            String args[] = line.split(" ");

            if(args.length != 3) {
                printFormat();
                continue;
            }

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int percentage = Integer.parseInt(args[2]);

            GameState gameState;

            try{
                gameState = GameStateFactory.newGameStateByPercentage(x, y, percentage);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }

            ConsoleGameView debugView = new ConsoleGameView(gameState, DEBUG);
            new ConsoleGameController(debugView);

            validEntry = true;
        }
    }

    public static void main(String[] args) {
        printIntro();
        createGame();
    }
}