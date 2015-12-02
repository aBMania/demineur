package Controller.Graphical;

import View.Graphical.GameMenu.GameMenu;

public class GraphicalMenuController {
    private final GraphicalGameController gameController;
    private final GameMenu gameMenu;

    public GraphicalMenuController(GraphicalGameController graphicalGameController) {
        this.gameController = graphicalGameController;
        this.gameMenu = graphicalGameController.getView().getMenu();

        gameMenu.getBeginnerMenuItem().addActionListener(e -> System.out.print("beginner"));
        gameMenu.getIntermediateMenuItem().addActionListener(e -> System.out.print("intermediate"));
        gameMenu.getExpertMenuItem().addActionListener(e -> System.out.print("expert"));
        gameMenu.getCustomMenuItem().addActionListener(e -> System.out.print("custom"));
    }
}
