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
            case FLAG_EXCLAMATIONMARK:
                return "?";
            case FLAG_QUESTIONMARK:
                return "!";
        }

        throw new RuntimeException("Cannot find symbol for this cell");
    }
    public void ConsoleView(GameState game_state) {

    }
}
