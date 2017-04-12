package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private EditText question, ans1, ans2, ans3, ans4;
    private RadioGroup radioGRP;
    private RadioButton radioBTN;
    private Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void onOkButtonClick(View view) {
        //We want to add a question to the question class
        Question newQ = new Question();
        String question, ans1, ans2, ans3, ans4;
        int rightId = 0;


        boolean okay = false;

        //edit text
        EditText qET = (EditText) findViewById(R.id.question);
        EditText ans1ET = (EditText) findViewById(R.id.answer1);
        EditText ans2ET = (EditText) findViewById(R.id.answer2);
        EditText ans3ET = (EditText) findViewById(R.id.answer3);
        EditText ans4ET = (EditText) findViewById(R.id.answer4);


        //radio buttons
        radioGRP = (RadioGroup) findViewById(R.id.rgGoodAnswer);
        submitBTN = (Button) findViewById(R.id.okBTN);
        int selectedID = radioGRP.getCheckedRadioButtonId();
        radioBTN = (RadioButton) findViewById(selectedID);


        if (radioBTN != null) {
            switch (radioBTN.getId()) {
                case R.id.r1BTN:
                    okay = true;
                    rightId = 0;
                    break;
                case R.id.r2BTN:
                    okay = true;
                    rightId = 1;
                    break;
                case R.id.r3BTN:
                    okay = true;
                    rightId = 2;
                    break;
                case R.id.r4BTN:
                    okay = true;
                    rightId = 3;
                    break;
                default:
                    okay = false;
                    break;
            }
        } else {
            Toast.makeText(AddActivity.this, "Please choose the right answer!", Toast.LENGTH_LONG).show();
            okay = false;
        }

        question = qET.getText().toString();
        ans1 = ans1ET.getText().toString();
        ans2 = ans2ET.getText().toString();
        ans3 = ans3ET.getText().toString();
        ans4 = ans4ET.getText().toString();

        if (question.isEmpty() || ans1.isEmpty() || ans2.isEmpty() || ans3.isEmpty() || ans4.isEmpty()) {
            Toast.makeText(AddActivity.this, "Please fill out the question and the answers!", Toast.LENGTH_LONG).show();
            okay = false;
        }


        if (okay == true) {
            Intent i = getIntent();
            Bundle extras = getIntent().getExtras();
            ArrayList<Question> questions = (ArrayList<Question>) i.getSerializableExtra("sampleObject");
            newQ.fill(question, ans1, ans2, ans3, ans4, rightId);
            questions.add(newQ);

            Intent toMenu = new Intent(AddActivity.this, MainActivity.class);
            toMenu.putExtra("sampleObject", questions);
            startActivity(toMenu);
        }

    }

}
