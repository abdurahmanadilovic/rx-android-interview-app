package com.example.abdu.rxjavainterview.events;

import com.example.abdu.rxjavainterview.data.Question;
import com.example.abdu.rxjavainterview.ui.InterviewView;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class EventQuestionBegin implements InterviewEvent {
    private Question question;

    public EventQuestionBegin(Question question) {
        this.question = question;
    }

    @Override
    public void presentOnView(InterviewView view) {
        view.hideCountDownView();
        view.showQuestionView(question);
    }
}
