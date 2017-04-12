package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class LoseActivity extends AppCompatActivity {

    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            questions = (ArrayList<Question>) i.getSerializableExtra("sampleObject");
        }
    }

    public void onBackClick(View view) {
        if (view.getId() == R.id.okButton) {
            Intent toMain = new Intent(LoseActivity.this, MainActivity.class);
            toMain.putExtra("sampleObject", questions);
            startActivity(toMain);
        }

    }
}
