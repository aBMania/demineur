package Model.GameState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameConstants {

    public static final List<GameDifficulty> GAME_DIFFICULTIES = new ArrayList<>();

    static {
        GAME_DIFFICULTIES.add(new GameDifficulty("Beginner", 9, 9, 10, KeyEvent.VK_B, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)));
        GAME_DIFFICULTIES.add(new GameDifficulty("Intermediate", 16, 16, 40, KeyEvent.VK_I, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK)));
        GAME_DIFFICULTIES.add(new GameDifficulty("Expert", 16, 30, 99, KeyEvent.VK_E, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)));
    }

    public static final int CUSTOM_DEFAULT_ROW = 9;
    public static final int CUSTOM_MIN_ROW = 9;
    public static final int CUSTOM_MAX_ROW = 24;

    public static final int CUSTOM_DEFAULT_COLS = 19;
    public static final int CUSTOM_MIN_COLS = 9;
    public static final int CUSTOM_MAX_COLS = 30;

    public static final int CUSTOM_DEFAULT_MINES = 76;
    public static final int CUSTOM_MIN_MINES = 9;

    public static int getCustomMaxMines(int x, int y) {
        return (int) Math.floor(0.85*x*y);
    }

}
