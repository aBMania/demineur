package Controller.Graphical.Menu;

import View.Graphical.Menu.NewGamePanel;

public class NewGamePanelController {
    private NewGamePanel gamePanel;

    public NewGamePanelController(NewGamePanel gamePanel) {
        this.gamePanel = gamePanel;

        new CustomGamePanelController(gamePanel.getCustomGamePanel());
    }

}
