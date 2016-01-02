package controller.Graphical.Menu;

import service.MineSweeperService;
import service.ScoreManagerService;
import view.Graphical.Menu.GameDifficultyMenuItem;
import view.Graphical.Menu.GameMenu;
import view.Score.ScoresFrame;

import javax.swing.*;

public class MenuController {

    public MenuController(GameMenu gameMenu) {

        for(GameDifficultyMenuItem menuItem : gameMenu.getGameDifficultyMenuItemList()){
            menuItem.addActionListener(e -> {
                MineSweeperService.newGame(menuItem.getGameDifficulty());
                JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
                frame.dispose();
            });
        }

        gameMenu.getCustomMenuItem().addActionListener(e -> {
            MineSweeperService.newCustomGame();
            JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
            frame.dispose();
        });

        gameMenu.getQuitMenuItem().addActionListener(e -> System.exit(0));

        gameMenu.getScoresMenuItem().addActionListener(e -> new ScoresFrame(ScoreManagerService.getScoreLists()));
    }
}
