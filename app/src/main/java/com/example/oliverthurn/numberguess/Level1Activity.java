package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


/**
 * Created by oliverthurn on 9/23/16.
 */
public class Level1Activity extends Activity implements View.OnClickListener{

    private boolean end = false;
    public static int score;
    protected int clickCounter;
    protected int answerPicked = 0;
    int randomNum;
    String scoreAsString = "";

    protected Button oneButtonLevelOne;
    protected Button twoButtonLevelOne;
    protected Button threeButtonLevelOne;
    protected TextView textViewLevelOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.levelonelayout);

        oneButtonLevelOne = (Button)findViewById(R.id.oneButtonLevelOne);
        oneButtonLevelOne.setOnClickListener(this);
        twoButtonLevelOne = (Button)findViewById(R.id.twoButtonLevelOne);
        twoButtonLevelOne.setOnClickListener(this);
        threeButtonLevelOne = (Button)findViewById(R.id.threeButtonLevelOne);
        threeButtonLevelOne.setOnClickListener(this);
        textViewLevelOne = (TextView)findViewById(R.id.highScoreViewLevelone);

        randomNum = createRandom(3);
        Log.i("RandomNumber: ", "" + randomNum);
        //runLevelOne(gameNotOver, score);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.oneButtonLevelOne:
                clickCounter++;
                answerPicked = 1;
                checkAnswer(randomNum, end,oneButtonLevelOne);
                break;
            case R.id.twoButtonLevelOne:
                answerPicked = 2;
                clickCounter++;
                checkAnswer(randomNum, end, twoButtonLevelOne);
                break;
            case R.id.threeButtonLevelOne:
                answerPicked = 3;
                clickCounter++;
                checkAnswer(randomNum, end, threeButtonLevelOne);
                break;
            default:
                break;
        }

    }

    public void popUpToNextLevel(boolean go){
        if(go){
            startActivity(new Intent(Level1Activity.this, popWindowLevel1.class));
        }
    }

    public void checkAnswer(int randomNum, boolean gameOver, Button button){

            if (answerPicked != randomNum){
                Toast.makeText(getApplicationContext(), "Wrong, try again", Toast.LENGTH_SHORT).show();
                Methods.changeButtonColorRed(button);
            } else {
                Methods.changeButtonGreen(button);
                score = 4 - clickCounter;
                Log.i("HighScore 3", "" + score);
                scoreAsString = "" + score;
                textViewLevelOne.setText(scoreAsString);
                gameOver = true;
            }
        saveHighScore(scoreAsString, score);
        popUpToNextLevel(gameOver);

    }

    public int createRandom(int size){
        Random rand = new Random();
        int randomNum = rand.nextInt(size) + 1;
        return randomNum;
    }

    public static void saveHighScore(String score, int check){

        String checker = MainActivity.preferences.getString(MainActivity.dataName, MainActivity.savedHighScore);
        int c = Integer.parseInt(checker);

        if (check > c) {
            MainActivity.editor.putString(MainActivity.dataName, score);
            MainActivity.editor.commit();
        } else {
            Log.i("saveScoreMethod: ", "Score was less");
        }
    }


}
