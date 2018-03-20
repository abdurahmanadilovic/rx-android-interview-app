package com.example.abdu.rxjavainterview.components;

import com.example.abdu.rxjavainterview.events.EventInterviewDone;
import com.example.abdu.rxjavainterview.events.InterviewEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class FillerInterviewComponent implements InterviewComponent {

    @Override
    public Observable<InterviewEvent> eventStream() {
        return Observable.just(new EventInterviewDone()).zipWith
                (Observable.interval(1, TimeUnit.SECONDS), (event, interval) -> event);
    }
}
