package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by oliverthurn on 9/23/16.
 */
public class levelOne extends Activity implements View.OnClickListener {

    public boolean gameNotOver = true;
    public int score;

    private Button firstButtonLevelOne;
    private Button secondButtonLevelOne;
    private Button thirdButtonLevelOne;
    private TextView levelOneTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstButtonLevelOne = (Button)findViewById(R.id.buttonOneLevelOne);
        firstButtonLevelOne.setOnClickListener(this);

        secondButtonLevelOne = (Button)findViewById(R.id.buttonTwoLevelOne);
        secondButtonLevelOne.setOnClickListener(this);

        thirdButtonLevelOne = (Button)findViewById(R.id.buttonThreeLevelOne);
        thirdButtonLevelOne.setOnClickListener(this);

        levelOneTextView = (TextView)findViewById(R.id.levelOneTextView);

    }

    @Override
    public void onClick(View view) {

    }

    public void runLevelOne(boolean notOver, int scoreKeeper){

        Random rand = new Random();
        int answer = rand.nextInt(3) + 1;
        Log.i("Random number = ", "" + answer);

        setContentView(R.layout.levelonelayout);

        while(notOver){

            levelOneTextView.setText("Guess a Number between 1 and 3");



        }


    }
}
