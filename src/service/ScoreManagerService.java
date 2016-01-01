package service;

import model.GameState.GameConstants;
import model.GameState.GameDifficulty;
import model.Score.Score;
import model.Score.ScoreList;

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

            ScoreList previousScores = getScoreListFromFile(SCORES_PATH + "/" + difficulty + ".ser");

            if (previousScores != null)
                difficultyScoreList.addAll(previousScores);

            scoreLists.put(difficulty.getName(), difficultyScoreList);
        }
    }

    public static void addScore(Score score){
        String difficulty = score.getDifficulty().getName();

        ScoreList scoreList = scoreLists.get(difficulty);

        scoreList.add(score);

        rewriteScoreList(SCORES_PATH + "/" + difficulty + ".ser", scoreList);
    }

    public static Map<String, ScoreList> getScoreLists() {
        return scoreLists;
    }

    private static void rewriteScoreList(String path, ScoreList scoreList) {
        new File(path);

        FileOutputStream fout;
        ObjectOutputStream oos;

        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(scoreList);
            oos.close();
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
        ObjectInputStream objectInputStream = null;

        try
        {
            inputFileStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(inputFileStream);
            return (ScoreList) objectInputStream.readObject();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        finally {
            if(objectInputStream != null) {
                try {
                    objectInputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
