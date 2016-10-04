package com.example.oliverthurn.numberguess;

import android.app.Application;
import android.graphics.Color;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oliverthurn on 10/3/16.
 */
public class HighScoreList extends Application{

    public static ArrayList<String> list;

    // Default constructor
    public HighScoreList(){
        this.list = new ArrayList<>();
    }

    // Constructor with one string element
    public HighScoreList(String name){
        this.list.add(name);
    }

    // setter to add a name to the list
    public void setListElement(String name){
        this.list.add(name);
    }

    public void printHighScoreListToTable(TableLayout table){

        for(int i = 0; i < list.size(); i++){

            String player = list.get(i);

            TextView name = new TextView(this);
            name.setTextSize(20);
            name.setTextColor(Color.rgb(255,255,255));

            TextView score = new TextView(this);
            score.setTextSize(20);
            score.setTextColor(Color.rgb(255,255,255));

            TableRow row = new TableRow(this);

            name.setText(player);
            row.addView(name);
            table.addView(row);

        }

    }

    public int size(){
        return this.list.size();
    }

    //public HighScoreList finalHighScoreList = new HighScoreList();


}
