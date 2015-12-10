package Controller.Graphical.Menu;

import View.Graphical.Menu.CustomGameFrame;

public class CustomGameFrameController {
    public CustomGameFrameController(CustomGameFrame customGameFrame) {
        new CustomGamePaneWrapperController(customGameFrame.getCustomGamePanelWrapper());
    }
}
