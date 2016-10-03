package com.example.oliverthurn.numberguess;

import android.app.Application;

/**
 * Created by oliverthurn on 10/3/16.
 */
public class HighScore extends Application {

    public int score;
    public String scoreAsString;

    public HighScore(){

    }

    public HighScore(int score) {
        this.score = score;
        this.scoreAsString = Integer.toString(score);
    }

    public String getScoreAsString() {
        return scoreAsString;
    }

    public void setScoreAsString(String scoreAsString) {
        this.scoreAsString = scoreAsString;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToScore(int score){
        this.score = this.score + score;
    }
}
