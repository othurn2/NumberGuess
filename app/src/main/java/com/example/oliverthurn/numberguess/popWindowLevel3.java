package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by oliverthurn on 10/2/16.
 */
public class popWindowLevel3 extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.popwindowthree);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .5));


        /* Creating quit button and adding functionality */

        Button quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevel3.this, MainActivity.class));

            }
        });

        Button replayButton = (Button)findViewById(R.id.replayButton);
        replayButton.setTextColor(Color.WHITE);
        replayButton.setTextSize(20);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevel3.this, Level1Activity.class));
            }
        });
    }
}
