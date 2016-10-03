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
public class LevelTwo extends Activity implements View.OnClickListener {

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
                checkAnswer(randomNumber, end);
                break;

            case R.id.twoButtonLevelTwo:
                clickCounter++;
                answerPicked = 2;
                checkAnswer(randomNumber, end);
                break;

            case R.id.threeButtonLevelTwo:
                clickCounter++;
                answerPicked = 3;
                checkAnswer(randomNumber, end);
                break;

            case R.id.fourButtonLevelTwo:
                clickCounter++;
                answerPicked = 4;
                checkAnswer(randomNumber, end);
                break;

            case R.id.fiveButtonLevelTwo:
                clickCounter++;
                answerPicked = 5;
                checkAnswer(randomNumber, end);
                break;

            case R.id.sixButtonLevelTwo:
                clickCounter++;
                answerPicked = 6;
                checkAnswer(randomNumber, end);
                break;

            default:
                break;

        }
    }

    public void popUpToNextLevel(boolean go){
        if(go){
            startActivity(new Intent(LevelTwo.this, popWindowLevelTwo.class));
        }
    }

    public void checkAnswer(int randomNum, boolean gameOver){

        if (answerPicked != randomNum){
            Toast.makeText(getApplicationContext(), "Wrong, try again", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(getApplicationContext(), "YEWWWW", Toast.LENGTH_LONG).show();
            score = 7 - clickCounter;
            highScoreView.setText("HighScore: " +((HighScore) this.getApplication()).getScore());
            gameOver = true;
        }
        ((HighScore) this.getApplication()).addToScore(score);
        popUpToNextLevel(gameOver);

    }

    public int createRandom(int size){
        Random rand = new Random();
        int random = rand.nextInt(size) + 1;
        return random;

    }
}
