package com.example.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   int teamAscore = 0;
   int teamBscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeteamA(View view) {
        teamAscore = teamAscore + 3;
        displayForTeamA(teamAscore);
    }

    public void addTwoteamA(View view) {
        teamAscore = teamAscore + 2;
        displayForTeamA(teamAscore);
    }

    public void freeThrowteamA(View view) {
        teamAscore = teamAscore + 1;
        displayForTeamA(teamAscore);
    }

    public void addThreeteamB(View view) {
        teamBscore = teamBscore + 3;
        displayForTeamB(teamBscore);
    }

    public void addTwoteamB(View view) {
        teamBscore = teamBscore + 2;
        displayForTeamB(teamBscore);
    }

    public void freeThrowteamB(View view) {
        teamBscore = teamBscore + 1;
        displayForTeamB(teamBscore);
    }

    public void resetScore(View view) {
        teamAscore = 0;
        teamBscore = 0;
        displayForTeamA(teamAscore);
        displayForTeamB(teamBscore);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
