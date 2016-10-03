package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by oliverthurn on 9/27/16.
 */
public class LevelThree extends Activity implements View.OnClickListener {

    int answerPicked = 0;
    int randomNumber;
    int clickCounter = 0;
    int score;
    private boolean end = false;

    TextView highScoreView;

    protected Button oneButton;
    protected Button twoButton;
    protected Button threeButton;
    protected Button fourButton;
    protected Button fiveButton;
    protected Button sixButton;
    protected Button sevenButton;
    protected Button eightButton;
    protected Button nineButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelthreelayout);

        oneButton = (Button)findViewById(R.id.oneButtonLevelThree);
        oneButton.setOnClickListener(this);
        twoButton = (Button)findViewById(R.id.twoButtonLevelThree);
        twoButton.setOnClickListener(this);
        threeButton = (Button)findViewById(R.id.threeButtonLevelThree);
        threeButton.setOnClickListener(this);
        fourButton = (Button)findViewById(R.id.fourButtonLevelThree);
        fourButton.setOnClickListener(this);
        fiveButton = (Button)findViewById(R.id.fiveButtonLevelThree);
        fiveButton.setOnClickListener(this);
        sixButton = (Button)findViewById(R.id.sixButtonLevelThree);
        sixButton.setOnClickListener(this);
        sevenButton = (Button)findViewById(R.id.sevenButtonLevelThree);
        sevenButton.setOnClickListener(this);
        eightButton = (Button)findViewById(R.id.eightButtonLevelThree);
        eightButton.setOnClickListener(this);
        nineButton = (Button)findViewById(R.id.nineButtonLevelThree);
        nineButton.setOnClickListener(this);

        highScoreView = (TextView)findViewById(R.id.highScoreViewLevelThree);

        randomNumber = createRandom(9);
        Log.i("Random Level 3: ", "" + randomNumber);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.oneButtonLevelThree:
                answerPicked = 1;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.twoButtonLevelThree:
                answerPicked = 2;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.threeButtonLevelThree:
                answerPicked = 3;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.fourButtonLevelThree:
                answerPicked = 4;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.fiveButtonLevelThree:
                answerPicked = 5;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.sixButtonLevelThree:
                answerPicked = 6;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;

            case R.id.sevenButtonLevelThree:
                answerPicked = 7;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.eightButtonLevelThree:
                answerPicked = 8;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
            case R.id.nineButtonLevelThree:
                answerPicked = 9;
                clickCounter++;
                checkAnswer(randomNumber, end);
                break;
        }
    }

    public void popUpToNextLevel(boolean go){
        if(go){
            startActivity(new Intent(LevelThree.this, popWidowLevelThree.class));
        }
    }

    public void checkAnswer(int randomNum, boolean gameOver){

        if (answerPicked != randomNum){
            Toast.makeText(getApplicationContext(), "Wrong, try again", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(getApplicationContext(), "YEWWWW", Toast.LENGTH_LONG).show();
            score = 10 - clickCounter;
            highScoreView.setText("HighScore: " + ((HighScore) this.getApplication()).getScore());
            gameOver = true;
        }
        ((HighScore) this.getApplication()).addToScore(score);
        Log.i("GameHighScore: ", "" + ((HighScore) this.getApplication()).getScore());
        popUpToNextLevel(gameOver);

    }

    public int createRandom(int size){
        Random rand = new Random();
        int randomNum = rand.nextInt(size) + 1;
        return randomNum;
    }

}
