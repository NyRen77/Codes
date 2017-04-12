package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.Vector;

public class Question implements Serializable {
    private String question;
    private Vector<String> answers = new Vector<String>();
    private int goodAnswerId;

    public void fill(String q, String ans1, String ans2, String ans3, String ans4, int id) {

        this.question = q;
        this.answers.add(ans1);
        this.answers.add(ans2);
        this.answers.add(ans3);
        this.answers.add(ans4);
        this.goodAnswerId = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer(int id) {
        if (id > answers.size() || id < 0) {
            return null;
        } else {
            return answers.get(id);
        }
    }

    public int getGoodAnswerId() {
        return goodAnswerId;
    }
}
