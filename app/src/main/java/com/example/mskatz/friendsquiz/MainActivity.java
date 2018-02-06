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
        if (toUpperCase(firstAnswer()).equals(getString(R.string.central_perk))) {
            addPoint(score);
        }
        if (secondAnswer()) {
            addPoint(score);
        }
        if (thirdAnswer()) {
            addPoint(score);
        }
        if (toUpperCase(fourthAnswer()).equals(getString(R.string.tulsa))) {
            addPoint(score);
        }
        if (fifthAnswer()) {
            addPoint(score);
        }
        if (sixthAnswer()) {
            addPoint(score);
        }
        if (score == 6) {
            Toast.makeText(this, getString(R.string.score) + " " + String.valueOf(score) + "\n" + getString(R.string.congratulations), Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, getString(R.string.score) + " " + String.valueOf(score) + "\n" + getString(R.string.better), Toast.LENGTH_SHORT).show();

        score = 0;
    }

    public void addPoint(int point) {
        score += 1;
    }

    private String firstAnswer() {
        EditText editText = findViewById(R.id.place_of_work);
        return editText.getText().toString();
    }

    private boolean secondAnswer() {
        boolean trueOrFalse = false;
        CheckBox stateChick = findViewById(R.id.chick);
        CheckBox stateDog = findViewById(R.id.dog);
        CheckBox stateDuck = findViewById(R.id.duck);
        CheckBox stateMonkey = findViewById(R.id.monkey);
        if (stateDuck.isChecked() && stateChick.isChecked()) {
            trueOrFalse = !(stateDog.isChecked() || stateMonkey.isChecked());
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
        return editText.getText().toString();

    }

    private boolean fifthAnswer() {
        boolean trueOrFalse = false;
        CheckBox stateChandler = findViewById(R.id.chandler);
        CheckBox statePhoebe = findViewById(R.id.phoebe);
        CheckBox stateRachel = findViewById(R.id.rachel);
        CheckBox stateJoey = findViewById(R.id.joey);
        if (stateRachel.isChecked() && stateJoey.isChecked()) {
            trueOrFalse = !(stateChandler.isChecked() || statePhoebe.isChecked());
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



