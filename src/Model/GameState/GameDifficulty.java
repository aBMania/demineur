package model.GameState;

import javax.swing.*;
import java.io.Serializable;

public class GameDifficulty implements Serializable {
    private String name;

    private Integer rows;
    private Integer cols;
    private Integer mines;

    private int mnemonicKey;
    private KeyStroke accelerator;

    public GameDifficulty() {
    }

    public GameDifficulty(String name, Integer rows, Integer cols, Integer mines, int mnemonicKey, KeyStroke accelerator) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.mnemonicKey = mnemonicKey;
        this.accelerator = accelerator;
    }

    public String getName() {
        return name;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public Integer getMines() {
        return mines;
    }

    public int getMnemonicKey() {
        return mnemonicKey;
    }

    public KeyStroke getAccelerator() {
        return accelerator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public void setMines(Integer mines) {
        this.mines = mines;
    }

    public void setMnemonicKey(int mnemonicKey) {
        this.mnemonicKey = mnemonicKey;
    }

    public void setAccelerator(KeyStroke accelerator) {
        this.accelerator = accelerator;
    }

    @Override
    public String toString() {
        return getName();
    }
}
