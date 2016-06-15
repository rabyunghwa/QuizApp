package com.example.byunghwa.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstQuestion, etFifthQuestion;
    private RadioGroup rgSecondQuestion, rgThirdQuestion;
    private CheckBox cbSecond, cbThird, cbFourth;
    private Button bnSubmit;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        restoreState(savedInstanceState);
        onClickListener();
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("rgSecond")) {
                rgSecondQuestion.check((Integer) savedInstanceState.get("rgSecond"));
            }
            if (savedInstanceState.containsKey("rgThird")) {
                rgSecondQuestion.check((Integer) savedInstanceState.get("rgThird"));
            }
        }
    }

    private void onClickListener() {
        bnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                checkResults();
                displayResult();
            }
        });
    }

    private void displayResult() {
        Toast.makeText(this, "You have answered " + result + " questions correctly.", Toast.LENGTH_SHORT).show();
    }

    private void checkResults() {
        checkFirstQuestion();
        checkSecondQuestion();
        checkThirdQuestion();
        checkFourthQuestion();
        checkFifthQuestion();
    }

    private void checkFifthQuestion() {
        if (etFifthQuestion.getText().toString().equals("el huevo")) {
            result += 1;
        }
    }

    private void checkFourthQuestion() {
        if (cbSecond.isChecked() && cbThird.isChecked() && cbFourth.isChecked()) {
            result += 1;
        }
    }

    private void checkThirdQuestion() {
        if (rgThirdQuestion.getCheckedRadioButtonId() == R.id.rbWoman) {
            result += 1;
        }
    }

    private void checkSecondQuestion() {
        if (rgSecondQuestion.getCheckedRadioButtonId() == R.id.rbApple) {
            result += 1;
        }
    }

    private void checkFirstQuestion() {
        if (etFirstQuestion.getText().toString().equals("a boy") || etFirstQuestion.getText().toString().equals("a kid") || etFirstQuestion.getText().toString().equals("a child")) {
            result += 1;
        }
    }

    private void findViews() {
        etFirstQuestion = (EditText) findViewById(R.id.etFirstQuestion);
        etFifthQuestion = (EditText) findViewById(R.id.etFifthQuestion);
        rgSecondQuestion = (RadioGroup) findViewById(R.id.rgSecondQuestion);
        rgThirdQuestion = (RadioGroup) findViewById(R.id.rgThirdQuestion);
        cbSecond = (CheckBox) findViewById(R.id.cbSecond);
        cbThird = (CheckBox) findViewById(R.id.cbThird);
        cbFourth = (CheckBox) findViewById(R.id.cbFourth);
        bnSubmit = (Button) findViewById(R.id.bnSubmit);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("rgSecond", rgSecondQuestion.getCheckedRadioButtonId());
        outState.putInt("rgThird", rgThirdQuestion.getCheckedRadioButtonId());
    }
}
