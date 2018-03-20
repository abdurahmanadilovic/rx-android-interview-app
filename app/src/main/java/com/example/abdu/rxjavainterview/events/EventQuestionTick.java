package com.example.abdu.rxjavainterview.events;

import com.example.abdu.rxjavainterview.ui.InterviewView;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class EventQuestionTick implements InterviewEvent {
    private String value;

    public EventQuestionTick(String value) {
        this.value = value;
    }

    @Override
    public void presentOnView(InterviewView view) {
        view.showQuestionTime(value);
    }
}
