package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.logging.Level;

/**
 * Created by oliverthurn on 9/27/16.
 */
public class Level2Activity extends Activity implements View.OnClickListener {

    int answerPicked = 0;
    int randomNumber;
    int clickCounter = 0;
    public static int score;
    String highScoreString;
    private boolean end = false;



    TextView highScoreView;

    protected Button oneButton;
    protected Button twoButton;
    protected Button threeButton;
    protected Button fourButton;
    protected Button fiveButton;
    protected Button sixButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leveltwolayout);

        oneButton = (Button)findViewById(R.id.oneButtonLevelTwo);
        oneButton.setOnClickListener(this);
        twoButton = (Button)findViewById(R.id.twoButtonLevelTwo);
        twoButton.setOnClickListener(this);
        threeButton = (Button)findViewById(R.id.threeButtonLevelTwo);
        threeButton.setOnClickListener(this);
        fourButton = (Button)findViewById(R.id.fourButtonLevelTwo);
        fourButton.setOnClickListener(this);
        fiveButton = (Button)findViewById(R.id.fiveButtonLevelTwo);
        fiveButton.setOnClickListener(this);
        sixButton = (Button)findViewById(R.id.sixButtonLevelTwo);
        sixButton.setOnClickListener(this);

        highScoreView = (TextView)findViewById(R.id.highScoreViewLevelTwo);

        randomNumber = createRandom(6);
        Log.i("RandomNumber Level 2: ", "" + randomNumber);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.oneButtonLevelTwo:
                clickCounter++;
                answerPicked = 1;
                checkAnswer(randomNumber, end, oneButton);
                break;

            case R.id.twoButtonLevelTwo:
                clickCounter++;
                answerPicked = 2;
                checkAnswer(randomNumber, end, twoButton);
                break;

            case R.id.threeButtonLevelTwo:
                clickCounter++;
                answerPicked = 3;
                checkAnswer(randomNumber, end, threeButton);
                break;

            case R.id.fourButtonLevelTwo:
                clickCounter++;
                answerPicked = 4;
                checkAnswer(randomNumber, end, fourButton);
                break;

            case R.id.fiveButtonLevelTwo:
                clickCounter++;
                answerPicked = 5;
                checkAnswer(randomNumber, end, fiveButton);
                break;

            case R.id.sixButtonLevelTwo:
                clickCounter++;
                answerPicked = 6;
                checkAnswer(randomNumber, end, sixButton);
                break;

            default:
                break;

        }
    }

    public void popUpToNextLevel(boolean go){
        if(go){
            startActivity(new Intent(Level2Activity.this, popWindowLevel2.class));
        }
    }

    public void checkAnswer(int randomNum, boolean gameOver, Button button){

        if (answerPicked != randomNum){
            Toast.makeText(getApplicationContext(), "Wrong, try again", Toast.LENGTH_SHORT).show();
            Methods.changeButtonColorRed(button);
        } else {
            Methods.changeButtonGreen(button);
            score = Level1Activity.score + (7 - clickCounter);
            Log.i("HighScore 2", "" + score);

            highScoreString = "" + score;
            highScoreView.setText(highScoreString);
            gameOver = true;
        }
        Level1Activity.saveHighScore(highScoreString, score);
        popUpToNextLevel(gameOver);

    }

    public int createRandom(int size){
        Random rand = new Random();
        int random = rand.nextInt(size) + 1;
        return random;

    }



}
