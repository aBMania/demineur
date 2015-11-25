package View.Graphical;

import Model.GameCell.GameCell;

import javax.swing.*;
import java.awt.*;

public class GraphicalCellView extends JButton{
    private GameCell cell;
    private boolean debug = true;

    public GraphicalCellView(GameCell cell) {

        this.cell = cell;
        setView();

    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);
        System.out.print(".");
        setView();
    }

    private void setView(){
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

        if(this.cell.isHidden()){
            if(this.debug && this.cell.isMined()){
                this.setText("M");
                System.out.println(" x: "+cell.getX()+" y: "+cell.getY());
            }
        }

      //  throw new RuntimeException("Cannot find symbol for this cell");
    }
}
