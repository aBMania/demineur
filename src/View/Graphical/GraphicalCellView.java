package View.Graphical;

import Model.GameCell.GameCell;

import javax.swing.*;
import java.awt.*;

public class GraphicalCellView extends JButton{
    private GameCell cell;

    public GraphicalCellView(GameCell cell, Dimension d) {
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
                if(this.cell.getNumberBombsNear() != 0){
                    this.setText(Integer.toString(cell.getNumberBombsNear()));
                }
            case FLAG_EXCLAMATIONMARK:
                this.setText("!");
            case FLAG_QUESTIONMARK:
                this.setText("?");
        }

      //  throw new RuntimeException("Cannot find symbol for this cell");
    }
}
