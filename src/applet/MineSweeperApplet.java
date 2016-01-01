package applet;

import service.MineSweeperService;

import java.applet.Applet;

public class MineSweeperApplet extends Applet{
    @Override
    public void start() {
        MineSweeperService.newCustomGame();
    }
}
