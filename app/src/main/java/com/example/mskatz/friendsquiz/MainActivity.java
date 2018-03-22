package com.example.mskatz.friendsquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app tests knowledge from tv show The Friends in the form of a quiz
 */

public class MainActivity extends AppCompatActivity {

    //general value of a score
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks the user's response, sums up the result and displays a message containing the result
     */
    public void result(View view) {
        firstAnswer();
        secondAnswer();
        thirdAnswer();
        fourthAnswer();
        fifthAnswer();
        sixthAnswer();

        if (score == 6) {
            Toast.makeText(this, getString(R.string.score) + " " + String.valueOf(score) + "\n" + getString(R.string.congratulations), Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, getString(R.string.score) + " " + String.valueOf(score) + "\n" + getString(R.string.better), Toast.LENGTH_SHORT).show();

        score = 0;
    }

    /**
     * Adds one point to general score
     */
    public void addPoint(int point) {
        score += 1;
    }

    /**
     * Changes the background color to green, for the correct answer
     */
    private void changeColorC(View v) {
        v.setBackgroundColor(Color.parseColor("#009900"));
    }

    /**
     * Changes the background color to red, for the incorrect answer
     */
    private void changeColorW(View v) {
        v.setBackgroundColor(Color.RED);
    }

    /**
     * Answer for the first question: Where does \'Gunther\' work?
     * This method checks is user's answer correct or not
     */
    private void firstAnswer() {
        EditText editText = findViewById(R.id.place_of_work);
        if (editText.getText().toString().toUpperCase().replaceAll("\\s", "").equals(getString(R.string.central_perk))) {
            addPoint(score);
            changeColorC(editText);
        } else {
            changeColorW(editText);
        }
    }

    /**
     * Answer for the second question: What types of an animal do Joey and Chandler own?
     * This method checks is user's answer correct or not
     */
    private void secondAnswer() {
        CheckBox stateChick = findViewById(R.id.chick);
        CheckBox stateDog = findViewById(R.id.dog);
        CheckBox stateDuck = findViewById(R.id.duck);
        CheckBox stateMonkey = findViewById(R.id.monkey);
        if (stateDuck.isChecked() && stateChick.isChecked() && !(stateDog.isChecked()) && !(stateMonkey.isChecked())) {
            addPoint(score);
            changeColorC(stateChick);
            changeColorC(stateDuck);
        } else {
            changeColorW(stateChick);
            changeColorW(stateDuck);
        }
    }

    /**
     * Answer for the third question: Did Phoebe carry for her brother two babies?
     * This method checks is user's answer correct or not
     */
    private void thirdAnswer() {
        RadioButton radioButton = findViewById(R.id.answer_no);
        if (radioButton.isChecked()) {
            addPoint(score);
            changeColorC(radioButton);
        } else {
            changeColorW(radioButton);
        }
    }

    /**
     * Answer for the fourth question: Where is Chandler forced to work after falling asleep in a meeting?
     * This method checks is user's answer correct or not
     */
    private void fourthAnswer() {
        EditText editText = findViewById(R.id.name_of_town);
        if (editText.getText().toString().replaceAll("\\s", "").toUpperCase().equals(getString(R.string.tulsa))) {
            addPoint(score);
            changeColorC(editText);
        } else {
            changeColorW(editText);
        }
    }

    /**
     * Answer for the fifth question: Which of The Friends have worked in the coffee shop?
     * This method checks is user's answer correct or not
     */
    private void fifthAnswer() {
        CheckBox stateChandler = findViewById(R.id.chandler);
        CheckBox statePhoebe = findViewById(R.id.phoebe);
        CheckBox stateRachel = findViewById(R.id.rachel);
        CheckBox stateJoey = findViewById(R.id.joey);
        if (stateRachel.isChecked() && stateJoey.isChecked() && !(stateChandler.isChecked()) && !(statePhoebe.isChecked())) {
            addPoint(score);
            changeColorC(stateRachel);
            changeColorC(stateJoey);
        } else {
            changeColorW(stateRachel);
            changeColorW(stateJoey);
        }
    }

    /**
     * Answer for the sixth question: What is Chandler's middle name?
     * This method checks is user's answer correct or not
     */
    private void sixthAnswer() {
        RadioButton radioButton = findViewById(R.id.answer_muriel);
        if (radioButton.isChecked()) {
            addPoint(score);
            changeColorC(radioButton);
        } else {
            changeColorW(radioButton);
        }
    }
}



