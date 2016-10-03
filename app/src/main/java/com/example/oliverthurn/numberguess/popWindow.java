package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

/**
 * Created by oliverthurn on 9/23/16.
 */

public class popWindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPopUpWindow();

    }

    /* Method to create popUpWindow that is half the size of the parent window */
    public void createPopUpWindow(){

        /* Creating the window its self */
        setContentView(R.layout.popwindow);

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
                startActivity(new Intent(popWindow.this, LevelTwo.class));


            }
        });

        /* Creating quit button and adding functionality */

        Button quitButton = (Button)findViewById(R.id.quitButtonPop);
        quitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(popWindow.this, MainActivity.class));

            }
        });
    }
}
