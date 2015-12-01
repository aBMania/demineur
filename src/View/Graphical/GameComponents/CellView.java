package View.Graphical.GameComponents;

import Model.GameCell.GameCell;

import javax.swing.*;
import java.awt.*;

public class CellView extends JButton{
    private GameCell cell;
    private ImageIcon flag;
    private ImageIcon interrogationMark;

    public CellView(GameCell cell, Dimension d) {

        ImageIcon flagTemp = new ImageIcon(getClass().getClassLoader().getResource("ressources/images/drap.png"));
        ImageIcon interrogationMarkTemp = new ImageIcon(getClass().getClassLoader().getResource("ressources/images/Interro.gif"));
        int h = (int)d.getHeight();
        int w = (int)d.getWidth();
        flag = new ImageIcon(flagTemp.getImage().getScaledInstance(h,w,Image.SCALE_DEFAULT));
        interrogationMark = new ImageIcon(interrogationMarkTemp.getImage().getScaledInstance(h,w,Image.SCALE_DEFAULT));

        this.cell = cell;

        setPreferredSize(d);

        refresh();
    }
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
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
                    this.setEnabled(true);
                    switch (this.cell.getNumberBombsNear()){
                        case 1:
                            setForeground(Color.red);
                            break;
                        case 2:
                            setForeground(Color.BLUE);
                            break;
                        case 3:
                            setForeground(Color.CYAN);
                            break;
                        case 4:
                            setForeground(Color.GRAY);
                            break;
                        case 5:
                            setForeground(Color.YELLOW);
                            break;
                        case 6:

                    }
                }
                break;
            case FLAG_EXCLAMATIONMARK:
                this.setIcon(flag);
                break;
            case FLAG_QUESTIONMARK:
                this.setIcon(interrogationMark);
                break;
            case HIDDEN:
                this.setText(null);
        }

      //  throw new RuntimeException("Cannot find symbol for this cell");
    }
}
