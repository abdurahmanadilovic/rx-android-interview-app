package com.example.abdu.rxjavainterview.events;

import com.example.abdu.rxjavainterview.ui.InterviewView;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */
public class EventInterviewDone implements InterviewEvent {

    @Override
    public void presentOnView(InterviewView view) {
        view.hideQuestionViews();
        view.showCountDownView();
        view.showInterviewDone();
    }
}
