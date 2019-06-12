package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_hint extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
    private int mAnswerIsTrue;
    private TextView mHintTextView;
    private Button mShowHintButton;
    private Button mExitButton;

    public static Intent newIntent(Context packageContext, int answerIsTrue) {
        Intent intent = new Intent(packageContext, activity_hint.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public static boolean wasHintShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        mExitButton = (Button) findViewById(R.id.exit_button);
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.mAnswerIsTrue = getIntent().getIntExtra(EXTRA_ANSWER_IS_TRUE, 0);

        mHintTextView = (TextView) findViewById(R.id.hint_text_view);

        mShowHintButton = (Button) findViewById(R.id.show_hint_button);
        mShowHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHintTextView.setText(activity_hint.this.mAnswerIsTrue);
                setAnswerShownResult(true);
            }

        });

    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(-1, data);
    }
}
