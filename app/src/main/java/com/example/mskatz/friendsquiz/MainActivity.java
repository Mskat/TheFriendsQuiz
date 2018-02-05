package com.example.mskatz.friendsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.icu.lang.UCharacter.toUpperCase;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void result(View view) {
        if (toUpperCase(firstAnswer()).equals("CENTRAL PERK")) {
            addPoint(score);
        }
        if (secondAnswer()) {
            addPoint(score);
        }
        if (thirdAnswer()) {
            addPoint(score);
        }
        if (toUpperCase(fourthAnswer()).equals("TULSA")) {
            addPoint(score);
        }
        if (fifthAnswer()) {
            addPoint(score);
        }
        if (sixthAnswer()) {
            addPoint(score);
        }
        if (score == 6) {
            Toast.makeText(this, "Your score is " + String.valueOf(score) + "\nCongratulations!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Your score is " + String.valueOf(score) + "\nNext time you will be better :)", Toast.LENGTH_SHORT).show();

        score = 0;
    }

    public void addPoint(int point) {
        score += 1;
    }

    private String firstAnswer() {
        EditText editText = findViewById(R.id.place_of_work);
        String placeOfWork = editText.getText().toString();
        return placeOfWork;
    }

    private boolean secondAnswer() {
        boolean trueOrFalse = false;
        CheckBox stateChick = findViewById(R.id.chick);
        CheckBox stateDog = findViewById(R.id.dog);
        CheckBox stateDuck = findViewById(R.id.duck);
        CheckBox stateMonkey = findViewById(R.id.monkey);
        if (stateDuck.isChecked() && stateChick.isChecked()) {
            trueOrFalse = true;
            if (stateDog.isChecked() || stateMonkey.isChecked()) {
                trueOrFalse = false;
            }
        }
        return trueOrFalse;
    }

    private boolean thirdAnswer() {
        boolean trueOrFalse = false;
        RadioButton radioButton = findViewById(R.id.answer_no);
        if (radioButton.isChecked()) {
            trueOrFalse = true;
        }
        return trueOrFalse;
    }

    private String fourthAnswer() {
        EditText editText = findViewById(R.id.name_of_town);
        String nameOfTown = editText.getText().toString();
        return nameOfTown;
    }

    private boolean fifthAnswer() {
        boolean trueOrFalse = false;
        CheckBox stateChandler = findViewById(R.id.chandler);
        CheckBox statePhoebe = findViewById(R.id.phoebe);
        CheckBox stateRachel = findViewById(R.id.rachel);
        CheckBox stateJoey = findViewById(R.id.joey);
        if (stateRachel.isChecked() && stateJoey.isChecked()) {
            trueOrFalse = true;
            if (stateChandler.isChecked() || statePhoebe.isChecked()) {
                trueOrFalse = false;
            }
        }
        return trueOrFalse;
    }

    private boolean sixthAnswer() {
        boolean trueOrFalse = false;
        RadioButton radioButton = findViewById(R.id.answer_muriel);
        if (radioButton.isChecked()) {
            trueOrFalse = true;
        }
        return trueOrFalse;
    }
}



