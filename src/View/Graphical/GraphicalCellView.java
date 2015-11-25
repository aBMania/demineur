package View.Graphical;

import Model.GameCell.GameCell;

import javax.swing.*;

public class GraphicalCellView extends JButton{
    private GameCell cell;
    private boolean debug = false;

    public GraphicalCellView(GameCell cell) {

        this.cell = cell;

    }
    private void setView(){
        switch (this.cell.getState()){
            case VISIBLE:
                if(this.cell.isMined()){
                }
                else{
                    if(this.cell.getNumberBombsNear() == 0){
                    }
                    else{
                    }
                }
            case FLAG_EXCLAMATIONMARK:
            case FLAG_QUESTIONMARK:
        }

        if(this.cell.isHidden()){
            if(this.debug && this.cell.isMined()){

            }
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }
}
