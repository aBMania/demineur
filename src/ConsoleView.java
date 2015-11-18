public class ConsoleView {

    public ConsoleView(GameState gameState) {
        Integer sizeX = gameState.getSizeX();
        Integer sizeY = gameState.getSizeY();

        for(int x = 0;x < sizeX; x++){
            for(int y = 0;y < sizeY;y++){
                System.out.print(getCellRepresentation(gameState.getXYCell(x, y)) + " ");
            }
            System.out.println();
        }

    }

    public String getCellRepresentation(GameCell gameCell) {

        if(gameCell.isHidden()){
            return "#";
        }

        switch (gameCell.getState()){
            case VISIBLE:
                if(gameCell.isMined()){
                    return "x";
                }
                else{
                    if(gameCell.getNumberBombsNear() == 0){
                        return ".";
                    }
                    else{
                        return ""+gameCell.getNumberBombsNear();
                    }
                }
            case FLAG_EXCLAMATIONMARK:
                return "?";
            case FLAG_QUESTIONMARK:
                return "!";
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }
}
