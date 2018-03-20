package com.example.abdu.rxjavainterview.components;

import com.example.abdu.rxjavainterview.data.Question;
import com.example.abdu.rxjavainterview.events.EventQuestionBegin;
import com.example.abdu.rxjavainterview.events.EventQuestionTick;
import com.example.abdu.rxjavainterview.events.InterviewEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class QuestionInterviewComponent implements InterviewComponent {
    private Question question;

    public QuestionInterviewComponent(Question question) {
        this.question = question;
    }

    @Override
    public Observable<InterviewEvent> eventStream() {
        List<InterviewEvent> events = new ArrayList<>();
        events.add(new EventQuestionBegin(question));

        for (int i = 1; i < 6; i++) {
            events.add(new EventQuestionTick(String.valueOf(i)));
        }

        Observable<InterviewEvent> eventObservable = Observable.fromIterable(events)
                .zipWith(Observable.interval(1, TimeUnit.SECONDS),
                        (event, interval) -> event);

        return eventObservable;
    }
}
