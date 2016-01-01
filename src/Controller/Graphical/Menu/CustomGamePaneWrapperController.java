package controller.Graphical.Menu;

import view.Graphical.Menu.CustomGamePanelWrapper;
import service.MineSweeperService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomGamePaneWrapperController {
    public CustomGamePaneWrapperController(CustomGamePanelWrapper customGamePanelWrapper) {
        CustomGamePanelController customGamePanelController = new CustomGamePanelController(customGamePanelWrapper.getCustomGamePanel());

        customGamePanelWrapper.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MineSweeperService.newCustomGame(customGamePanelController.getRowsController().getValue(),customGamePanelController.getColumnController().getValue(),customGamePanelController.getMinesController().getValue());
            }
        });
    }
}
