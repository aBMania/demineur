package Model.GameState;

public class GameConstants {
    public static final int BEGINNER_ROW = 9;
    public static final int BEGINNER_COLS = 9;
    public static final int BEGINNER_MINES = 10;
    
    public static final int INTERMEDIATE_ROW = 16;
    public static final int INTERMEDIATE_COLS = 16;
    public static final int INTERMEDIATE_MINES = 40;
    
    public static final int EXPERT_ROW = 16;
    public static final int EXPERT_COLS = 30;
    public static final int EXPERT_MINES = 99;

    public static final int CUSTOM_DEFAULT_ROW = 9;
    public static final int CUSTOM_MIN_ROW = 9;
    public static final int CUSTOM_MAX_ROW = 24;

    public static final int CUSTOM_DEFAULT_COLS = 9;
    public static final int CUSTOM_MIN_COLS = 9;
    public static final int CUSTOM_MAX_COLS = 30;

    public static final int CUSTOM_DEFAULT_MINES = 76;
    public static final int CUSTOM_MIN_MINES = 9;

    public static int getCustomMaxMines(int x, int y) {
        return (int) Math.floor(0.85*x*y);
    }

}
