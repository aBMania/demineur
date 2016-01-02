package view.Graphical.Menu;

import model.GameState.GameDifficulty;

import javax.swing.*;

public class GameDifficultyMenuItem extends JMenuItem {
    private GameDifficulty gameDifficulty;

    public GameDifficultyMenuItem(GameDifficulty gameDifficulty) {
        super(gameDifficulty.getName());
        this.gameDifficulty = gameDifficulty;
        setMnemonic(gameDifficulty.getMnemonicKey());
        setAccelerator(gameDifficulty.getAccelerator());
    }

    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

}
