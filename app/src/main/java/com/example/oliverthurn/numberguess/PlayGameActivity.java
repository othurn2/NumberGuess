package com.example.oliverthurn.numberguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {

    // This is to test gitHub desktop
    protected Button popUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        popUpButton = (Button)findViewById(R.id.popUpButton);
        popUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.popUpButton:
                showPopWind();
                break;

            default:
                break;


        }
    }

    private void showPopWind(){
        startActivity(new Intent(this, popWindowLevel1.class));

    }

    public void levelOne(){
        setContentView(R.layout.levelonelayout);

        DisplayMetrics levelOneDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(levelOneDisplayMetrics);

        int width = levelOneDisplayMetrics.widthPixels;
        int height = levelOneDisplayMetrics.heightPixels;

        getWindow().setLayout(width, height);

    }

}
