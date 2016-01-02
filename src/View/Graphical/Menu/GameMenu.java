package view.Graphical.Menu;

import model.GameState.GameConstants;
import model.GameState.GameDifficulty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameMenu extends JMenuBar {
    private final JMenu gameMenu;
    private final JMenu newMenu;
    private final JMenuItem scoresMenuItem;
    private final List<GameDifficultyMenuItem> gameDifficultyMenuItemList = new ArrayList<>();
    private final JMenuItem customMenuItem;
    private final JMenuItem quitMenuItem;

    public GameMenu() {
        gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        this.add(gameMenu);

        scoresMenuItem = new JMenuItem("Scores");
        scoresMenuItem.setMnemonic(KeyEvent.VK_N);
        gameMenu.add(scoresMenuItem);

        newMenu = new JMenu("New");
        newMenu.setMnemonic(KeyEvent.VK_N);
        gameMenu.add(newMenu);


        for(GameDifficulty gameDifficulty : GameConstants.GAME_DIFFICULTIES){
            GameDifficultyMenuItem gameDifficultyMenuItem = new GameDifficultyMenuItem(gameDifficulty);
            gameDifficultyMenuItemList.add(gameDifficultyMenuItem);
            newMenu.add(gameDifficultyMenuItem);
        }

        customMenuItem = new JMenuItem("Custom");
        customMenuItem.setMnemonic(KeyEvent.VK_C);
        customMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        newMenu.add(customMenuItem);

        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.setMnemonic(KeyEvent.VK_Q);
        gameMenu.add(quitMenuItem);
    }

    public List<GameDifficultyMenuItem> getGameDifficultyMenuItemList() {
        return gameDifficultyMenuItemList;
    }

    public JMenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

    public JMenuItem getCustomMenuItem() {
        return customMenuItem;
    }

    public JMenuItem getScoresMenuItem() {
        return scoresMenuItem;
    }
}