package View.Graphical.Menu;

import Controller.Graphical.Menu.GameDifficultyChoiceRadioButton;
import Model.GameState.GameConstants;
import Model.GameState.GameDifficulty;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NewGamePanel extends JPanel {

    private CustomGamePanel customGamePanel;
    private JRadioButtonMenuItem customRadioButton;
    private List<GameDifficultyChoiceRadioButton> gameDifficultyChoiceRadioButtonList = new ArrayList<>();
    private JButton start;

    public CustomGamePanel getCustomGamePanel() {
        return customGamePanel;
    }

    public NewGamePanel() {
        ButtonGroup buttonGroup = new ButtonGroup();

        for(GameDifficulty gameDifficulty : GameConstants.GAME_DIFFICULTIES){
            GameDifficultyChoiceRadioButton radioButton = new GameDifficultyChoiceRadioButton(gameDifficulty);
            gameDifficultyChoiceRadioButtonList.add(radioButton);
            buttonGroup.add(radioButton);
            add(radioButton);
        }

        customRadioButton = new JRadioButtonMenuItem("Custom:");
        buttonGroup.add(customRadioButton);
        add(customRadioButton);

        customGamePanel = new CustomGamePanel();
        add(customGamePanel);

        start = new JButton("start");
        add(start);

    }

    public List<GameDifficultyChoiceRadioButton> getGameDifficultyChoiceRadioButtonList() {
        return gameDifficultyChoiceRadioButtonList;
    }

    public JRadioButtonMenuItem getCustomRadioButton() {
        return customRadioButton;
    }

    public JButton getStart() {
        return start;
    }
}
