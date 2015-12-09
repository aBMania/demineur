package Controller.Graphical.Menu;

import Model.GameState.GameDifficulty;
import View.Graphical.Menu.NewGamePanel;
import service.MineSweeperService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NewGamePanelController {
    private NewGamePanel gamePanel;
    private int choice = CHOICE_UNDEFINED;
    private GameDifficulty predefinedDifficulty;
    public static final int CHOICE_UNDEFINED = 0;
    public static final int CHOICE_PREDEFINED_DIFFICULTY = 1;
    public static final int CHOICE_CUSTOM = 2;



    public NewGamePanelController(NewGamePanel gamePanel) {
        this.gamePanel = gamePanel;

        CustomGamePanelController customGamePanelController = new CustomGamePanelController(gamePanel.getCustomGamePanel());

        for(GameDifficultyChoiceRadioButton radioButton : gamePanel.getGameDifficultyChoiceRadioButtonList()) {
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choice = CHOICE_PREDEFINED_DIFFICULTY;
                    predefinedDifficulty = radioButton.getGameDifficulty();
                }
            });
        }

        gamePanel.getCustomRadioButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice = CHOICE_CUSTOM;
            }
        });

        gamePanel.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (choice){
                    case CHOICE_UNDEFINED:
                        return;
                    case CHOICE_PREDEFINED_DIFFICULTY:
                        MineSweeperService.newGame(predefinedDifficulty);
                        break;
                    case CHOICE_CUSTOM:
                        MineSweeperService.newCustomGame(customGamePanelController.getRowsController().getValue(),customGamePanelController.getColumnController().getValue(),customGamePanelController.getMinesController().getValue());
                }
                JFrame frame = (JFrame)SwingUtilities.windowForComponent(gamePanel);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
