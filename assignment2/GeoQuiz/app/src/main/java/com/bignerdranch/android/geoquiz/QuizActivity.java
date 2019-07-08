package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private Button mPrevButton;
    private Button mHintButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true, false, false, false, R.string.hint_australia),
            new Question(R.string.question_oceans, true, false, false, false, R.string.hint_oceans),
            new Question(R.string.question_mideast, false, false, false, false, R.string.hint_mideast),
            new Question(R.string.question_africa, false, false, false, false, R.string.hint_africa),
            new Question(R.string.question_americas, true, false, false, false, R.string.hint_americas),
            new Question(R.string.question_asia, true, false, false, false, R.string.hint_asia),
    };

    private int mCurrentIndex = 0;
    private boolean mIsCheater;
    private int mTotalMarks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mkTag", "onClick: mCurrentIndex: " + mCurrentIndex + ", mQuestioonBank.length: " + mQuestionBank.length);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                Log.d("mkTag", "onClick: mCurrentIndex: " + mCurrentIndex + ", mQuestioonBank.length: " + mQuestionBank.length);
                mIsCheater = false;
                updateQuestion();
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex - 1);
                if (mCurrentIndex == -1)
                    mCurrentIndex = 5;
                updateQuestion();

            }
        });

//        mCheatButton = (Button) findViewById(R.id.cheat_button);
//        mCheatButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
//                Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
//                startActivityForResult(intent, REQUEST_CODE_CHEAT);
//            }
//        });
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.this.startActivityForResult
                        (CheatActivity.newIntent
                                (QuizActivity.this, QuizActivity.this.mQuestionBank
                                        [QuizActivity.this.mCurrentIndex].isAnswerTrue()), 0);

            }
        });

        mHintButton = (Button) findViewById(R.id.hint_button);
        mHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.this.startActivityForResult
                        (activity_hint.newIntent
                                (QuizActivity.this, QuizActivity.this.mQuestionBank
                                        [QuizActivity.this.mCurrentIndex].getHintId()), 1);

            }
        });


        updateQuestion();
    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != Activity.RESULT_OK) {
//            return;
//        }
//
//        if (requestCode == REQUEST_CODE_CHEAT) {
//            if (data == null) {
//                return;
//            }
//            mIsCheater = CheatActivity.wasAnswerShown(data);
//        }
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            if (requestCode == 0) {
                if (data != null) {
                    this.mQuestionBank[this.mCurrentIndex].setUserCheated(CheatActivity.wasAnswerShown(data));
                } else {
                    return;
                }
            }
            if (requestCode == 1 && data != null) {
                this.mQuestionBank[this.mCurrentIndex].setHintGiven(activity_hint.wasHintShown(data));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }


    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = this.mQuestionBank[this.mCurrentIndex].isAnswerTrue();

        if (this.mQuestionBank[this.mCurrentIndex].isComplete()) {
            Toast.makeText(getApplicationContext(), "Question Completed!", Toast.LENGTH_SHORT).show();
        } else if (this.mQuestionBank[this.mCurrentIndex].didUserCheat()) {
            Toast.makeText(getApplicationContext(), "Cheating is Wrong!", 0).show();
        } else {
            this.mQuestionBank[this.mCurrentIndex].setCompleted(true);
            TextView textView = (TextView) findViewById(R.id.questions_completed);

            int temp = Integer.parseInt(textView.getText().toString()) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(temp);
            textView.setText(stringBuilder.toString());


            if (userPressedTrue == answerIsTrue && this.mQuestionBank[this.mCurrentIndex].wasHintGiven()) {
                this.mTotalMarks++;
                Toast.makeText(getApplicationContext(), "+1 Marks", Toast.LENGTH_SHORT).show();
            } else if (userPressedTrue == answerIsTrue && !this.mQuestionBank[this.mCurrentIndex].wasHintGiven()) {
                this.mTotalMarks += 2;
                Toast.makeText(getApplicationContext(), "+2 Marks", Toast.LENGTH_SHORT).show();
            } else if (userPressedTrue != answerIsTrue && this.mQuestionBank[this.mCurrentIndex].wasHintGiven()) {
                this.mTotalMarks -= 2;
                Toast.makeText(getApplicationContext(), "-2 Marks", Toast.LENGTH_SHORT).show();
            } else if (!(userPressedTrue == answerIsTrue || this.mQuestionBank[this.mCurrentIndex].wasHintGiven())) {
                this.mTotalMarks--;
                Toast.makeText(getApplicationContext(), "-1 Marks", Toast.LENGTH_SHORT).show();
            } else if (!(userPressedTrue == answerIsTrue) || this.mQuestionBank[this.mCurrentIndex].didUserCheat()) {
                this.mTotalMarks -= 2;
                Toast.makeText(getApplicationContext(), "-2 Marks", Toast.LENGTH_SHORT).show();
            }
            textView = (TextView) findViewById(R.id.total_marks);
            textView.setText("TOTAL MARKS: " + mTotalMarks);
        }
    }
}
