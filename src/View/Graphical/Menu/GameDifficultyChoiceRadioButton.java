package view.Graphical.Menu;

import model.GameState.GameDifficulty;

import javax.swing.*;

public class GameDifficultyChoiceRadioButton extends JRadioButton {

    private GameDifficulty gameDifficulty;

    public GameDifficultyChoiceRadioButton(GameDifficulty gameDifficulty) {
        super(gameDifficulty.getName() + ": " + gameDifficulty.getMines() + " mines in a " + gameDifficulty.getRows() + "x " + gameDifficulty.getCols() + " field");
        this.gameDifficulty = gameDifficulty;
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }
}
