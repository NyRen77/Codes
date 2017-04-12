package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ChoiceActivity extends AppCompatActivity {
    private ArrayList<Question> questions;
    private int prize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            questions = (ArrayList<Question>) i.getSerializableExtra("sampleObject");
            prize = (int) i.getSerializableExtra("prize");
        }

        TextView choiceTV = (TextView) findViewById(R.id.choiceTextView);
        choiceTV.setText("Right answer! You won: " + Integer.toString(prize) + " $");
        prize = prize * 2;
        Button winButton = (Button) findViewById(R.id.winButton);
        winButton.setText("Take prize.");
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setText("Next Question.");

    }

    public void onChoiceClick(View view) {
        if (view.getId() == R.id.winButton) {
            Intent toMain = new Intent(ChoiceActivity.this, MainActivity.class);
            toMain.putExtra("sampleObject", questions);
            startActivity(toMain);
        }
        if (view.getId() == R.id.nextButton) {
            Intent toQuestion = new Intent(ChoiceActivity.this, QuizActivity.class);
            toQuestion.putExtra("sampleObject", questions);
            toQuestion.putExtra("prize", prize);
            startActivity(toQuestion);
        }
    }

}
