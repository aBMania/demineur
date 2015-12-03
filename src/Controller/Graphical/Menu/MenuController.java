package Controller.Graphical.Menu;

import View.Graphical.Menu.GameMenu;
import service.MineSweeperService;

public class MenuController {
    private final GameMenu gameMenu;

    public MenuController(GameMenu gameMenu) {
        this.gameMenu = gameMenu;

        gameMenu.getBeginnerMenuItem().addActionListener(e -> MineSweeperService.newBeginnerGame());
        gameMenu.getIntermediateMenuItem().addActionListener(e -> MineSweeperService.newIntermediateGame());
        gameMenu.getExpertMenuItem().addActionListener(e -> MineSweeperService.newExpertGame());
        //gameMenu.getCustomMenuItem().addActionListener(e -> MineSweeperService.newCustomGame());

    }
}
