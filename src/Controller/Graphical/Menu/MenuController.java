package Controller.Graphical.Menu;

import View.Graphical.Menu.GameDifficultyMenuItem;
import View.Graphical.Menu.GameMenu;
import service.MineSweeperService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MenuController {
    private final GameMenu gameMenu;

    public MenuController(GameMenu gameMenu) {
        this.gameMenu = gameMenu;

        for(GameDifficultyMenuItem menuItem : gameMenu.getGameDifficultyMenuItemList()){
            menuItem.addActionListener(e -> {
                MineSweeperService.newGame(menuItem.getGameDifficulty());
                JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            });
        }

        gameMenu.getCustomMenuItem().addActionListener(e -> MineSweeperService.newCustomGame());

        gameMenu.getQuitMenuItem().addActionListener(e -> System.exit(0));

    }
}
