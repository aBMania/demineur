package View.Graphical.GameComponents;

import Model.GameCell.GameCell;

import javax.swing.*;
import java.awt.*;

public class CellView extends JButton{
    private GameCell cell;

    public CellView(GameCell cell, Dimension d) {
        this.cell = cell;

        setPreferredSize(d);

        refresh();
    }

    public void refresh(){
        switch (this.cell.getState()){
            case VISIBLE:
                this.setEnabled(false);
                if(this.cell.isMined()){
                    this.setText("BOOM!");
                }
                else if(this.cell.getNumberBombsNear() != 0){
                    this.setText(Integer.toString(cell.getNumberBombsNear()));
                }
                break;
            case FLAG_EXCLAMATIONMARK:
                this.setText("!");
                break;
            case FLAG_QUESTIONMARK:
                this.setText("?");
                break;
            case HIDDEN:
                this.setText(null);
        }

      //  throw new RuntimeException("Cannot find symbol for this cell");
    }
}
