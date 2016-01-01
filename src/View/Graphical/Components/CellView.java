package view.Graphical.Components;

import model.GameCell.GameCell;
import view.GameView;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CellView extends JButton{
    private GridView gridView;
    private GameCell cell;
    private ImageIcon flag;
    private ImageIcon interrogationMark;

    public GameCell getCell() {
        return cell;
    }

    public CellView(GridView gridView, GameCell cell, Dimension d) {
        this.gridView = gridView;

        int h = (int)d.getHeight();
        int w = (int)d.getWidth();

        URL flagURL = getClass().getClassLoader().getResource("ressources/images/drap.png");
        URL interrogationMarkURL = getClass().getClassLoader().getResource("ressources/images/interro.gif");

        if(flagURL == null || interrogationMarkURL == null){
            throw new RuntimeException("Can't find images");
        }

        ImageIcon flagTemp;
        ImageIcon interrogationMarkTemp;

        flagTemp = new ImageIcon(flagURL);
        interrogationMarkTemp = new ImageIcon(interrogationMarkURL);

        flag = new ImageIcon(flagTemp.getImage().getScaledInstance(h,w,Image.SCALE_DEFAULT));
        interrogationMark = new ImageIcon(interrogationMarkTemp.getImage().getScaledInstance(h,w,Image.SCALE_DEFAULT));

        this.cell = cell;

        setPreferredSize(d);

        refresh();
    }

    public void refresh(){
        if(getGameView().getGameState().isFinished() && cell.isMined()) {
            setText("X");
            setIcon(null);

            if(cell.isVisible())
                setEnabled(false);

            return;
        }
        switch (cell.getState()){
            case VISIBLE:
                setEnabled(false);
                setIcon(null);
                if(cell.isMined()) {
                    setText("X");
                    break;
                }
                if(cell.getNumberBombsNear() != 0){
                    setText(Integer.toString(cell.getNumberBombsNear()));
                    setEnabled(false);
                    switch (cell.getNumberBombsNear()){
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
                setIcon(flag);
                break;
            case FLAG_QUESTIONMARK:
                this.setIcon(interrogationMark);
                break;
            case HIDDEN:
                setText(null);
                setIcon(null);
        }

      //  throw new RuntimeException("Cannot find symbol for this cell");
    }

    public GridView getGridView() {
        return gridView;
    }

    public GameView getGameView() {
        return getGridView().getGameView();
    }

    public void fireMarkCellWithQuestionMark(){
        getGameView().fireMarkCellWithQuestionMark(cell);
    }

    public void fireMarkCellWithExclamationMark(){
        getGameView().fireMarkCellWithExclamationMark(cell);
    }

    public void fireDiscoverCell(){
        getGameView().fireDiscoverCell(cell);
    }

    public void fireClearCellMark(){
        getGameView().fireClearCellMark(cell);
    }

}
