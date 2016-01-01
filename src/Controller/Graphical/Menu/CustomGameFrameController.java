package controller.Graphical.Menu;

import view.Graphical.Menu.CustomGameFrame;

public class CustomGameFrameController {
    public CustomGameFrameController(CustomGameFrame customGameFrame) {
        new CustomGamePaneWrapperController(customGameFrame.getCustomGamePanelWrapper());
    }
}
