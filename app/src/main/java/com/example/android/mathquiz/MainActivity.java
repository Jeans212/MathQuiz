package com.example.android.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int answerQuestionOne = R.id.option1_b;
    final int answerQuestionTwo = R.id.option2_b;
    final String answerQuestionFour = "31";
    final String answerQuestionFive = "366";
    int initialScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                Toast.makeText(this, "Math Quiz App created by \nOluwafemi John (c)2018.", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_quit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void submitAnswer(View view) {
        ArrayList<String> wrongAnswersList = new ArrayList<>();
        if (checkQuestionOne()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 1");
        }
        if (checkQuestionTwo()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 2");
        }
        if (checkQuestionThree()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 3");
        }
        if (checkQuestionFour()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 4");
        }
        if (checkQuestionFive()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 5");
        }
        if (checkQuestionSix()) {
            initialScore++;
        } else {
            wrongAnswersList.add("Question 6");
        }

        StringBuilder string = new StringBuilder();
        initialScore = 0;
        for (String s : wrongAnswersList) {
            string.append(s);
            string.append("\n");
            initialScore += 1;
        }

        int finalScore = 6 - initialScore;
        String scoreSummary = createScoreSummary(finalScore);
        Toast.makeText(this, "Answer Submitted! \nYou got " + finalScore + " out of 6 correctly.", Toast.LENGTH_LONG).show();

        displayMessage(scoreSummary);
        displayResult(string);
    }

    private String createScoreSummary(int score) {
        String scoreSummary = "You scored " + score + "/6\n";
        scoreSummary += "\nDo you want to try again? Click the RESTART button.\n";
        if (score < 6) {
            scoreSummary += "\nThe following questions were not answered correctly:";
        } else{
            scoreSummary += "\n\nGreat! You are a genius!";
        }
        return scoreSummary;
    }

    private boolean checkQuestionOne() {
        RadioGroup radioButtonQuestionOne = (RadioGroup) findViewById(R.id.radioGroupQuestionOne);
        return radioButtonQuestionOne.getCheckedRadioButtonId() == answerQuestionOne;
    }

    private boolean checkQuestionTwo() {
        RadioGroup radioButtonQuestionTwo = (RadioGroup) findViewById(R.id.radioGroupQuestionTwo);
        return radioButtonQuestionTwo.getCheckedRadioButtonId() == answerQuestionTwo;
    }

    private boolean checkQuestionThree() {
        CheckBox checkOption3a = (CheckBox) findViewById(R.id.option3_a);
        CheckBox checkOption3b = (CheckBox) findViewById(R.id.option3_b);
        CheckBox checkOption3c = (CheckBox) findViewById(R.id.option3_c);
        CheckBox checkOption3d = (CheckBox) findViewById(R.id.option3_d);
        return !checkOption3a.isChecked() && checkOption3b.isChecked() && checkOption3c.isChecked() && !checkOption3d.isChecked();
    }

    private boolean checkQuestionFour() {
        EditText answerFour = (EditText) findViewById(R.id.question4_answer);
        return answerFour.getText().toString().equalsIgnoreCase(answerQuestionFour);
    }

    private boolean checkQuestionFive() {
        EditText answerFive = (EditText) findViewById(R.id.question5_answer);
        return answerFive.getText().toString().equalsIgnoreCase(answerQuestionFive);
    }

    private boolean checkQuestionSix() {
        CheckBox checkOption6a = (CheckBox) findViewById(R.id.option6_a);
        CheckBox checkOption6b = (CheckBox) findViewById(R.id.option6_b);
        CheckBox checkOption6c = (CheckBox) findViewById(R.id.option6_c);
        CheckBox checkOption6d = (CheckBox) findViewById(R.id.option6_d);
        CheckBox checkOption6e = (CheckBox) findViewById(R.id.option6_e);
        CheckBox checkOption6f = (CheckBox) findViewById(R.id.option6_f);
        return !checkOption6a.isChecked() && checkOption6b.isChecked() && checkOption6c.isChecked() && checkOption6d.isChecked() && !checkOption6e.isChecked() && checkOption6f.isChecked();
    }

    private void displayMessage(String message) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(message);
    }

    private void displayResult(StringBuilder string) {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(string);
    }

    /*
        To reset the answers so that the user can start again on clicking on the restart button
     */

    public void resetScore(View view) {
        initialScore = 0;

        //Checking if question 3 checkboxes are checked and then uncheck them
        CheckBox checkOption3a = (CheckBox) findViewById(R.id.option3_a);
        CheckBox checkOption3b = (CheckBox) findViewById(R.id.option3_b);
        CheckBox checkOption3c = (CheckBox) findViewById(R.id.option3_c);
        CheckBox checkOption3d = (CheckBox) findViewById(R.id.option3_d);
        if (checkOption3a.isChecked()) {
            checkOption3a.setChecked(false);
        }
        if (checkOption3b.isChecked()) {
            checkOption3b.setChecked(false);
        }
        if (checkOption3c.isChecked()) {
            checkOption3c.setChecked(false);
        }
        if (checkOption3d.isChecked()) {
            checkOption3d.setChecked(false);
        }

        //Checking if question 6 checkboxes are checked and then uncheck them
        CheckBox checkOption6a = (CheckBox) findViewById(R.id.option6_a);
        CheckBox checkOption6b = (CheckBox) findViewById(R.id.option6_b);
        CheckBox checkOption6c = (CheckBox) findViewById(R.id.option6_c);
        CheckBox checkOption6d = (CheckBox) findViewById(R.id.option6_d);
        CheckBox checkOption6e = (CheckBox) findViewById(R.id.option6_e);
        CheckBox checkOption6f = (CheckBox) findViewById(R.id.option6_f);
        if (checkOption6a.isChecked()) {
            checkOption6a.setChecked(false);
        }
        if (checkOption6b.isChecked()) {
            checkOption6b.setChecked(false);
        }
        if (checkOption6c.isChecked()) {
            checkOption6c.setChecked(false);
        }
        if (checkOption6d.isChecked()) {
            checkOption6d.setChecked(false);
        }
        if (checkOption6e.isChecked()) {
            checkOption6e.setChecked(false);
        }
        if (checkOption6f.isChecked()) {
            checkOption6f.setChecked(false);
        }

        //To clear the radio buttons selected
        RadioGroup radioButtonQuestionOne = (RadioGroup) findViewById(R.id.radioGroupQuestionOne);
        radioButtonQuestionOne.clearCheck();

        RadioGroup radioButtonQuestionTwo = (RadioGroup) findViewById(R.id.radioGroupQuestionTwo);
        radioButtonQuestionTwo.clearCheck();

        //To clear the Edit text inputs
        EditText answerQuestionFour = (EditText) findViewById(R.id.question4_answer);
        answerQuestionFour.getText().clear();

        EditText answerQuestionFive = (EditText) findViewById(R.id.question5_answer);
        answerQuestionFive.getText().clear();

        //To clear the Score summary
        String resetMessage = getString(R.string.resetMessage);
        displayMessage(resetMessage);

        StringBuilder string = new StringBuilder();
        displayResult(string);
    }
}
