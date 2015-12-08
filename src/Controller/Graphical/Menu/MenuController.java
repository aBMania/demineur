package Controller.Graphical.Menu;

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

        gameMenu.getBeginnerMenuItem().addActionListener(actionEvent -> {
            MineSweeperService.newBeginnerGame();
            JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        gameMenu.getIntermediateMenuItem().addActionListener(actionEvent -> {
            MineSweeperService.newIntermediateGame();
            JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        gameMenu.getExpertMenuItem().addActionListener(actionEvent -> {
            MineSweeperService.newExpertGame();
            JFrame frame = (JFrame)SwingUtilities.windowForComponent(gameMenu);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        gameMenu.getCustomMenuItem().addActionListener(e -> MineSweeperService.newCustomGame());

        gameMenu.getQuitMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
