package Model.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreList implements Serializable {
    private List<Score> scoreList = new ArrayList<>();
    public static final String PATH = "scores.ser";

    private ScoreList(){

        File f = new File(PATH);
        if(!f.exists())
            return;

        try
        {
            FileInputStream inputFileStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputFileStream);
            scoreList = (List<Score>) objectInputStream.readObject();
            objectInputStream.close();
            inputFileStream.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    private static ScoreList INSTANCE = null;

    public static ScoreList getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ScoreList();

        return INSTANCE;
    }

    public void addScore(Score score){
        scoreList.add(score);
        rewrite();
    }

    private void rewrite() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream(PATH);
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

    public List<Score> getScoreList() {
        return scoreList;
    }
}
