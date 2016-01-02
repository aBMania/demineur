package service;

import model.GameState.GameConstants;
import model.GameState.GameDifficulty;
import model.Score.Score;
import model.Score.ScoreList;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ScoreManagerService implements Serializable {
    private static Map<String, ScoreList> scoreLists;
    public static final String SCORES_PATH = "scores/";

    static{
        new File(SCORES_PATH).mkdir(); // make score dir

        scoreLists = new HashMap<>();

        for(GameDifficulty difficulty : GameConstants.GAME_DIFFICULTIES) {
            ScoreList difficultyScoreList = new ScoreList(difficulty);

            ScoreList previousScores = getScoreListFromDifficultyFile(difficulty);

            if (previousScores != null)
                difficultyScoreList.addAll(previousScores);

            scoreLists.put(difficulty.getName(), difficultyScoreList);
        }
    }

    public static void addScore(Score score){
        String difficulty = score.getDifficulty().getName();

        ScoreList scoreList = scoreLists.get(difficulty);

        scoreList.add(score);

        rewriteScoreList(scoreList);
    }

    public static Map<String, ScoreList> getScoreLists() {
        return scoreLists;
    }

    private static void rewriteScoreList(ScoreList scoreList) {

        String path = getDifficultyPath(scoreList.getDifficulty());

        new File(path);

        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));

            encoder.writeObject(scoreList);
            encoder.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ScoreList getScoreListFromDifficultyFile(GameDifficulty difficulty) {

        String path = getDifficultyPath(difficulty);

        File f = new File(path);

        if(!f.exists())
            return null;

        FileInputStream inputFileStream = null;
        XMLDecoder decoder = null;

        try
        {

            inputFileStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputFileStream);
            decoder = new XMLDecoder(new BufferedInputStream(bufferedInputStream));

            return (ScoreList) decoder.readObject();

        } catch(IOException i)
        {
            i.printStackTrace();
        }
        finally {

            if(decoder != null)
                decoder.close();

            if(inputFileStream != null) {
                try {
                    inputFileStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    private static String getDifficultyPath(GameDifficulty difficulty){
        return SCORES_PATH + difficulty.getName() + ".xml";
    }
}
