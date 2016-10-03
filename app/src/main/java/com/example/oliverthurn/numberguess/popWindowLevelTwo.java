package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by oliverthurn on 9/27/16.
 */
public class popWindowLevelTwo extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPopUpWindow();
    }

    @Override
    public void onClick(View v) {

    }

    /* Method to create popUpWindow that is half the size of the parent window */
    public void createPopUpWindow() {

        /* Creating the window its self */
        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .5));

        TextView highScoreText = (TextView)findViewById(R.id.highScoreViewPopOne);

        //highScoreText.setText("" + ((HighScore) this.getApplication()).getScore());

        /* Creating next button and adding functionality*/
        Button nextButton = (Button) findViewById(R.id.nextButtonPop);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevelTwo.this, LevelThree.class));

            }
        });

        /* Creating quit button and adding functionality */

        Button quitButton = (Button) findViewById(R.id.quitButtonPop);
        quitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevelTwo.this, MainActivity.class));

            }
        });
    }
}
