package model.GameCell;

public interface GameCellListener {
    void markCellWithQuestionMark(GameCellEvent e);

    void markCellWithExclamationMark(GameCellEvent e);

    void discoverCell(GameCellEvent e);

    void clearCellMark(GameCellEvent e);
}
