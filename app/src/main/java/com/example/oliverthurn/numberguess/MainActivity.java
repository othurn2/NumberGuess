package com.example.oliverthurn.numberguess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* sound objects */
    private SoundPool playSound;
    int sampleOne = -1;

    /* Creating objects for buttons and view on main activity */
    public  static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;

    String dataType = "HighScore";
    public static String dataName = "The Score";
    String defaultString = "";
    String highScoreToString = "HighScore: ";
    public static String savedHighScore = "0";


    protected Button playButton;
    protected Button highScoreButton;
    protected TextView highScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setting those objects and click listeners.*/
        playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

        highScoreButton = (Button)findViewById(R.id.highScoreButton);
        highScoreButton.setOnClickListener(this);

        highScoreView = (TextView)findViewById(R.id.highScoreTextView);

        preferences = getSharedPreferences(dataType, MODE_PRIVATE);
        editor = preferences.edit();

        highScoreToString += preferences.getString(dataName, savedHighScore);
        highScoreView.setText(highScoreToString);

        /* Creating the sound pool */
        playSound = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);

        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetManager.openFd("playbuttonsound.wav");
            sampleOne = playSound.load(descriptor, 0);
            Log.i("sampleOne", "" + sampleOne);


        } catch(IOException e ){
            e.printStackTrace();
            Log.i("sound not loaded", "blah");
        }

    }

    @Override
    public void onClick(View view) {

        /* A switch statement for the two buttons on the main activity with intents created and started */
        switch (view.getId()){

            case R.id.playButton:
                playSound.play(sampleOne, 1,1,0,0,1);
                Intent startGame = new Intent(this,Level1Activity.class);
                startActivity(startGame);
                break;

            case R.id.highScoreButton:
                Intent highscoreIntent = new Intent(this, HighScoreActivity.class);
                startActivity(highscoreIntent);
                break;

        }

    }
}
