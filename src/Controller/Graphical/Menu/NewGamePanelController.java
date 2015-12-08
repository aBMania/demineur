package Controller.Graphical.Menu;

import View.Graphical.Menu.NewGamePanel;
import service.MineSweeperService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NewGamePanelController {
    private NewGamePanel gamePanel;
    private int choice = CHOICE_UNDEFINED;
    public static final int CHOICE_UNDEFINED = 0;
    public static final int CHOICE_BEGINNER = 1;
    public static final int CHOICE_INTERMEDIATE = 2;
    public static final int CHOICE_EXPERT = 3;
    public static final int CHOICE_CUSTOM = 4;



    public NewGamePanelController(NewGamePanel gamePanel) {
        this.gamePanel = gamePanel;

        CustomGamePanelController customGamePanelController= new CustomGamePanelController(gamePanel.getCustomGamePanel());

        JRadioButtonMenuItem beginner = gamePanel.getBeginnerRadioButton();
        JRadioButtonMenuItem intermediate = gamePanel.getIntermediateRadioButton();
        JRadioButtonMenuItem expert = gamePanel.getExpertRadioButton();
        JRadioButtonMenuItem custom = gamePanel.getCustomRadioButton();
        JButton start = gamePanel.getStart();

        beginner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice = CHOICE_BEGINNER;
            }
        });
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice = CHOICE_INTERMEDIATE;
            }
        });
        expert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice = CHOICE_EXPERT;
            }
        });
        custom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice = CHOICE_CUSTOM;
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (choice){
                    case CHOICE_UNDEFINED:
                        return;
                    case CHOICE_BEGINNER:
                        MineSweeperService.newBeginnerGame();
                        break;
                    case CHOICE_INTERMEDIATE:
                        MineSweeperService.newIntermediateGame();
                        break;
                    case  CHOICE_EXPERT:
                        MineSweeperService.newExpertGame();
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
