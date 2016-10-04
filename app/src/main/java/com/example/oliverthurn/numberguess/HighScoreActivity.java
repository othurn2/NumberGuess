package com.example.oliverthurn.numberguess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

/**
 * Created by oliverthurn on 9/27/16.
 */
public class HighScoreActivity extends AppCompatActivity implements View.OnClickListener{


    protected TableLayout highScoreTable;
    public ArrayList<String> highScoreList = new ArrayList<>();
    public String playerName;
    protected Button exitButton;
    public HighScoreList finalScoreList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_high_score);
        highScoreTable = (TableLayout)findViewById(R.id.highScoreTable);

        highScoreList = turnHighScoreListIntoArrayList(HighScorePopWindow.playerList);
        exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setText("exit");
        exitButton.setOnClickListener(this);

        setStringArrayPref(this, playerName, highScoreList);

        ArrayList<String> blank = getStringArrayPref(this, playerName);

        displayHighScoreListInTable(blank);

        //displayHighScoreListInTable(HighScorePopWindow.playerList);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(HighScoreActivity.this, MainActivity.class));
    }

    public void addNameToHighScoreList(ArrayList<String> highscore, String name){

        highscore.add(name);
    }

    public void displayHighScoreListInTable(HighScoreList scoreList){

        for(int i = 0; i < scoreList.list.size(); i++){

            TextView name = new TextView(this);
            name.setTextSize(20);
            name.setTextColor(Color.rgb(255,255,255));

            TextView score = new TextView(this);
            score.setTextSize(20);
            score.setTextColor(Color.rgb(255,255,255));

            TableRow row = new TableRow(this);

            name.setText(scoreList.list.get(i));
            row.addView(name);
            highScoreTable.addView(row);

        }

    }

    public void displayHighScoreListInTable(ArrayList<String> scoreList){

        for(int i = 0; i < scoreList.size(); i++){

            TextView name = new TextView(this);
            name.setTextSize(20);
            name.setTextColor(Color.rgb(255,255,255));

            TextView score = new TextView(this);
            score.setTextSize(20);
            score.setTextColor(Color.rgb(255,255,255));

            TableRow row = new TableRow(this);

            name.setText(scoreList.get(i));
            row.addView(name);
            highScoreTable.addView(row);

        }

    }

    public void setStringArrayPref(Context context, String key, ArrayList<String> highScores){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefEditor = prefs.edit();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < highScores.size(); i++){
            jsonArray.put(highScores.get(i));
        }
        if (!highScores.isEmpty()){
            prefEditor.putString(key, jsonArray.toString());
        } else {
            prefEditor.putString(key, null);
        }
        prefEditor.commit();
    }

    public ArrayList<String> getStringArrayPref(Context context, String key){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String json = preferences.getString(key,null);
        ArrayList<String> highScores = new ArrayList<>();

        if(json != null){
            try{
                JSONArray jsonArray = new JSONArray(json);
                for(int i = 0; i < jsonArray.length(); i++){
                    String highscore = jsonArray.optString(i);
                    highScores.add(highscore);
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return highScores;
    }

    public ArrayList<String> turnHighScoreListIntoArrayList(HighScoreList highScoreList){

        ArrayList<String> toReturn = new ArrayList<>();

        for (int i = 0; i < highScoreList.list.size(); i++){
            String replace = highScoreList.list.get(i);
            toReturn.add(i, replace);
        }

        return toReturn;
    }

}
