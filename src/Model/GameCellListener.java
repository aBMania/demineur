package Model;

public interface GameCellListener {
    void markCellWithQuestionMark(GameCellEvent e);

    void markCellWithExclamationMark(GameCellEvent e);

    void discoverCell(GameCellEvent e);
}
