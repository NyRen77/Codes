package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Question> questions;
    private String lastQuestion;
    private String Name;
    private int prize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            questions = (ArrayList<Question>) i.getSerializableExtra("sampleObject");
        } else if (extras == null) {
            questions = new ArrayList<Question>();
            //basic questions here:
            Question puz1 = new Question();
            puz1.fill("Which planet is closest to the sun?",
                    "Mercury", "Earth", "Jupiter", "Venus", 0);
            questions.add(puz1);

            Question puz2 = new Question();
            puz2.fill("What is a baby seal called?",
                    "A cub", "A pup", "A puggle", "A foal", 1);
            questions.add(puz2);

            Question puz3 = new Question();
            puz3.fill("How many holes there are in a T-shirt?",
                    "3", "6", "5", "4", 3);
            questions.add(puz3);

            Question puz4 = new Question();
            puz4.fill("Which literary movement's leading figure was Allen Ginsberg?",
                    "Beat literature", "Postmodernism", "Spoken Word", "Surrealism", 0);
            questions.add(puz4);

            Question puz5 = new Question();
            puz5.fill("How many women did Henry VIII have?",
                    "1", "3", "6", "7", 2);
            questions.add(puz5);

            Question puz6 = new Question();
            puz6.fill("What is the capital of Austria?",
                    "Vienna", "Sydney", "Melbourne", "Canberra", 0);
            questions.add(puz6);

            Question puz7 = new Question();
            puz7.fill("Who painted the Mona Lisa?",
                    "Leonardo da Vinci", "Michelangelo", "Donatello", "Botticelli", 0);
            questions.add(puz7);

            Question puz8 = new Question();
            puz8.fill("What is the name of the wizard at the court of King Arthur?",
                    "Merlin", "Gandalf", "Dumbledore", "Mefisto", 0);
            questions.add(puz8);

            Question puz9 = new Question();
            puz9.fill("Who stole Christmas in a Dr Seuss book?",
                    "The Grinch", "Shrek", "The Devil", "Cat in the hat", 0);
            questions.add(puz9);

            Question puz10 = new Question();
            puz10.fill("Eritrea, which became the 182nd member of the UN in 1993, is in the continent of",
                    "Africa", "Asia", "Europe", "Australia", 0);
            questions.add(puz10);
        }

        TextView tv = (TextView) findViewById(R.id.testView1);


        if (questions.size() > 0) {
            tv.setText("Questions: " + Integer.toString(questions.size()));
        } else {
            tv.setText("Questions: 0");
        }
    }


    public void onButtonClick(View view) {


        if (view.getId() == R.id.startBTN) {
            Intent toQuiz = new Intent(MainActivity.this, QuizActivity.class);
            toQuiz.putExtra("sampleObject", questions);
            prize = 500;
            toQuiz.putExtra("prize", prize);
            startActivity(toQuiz);
        }
        if (view.getId() == R.id.addBTN) {
            Intent toAdd = new Intent(MainActivity.this, AddActivity.class);
            toAdd.putExtra("sampleObject", questions);
            startActivity(toAdd);
        }
        if (view.getId() == R.id.exitBTN) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
