package com.example.android.eduhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.eduhub.MainActivity.loginID;

public class addmath1MCQ extends AppCompatActivity {

    // creating a QuestionLibrary object
    private QuestionLibrary ql = new QuestionLibrary();
    private String[] mq = ql.mQuestionsAddmath1;
    private String[][] mc = ql.mChoicesAddmath1;
    private String[] mca = ql.mCorrectAnswersAddmath1;

    private TextView mScoreView; // view for current total score
    private TextView mQuestionView; // current question to answer
    private Button mButtonChoice1; // MCQ1 for mQuestionView
    private Button mButtonChoice2; // MCQ2 for mQuestionView
    private Button mButtonChoice3; // MCQ3 for mQuestionView

    private String mAnswer; // correct answer for question in mQuestionView
    private int mScore = 0; // current total score
    private int mQuestionNumber = 0; // current question number
    ProgressDbHelper progressDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_view);
        // setup screen for the first question with 3 alternatives to answer
        // connecting the variables to the views in the XML
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        Button quit = findViewById(R.id.quit);
        progressDb = new ProgressDbHelper(this);

        updateQuestion();

        // Start of Button Listener for Button1
        // handle clicks when the button being pressed
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if the text of the button = answer
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(addmath1MCQ.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addmath1MCQ.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        // Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(addmath1MCQ.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addmath1MCQ.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        // End of Button Listener for Button2

        // Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(addmath1MCQ.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addmath1MCQ.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        // End of Button Listener for Button3

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(addmath1MCQ.this, ContentMainActivity.class);
                startActivity(backToMain);
            }
        });
    }

    // if answer the question wrongly only update question X update score
    private void updateQuestion() {
        if (mQuestionNumber == 4) {
            Progress_Achievement progress = progressDb.getProgress(loginID);
            progress.setAddmaths1(mScore);
            if (progress.getFirst_achievement() == 0) {
                progress.setFirst_achievement(1);
            }
            if (mScore == 4) {
                progress.setSecond_achievement(1);
            }
            progressDb.updateProgress(progress);
            Intent backToMain = new Intent(addmath1MCQ.this, ContentMainActivity.class);
            startActivity(backToMain);
        } else {
            mQuestionView.setText(ql.getQuestion(mQuestionNumber, mq));
            mButtonChoice1.setText(ql.getChoice1(mQuestionNumber, mc));
            mButtonChoice2.setText(ql.getChoice2(mQuestionNumber, mc));
            mButtonChoice3.setText(ql.getChoice3(mQuestionNumber, mc));

            mAnswer = ql.getCorrectAnswer(mQuestionNumber, mca );
            mQuestionNumber++;
        }

    }

    // if answered correctly update score
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }


}
