package View.Graphical.Menu;

import Model.GameState.GameState;
import Model.GameState.GameStateFactory;

import javax.swing.*;

public class CustomGameFrame extends JFrame {

    private final CustomGamePanelWrapper customGamePanelWrapper;

    public CustomGamePanelWrapper getCustomGamePanelWrapper() {
        return customGamePanelWrapper;
    }

    public CustomGameFrame() {
        super("Choose parameters");
        customGamePanelWrapper = new CustomGamePanelWrapper();
        setSize(100,100);
        add(customGamePanelWrapper);
        pack();
        setVisible(true);
    }

}
