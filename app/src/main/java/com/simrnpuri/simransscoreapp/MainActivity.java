package com.simrnpuri.simransscoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private int radioValue , teamARuns , teamBRuns , teamAWickets , teamBWickets;

    private ImageButton ButtonRunsPlusA;
    private ImageButton ButtonRunsPlusB;
    private ImageButton ButtonRunsMinusA;
    private ImageButton ButtonRunsMinusB;
    private ImageButton ButtonMinusA;
    private ImageButton ButtonMinusB;
    private RadioButton radioOne;
    private Button ButtonReset;
    private TextView textViewTeamARuns;
    private TextView textViewTeamBRuns;
    private TextView textViewTeamAWickets;
    private TextView textViewTeamBWickets;
    private RadioGroup radioGroup;

    //keeping these in case of future enhancements
//    private RadioButton radioTwo;
//    private RadioButton radioThee;
//    private RadioButton radioFour;
//    private RadioButton radioSix;
//    private EditText editTextTeamNameA;
//    private EditText editTextTeamNameB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonRunsPlusA = findViewById(R.id.imageButtonRunsPlusA);
        ButtonRunsPlusB = findViewById(R.id.imageButtonRunsPlusB);
        ButtonRunsMinusA = findViewById(R.id.imageButtonRunsMinusA);
        ButtonRunsMinusB = findViewById(R.id.imageButtonRunsMinusB);
        ButtonMinusA = findViewById(R.id.buttonWicketTeamA);
        ButtonMinusB = findViewById(R.id.buttonWicketTeamB);
        radioOne = findViewById(R.id.radioButton1);
        ButtonReset = findViewById(R.id.buttonReset);

        radioGroup = findViewById(R.id.radioGroup);
        textViewTeamARuns = findViewById(R.id.textViewRunsTeamA);
        textViewTeamBRuns = findViewById(R.id.textViewRunsTeamB);
        textViewTeamAWickets = findViewById(R.id.textViewWicketsTeamA);
        textViewTeamBWickets = findViewById(R.id.textViewWicketsTeamB);

        //keeping in case of future enhancement
//        radioTwo = findViewById(R.id.radioButton2);
//        radioThee = findViewById(R.id.radioButton3);
//        radioFour = findViewById(R.id.radioButton4);
//        radioSix = findViewById(R.id.radioButton6);
//        editTextTeamNameA = findViewById(R.id.editTextTeam1Name);
//        editTextTeamNameB = findViewById(R.id.editTextTeam2Name);



        ButtonRunsPlusA.setOnClickListener(this);
        ButtonRunsPlusB.setOnClickListener(this);
        ButtonRunsMinusA.setOnClickListener(this);
        ButtonRunsMinusB.setOnClickListener(this);
        ButtonMinusA.setOnClickListener(this);
        ButtonMinusB.setOnClickListener(this);
        ButtonReset.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        //this is called on OnCreate() for setting the default values
        resetDefault();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageButtonRunsPlusA:
                teamRunsUpdate('A');
                break;
            case R.id.imageButtonRunsPlusB:
                teamRunsUpdate('B');
                break;
            case R.id.buttonWicketTeamA:
                teamWicketUpdate('A');
                break;
            case R.id.buttonWicketTeamB:
                teamWicketUpdate('B');
                break;
            case R.id.imageButtonRunsMinusA:
                teamRunsMinus('A');
                break;
            case R.id.imageButtonRunsMinusB:
                teamRunsMinus('B');
                break;
            case R.id.buttonReset:
                resetDefault();
                break;
        }
    }

    //This method resets the view and values to default
    private void resetDefault() {
        radioValue = 1;
        teamARuns = 0;
        teamBRuns = 0;
        teamAWickets = 10;
        teamBWickets = 10;
        radioOne.setChecked(true);
        textViewTeamARuns.setText("0");
        textViewTeamBRuns.setText("0");
        textViewTeamAWickets.setText("10");
        textViewTeamBWickets.setText("10");

    }

    //This method is for decreasing the Runs as per the radio button selected
    private void teamRunsMinus(char TeamId) {
        if(TeamId == 'A'){
            if(teamARuns >= radioValue){
                teamARuns = teamARuns - radioValue;
                textViewTeamARuns.setText(""+teamARuns);
            }
        }

        else if(TeamId == 'B'){
            if(teamBRuns >= radioValue){
                teamBRuns = teamBRuns - radioValue;
                textViewTeamBRuns.setText(""+teamBRuns);
            }
        }
    }

    //This method decreases the Wickets count by 1
    private void teamWicketUpdate(char TeamId) {
        if(TeamId == 'A') {
            if (teamAWickets > 0) {
                teamAWickets = teamAWickets - 1;
                textViewTeamAWickets.setText("" + teamAWickets);
            }
        }

         else if(TeamId == 'B'){
                if(teamBWickets>0){
                    teamBWickets = teamBWickets - 1;
                    textViewTeamBWickets.setText(""+teamBWickets);
                }
            }
    }

    //This method Increases runs as per the radio button selected
    private void teamRunsUpdate (char TeamId) {
        if(TeamId == 'A'){
            teamARuns = teamARuns + radioValue;
            textViewTeamARuns.setText(""+teamARuns);
        }
        else if(TeamId == 'B'){
            teamBRuns = teamBRuns + radioValue;
            textViewTeamBRuns.setText(""+teamBRuns);
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //fetches the checked radio button and sets the radioValue for Runs increase and decrease.
        switch (checkedId) {
            case R.id.radioButton1:
                radioValue = 1;
                break;
            case R.id.radioButton2:
                radioValue = 2;
                break;
            case R.id.radioButton3:
                radioValue = 3;
                break;
            case R.id.radioButton4:
                radioValue = 4;
                break;
            case R.id.radioButton6:
                radioValue = 6;
                break;
        }
    }

}