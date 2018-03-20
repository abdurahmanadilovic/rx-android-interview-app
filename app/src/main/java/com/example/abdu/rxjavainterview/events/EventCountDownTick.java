package com.example.abdu.rxjavainterview.events;


import com.example.abdu.rxjavainterview.ui.InterviewView;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class EventCountDownTick implements InterviewEvent {
    private String value;

    public EventCountDownTick(String value) {
        this.value = value;
    }

    @Override
    public void presentOnView(InterviewView view) {
        view.showCountDownValue(value);
    }
}
