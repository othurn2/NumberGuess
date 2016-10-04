package com.example.oliverthurn.numberguess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by oliverthurn on 10/3/16.
 */


public class HighScorePopWindow extends Activity implements View.OnClickListener {

    public static HighScoreList playerList;
    protected String playerNameToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playerList = new HighScoreList();
        createPopUpWindow();

    }

    @Override
    public void onClick(View v) {


        //((HighScoreList) this.getApplication()).setListElement(playerNameToSave);

    }


    public void createPopUpWindow() {

        /* Creating the window its self */
        setContentView(R.layout.highscore_popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .5), (int) (height * .5));


        final EditText editorToEnterName = (EditText)findViewById(R.id.highscorePopNameText);
        final TextView highScoreDisplay = (TextView)findViewById(R.id.highscorePopScoreText);

        highScoreDisplay.setText("" + Level1Activity.score);


        Button saveButton = (Button)findViewById(R.id.highscorePopSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playerNameToSave = editorToEnterName.getText().toString();
                playerList.setListElement(playerNameToSave);
                goToHighScoreActivity();
            }
        });

    }

    public void goToHighScoreActivity(){

        startActivity(new Intent(HighScorePopWindow.this, HighScoreActivity.class));

    }


}
