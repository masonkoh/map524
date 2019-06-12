package com.bignerdranch.android.geoquiz;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mCompleted;
    private boolean mHintGiven;
    private int mHintId;
    private boolean mUserCheated;

    public Question(int textResId, boolean answerTrue, boolean userCheated, boolean hintGiven, boolean completed, int hintId) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        this.mUserCheated = userCheated;
        this.mCompleted = completed;
        this.mHintGiven = hintGiven;
        this.mHintId = hintId;
    }
    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean didUserCheat()
    {
        return this.mUserCheated;
    }

    public void setUserCheated (boolean userCheated)
    {
        this.mUserCheated = userCheated;
    }

    public boolean wasHintGiven(){
        return this.mHintGiven;
    }

    public void setHintGiven(boolean hintGiven) {
        this.mHintGiven = hintGiven;
    }

    public boolean isComplete() {
        return this.mCompleted;
    }

    public void setCompleted(boolean completed) {
        this.mCompleted = completed;
    }

    public int getHintId() {
        return this.mHintId;
    }

    public void setHintId(int textHintId) {
        this.mHintId = textHintId;
    }



}
