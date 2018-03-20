package com.example.abdu.rxjavainterview.ui;


import com.example.abdu.rxjavainterview.data.Question;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */
public interface InterviewView {

    void hideCountDownView();

    void showQuestionView(Question question);

    void hideQuestionViews();

    void showCountDownView();

    void showCountDownValue(String value);

    void showQuestionTime(String value);

    void showInterviewDone();

    void showError(String msg);
}
