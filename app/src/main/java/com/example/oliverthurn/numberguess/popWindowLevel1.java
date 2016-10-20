package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by oliverthurn on 9/23/16.
 */

public class popWindowLevel1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPopUpWindow();

    }

    /* Method to create popUpWindow that is half the size of the parent window */
    public void createPopUpWindow(){

        /* Creating the window its self */
        setContentView(R.layout.popwindow);
        setTheme(R.style.AppTheme_PopUpTheme);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * .5), (int) (height * .5));


        /* Creating next button and adding functionality*/
        Button nextButton = (Button)findViewById(R.id.nextButtonPop);
        nextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevel1.this, Level2Activity.class));


            }
        });

        /* Creating quit button and adding functionality */

        Button quitButton = (Button)findViewById(R.id.quitButtonPop);
        quitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindowLevel1.this, MainActivity.class));

            }
        });
    }
}
