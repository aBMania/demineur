package service;

import model.GameState.GameConstants;
import model.GameState.GameDifficulty;
import model.Score.Score;
import model.Score.ScoreList;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class ScoreManagerService implements Serializable {
    private static Map<String, ScoreList> scoreLists;
    public static final String SCORES_PATH = "scores";

    static{
        new File(SCORES_PATH).mkdir(); // make score dir

        scoreLists = new HashMap<>();

        for(GameDifficulty difficulty : GameConstants.GAME_DIFFICULTIES) {
            ScoreList difficultyScoreList = new ScoreList(difficulty);

            ScoreList previousScores = getScoreListFromFile(SCORES_PATH + "/" + difficulty + ".xml");

            if (previousScores != null)
                difficultyScoreList.addAll(previousScores);

            scoreLists.put(difficulty.getName(), difficultyScoreList);
        }
    }

    public static void addScore(Score score){
        String difficulty = score.getDifficulty().getName();

        ScoreList scoreList = scoreLists.get(difficulty);

        scoreList.add(score);

        rewriteScoreList(SCORES_PATH + "/" + difficulty + ".xml", scoreList);
    }

    public static Map<String, ScoreList> getScoreLists() {
        return scoreLists;
    }

    private static void rewriteScoreList(String path, ScoreList scoreList) {

        new File(path);

        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));

            encoder.writeObject(scoreList);
            encoder.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static ScoreList getScoreListFromFile(String path) {
        File f = new File(path);

        if(!f.exists())
            return null;

        FileInputStream inputFileStream = null;
        BufferedInputStream bufferedInputStream = null;
        XMLDecoder decoder = null;

        try
        {
            inputFileStream = new FileInputStream(path);
            bufferedInputStream = new BufferedInputStream(inputFileStream);
            decoder = new XMLDecoder(new BufferedInputStream(bufferedInputStream));

            return (ScoreList) decoder.readObject();

        } catch(IOException i)
        {
            i.printStackTrace();
        }
        finally {
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
}
