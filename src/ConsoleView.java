public class ConsoleView {

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
                        return gameCell.getNumberBombsNear().toString();
                    }
                }
                break;
            case FLAG_EXCLAMATIONMARK:
                return "?";
                break;
            case FLAG_QUESTIONMARK:
                return "!";
                break;
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }
    public void ConsoleView(GameState game_state) {
        sizeX = game_state.getSizeX();
        sizeY = game_state.getSizeY();

        for(int x = 0;x < sizeX; x++){
            for(int y = 0;y < sizeY;y++){

            }
        }

    }
}
