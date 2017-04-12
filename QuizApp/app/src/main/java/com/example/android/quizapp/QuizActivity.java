package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private ArrayList<Question> questions;
    private int prize;
    private int rightAnswerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            questions = (ArrayList<Question>) i.getSerializableExtra("sampleObject");
            prize = (int) i.getSerializableExtra("prize");
        }
        TextView prizeTV = (TextView) findViewById(R.id.prizeTextView);
        prizeTV.setText(Integer.toString(prize) + " $");

        //choosing a random question
        Random rand = new Random();
        int randomQuestionElement = rand.nextInt(questions.size());
        Question chosenQuestion = questions.get(randomQuestionElement);

        //question to view
        TextView questionTV = (TextView) findViewById(R.id.questionTextView);
        questionTV.setText(chosenQuestion.getQuestion());

        //randomizing the buttons
        int ans1rand = rand.nextInt(4);
        Button ans1Button = (Button) findViewById(R.id.ans1Button);
        ans1Button.setText(chosenQuestion.getAnswer(ans1rand));
        if (ans1rand == chosenQuestion.getGoodAnswerId()) {
            rightAnswerId = 1;
        }


        int ans2rand = rand.nextInt(4);
        while (ans2rand == ans1rand) {
            ans2rand = rand.nextInt(4);
        }

        Button ans2Button = (Button) findViewById(R.id.ans2Button);
        ans2Button.setText(chosenQuestion.getAnswer(ans2rand));
        if (ans2rand == chosenQuestion.getGoodAnswerId()) {
            rightAnswerId = 2;
        }

        int ans3rand = rand.nextInt(4);
        while (ans3rand == ans1rand || ans3rand == ans2rand) {
            ans3rand = rand.nextInt(4);
        }

        Button ans3Button = (Button) findViewById(R.id.ans3Button);
        ans3Button.setText(chosenQuestion.getAnswer(ans3rand));
        if (ans3rand == chosenQuestion.getGoodAnswerId()) {
            rightAnswerId = 3;
        }

        int ans4rand = rand.nextInt(4);
        while (ans4rand == ans1rand || ans4rand == ans2rand || ans4rand == ans3rand) {
            ans4rand = rand.nextInt(4);
        }

        Button ans4Button = (Button) findViewById(R.id.ans4Button);
        ans4Button.setText(chosenQuestion.getAnswer(ans4rand));
        if (ans4rand == chosenQuestion.getGoodAnswerId()) {
            rightAnswerId = 4;
        }
    }

    public void onAnswerClick(View view) {
        if (view.getId() == R.id.ans1Button) {
            if (rightAnswerId == 1) {
                Intent toChoice = new Intent(this, ChoiceActivity.class);
                toChoice.putExtra("sampleObject", questions);
                toChoice.putExtra("prize", prize);
                startActivity(toChoice);
            } else {
                Intent toLose = new Intent(this, LoseActivity.class);
                toLose.putExtra("sampleObject", questions);
                startActivity(toLose);
            }
        }
        if (view.getId() == R.id.ans2Button) {
            if (rightAnswerId == 2) {
                Intent toChoice = new Intent(this, ChoiceActivity.class);
                toChoice.putExtra("sampleObject", questions);
                toChoice.putExtra("prize", prize);
                startActivity(toChoice);
            } else {
                Intent toLose = new Intent(this, LoseActivity.class);
                toLose.putExtra("sampleObject", questions);
                startActivity(toLose);
            }
        }
        if (view.getId() == R.id.ans3Button) {
            if (rightAnswerId == 3) {
                Intent toChoice = new Intent(this, ChoiceActivity.class);
                toChoice.putExtra("sampleObject", questions);
                toChoice.putExtra("prize", prize);
                startActivity(toChoice);
            } else {
                Intent toLose = new Intent(this, LoseActivity.class);
                toLose.putExtra("sampleObject", questions);
                startActivity(toLose);
            }
        }
        if (view.getId() == R.id.ans4Button) {
            if (rightAnswerId == 4) {
                Intent toChoice = new Intent(this, ChoiceActivity.class);
                toChoice.putExtra("sampleObject", questions);
                toChoice.putExtra("prize", prize);
                startActivity(toChoice);
            } else {
                Intent toLose = new Intent(this, LoseActivity.class);
                toLose.putExtra("sampleObject", questions);
                startActivity(toLose);
            }
        }
    }
}

