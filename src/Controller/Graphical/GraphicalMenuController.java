package Controller.Graphical;

import View.Graphical.GameMenu.GameMenu;
import service.MineSweeperService;

public class GraphicalMenuController {
    private final GameMenu gameMenu;

    public GraphicalMenuController(GameMenu gameMenu) {
        this.gameMenu = gameMenu;

        gameMenu.getBeginnerMenuItem().addActionListener(e -> MineSweeperService.newBeginnerGame());
        gameMenu.getIntermediateMenuItem().addActionListener(e -> MineSweeperService.newIntermediateGame());
        gameMenu.getExpertMenuItem().addActionListener(e -> MineSweeperService.newExpertGame());
        gameMenu.getCustomMenuItem().addActionListener(e -> MineSweeperService.newCustomGame());

    }
}
