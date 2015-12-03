package Controller.Graphical.Menu;

import View.Graphical.Menu.CustomGamePanel;
import View.Graphical.Menu.CustomGameParameterRow;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomGamePanelController implements DocumentListener{
    private final CustomGameParameterRow rows;
    private final CustomGameParameterRow column;
    private final CustomGameParameterRow mines;

    public CustomGamePanelController(CustomGamePanel customGamePanel) {

        rows = customGamePanel.getRowsPanel();
        new CustomGameParameterRowController(rows);

        column = customGamePanel.getColumnPanel();
        new CustomGameParameterRowController(column);

        mines = customGamePanel.getMinesPanel();
        new CustomGameParameterRowController(mines);

        //rows.add
        //column.getDocument().addDocumentListener(this);
    }

    public void updateMinesMaxValue(){

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateMinesMaxValue();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateMinesMaxValue();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateMinesMaxValue();
    }
}
