package com.example.oliverthurn.numberguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* Creating objects for buttons and view on main activity */
    protected Button playButton;
    protected Button highScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setting those objects and click listeners. The View is no active */
        playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

        highScoreButton = (Button)findViewById(R.id.highScoreButton);
        highScoreButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        /* A switch statement for the two buttons on the main activity with intents created and started */
        switch (view.getId()){

            case R.id.playButton:
                Intent startGame = new Intent(this,Level1Activity.class);
                //Intent playIntent = new Intent(this, PlayGameActivity.class);
                startActivity(startGame);
                break;

            case R.id.highScoreButton:
                Intent highscoreIntent = new Intent(this, HighScoreActivity.class);
                startActivity(highscoreIntent);
                break;

        }

    }
}
