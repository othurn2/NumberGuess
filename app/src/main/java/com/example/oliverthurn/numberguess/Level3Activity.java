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
public class Level3Activity extends Activity implements View.OnClickListener {

    int answerPicked = 0;
    int randomNumber;
    int clickCounter = 0;
    int score;
    String highScoreString;
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
                checkAnswer(randomNumber, end, oneButton);
                break;
            case R.id.twoButtonLevelThree:
                answerPicked = 2;
                clickCounter++;
                checkAnswer(randomNumber, end, twoButton);
                break;
            case R.id.threeButtonLevelThree:
                answerPicked = 3;
                clickCounter++;
                checkAnswer(randomNumber, end, threeButton);
                break;
            case R.id.fourButtonLevelThree:
                answerPicked = 4;
                clickCounter++;
                checkAnswer(randomNumber, end, fourButton);
                break;
            case R.id.fiveButtonLevelThree:
                answerPicked = 5;
                clickCounter++;
                checkAnswer(randomNumber, end, fiveButton);
                break;
            case R.id.sixButtonLevelThree:
                answerPicked = 6;
                clickCounter++;
                checkAnswer(randomNumber, end, sixButton);
                break;

            case R.id.sevenButtonLevelThree:
                answerPicked = 7;
                clickCounter++;
                checkAnswer(randomNumber, end, sevenButton);
                break;
            case R.id.eightButtonLevelThree:
                answerPicked = 8;
                clickCounter++;
                checkAnswer(randomNumber, end, eightButton);
                break;
            case R.id.nineButtonLevelThree:
                answerPicked = 9;
                clickCounter++;
                checkAnswer(randomNumber, end, nineButton);
                break;
        }
    }

    public void popUpToNextLevel(boolean go){
        if(go){
            startActivity(new Intent(Level3Activity.this, popWindowLevel3.class));
        }
    }

    public void checkAnswer(int randomNum, boolean gameOver, Button button){

        if (answerPicked != randomNum){
            Toast.makeText(getApplicationContext(), "Wrong, try again", Toast.LENGTH_SHORT).show();
            Methods.changeButtonColorRed(button);
        } else {
            Methods.changeButtonGreen(button);
            score = Level2Activity.score + (10 - clickCounter);
            Log.i("HighScore 3", "" + score);
            highScoreString = "" + score;
            highScoreView.setText(highScoreString);
            gameOver = true;
        }
        Level1Activity.saveHighScore(highScoreString,score);
        popUpToNextLevel(gameOver);

    }

    public int createRandom(int size){
        Random rand = new Random();
        int randomNum = rand.nextInt(size) + 1;
        return randomNum;
    }


}
