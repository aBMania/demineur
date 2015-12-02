package Controller.Graphical;

import View.Graphical.GameMenu.CustomGameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class GraphicalMenuCustomController implements ActionListener{
    CustomGameFrame menu;

    public GraphicalMenuCustomController(CustomGameFrame menu) {
        this.menu = menu;
        menu.getCustomGamePanel().getColumnPanel().addComponentListener(this);
        menu.getCustomGamePanel().getMinesPanel().addComponentListener(this);
        menu.getCustomGamePanel().getRowsPanel().addComponentListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
