package Controller.Graphical.Menu;

import View.Graphical.Menu.GameDifficultyMenuItem;
import View.Graphical.Menu.GameMenu;
import View.Score.ScoresFrame;
import service.MineSweeperService;
import service.ScoreManagerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
