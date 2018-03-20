package com.example.abdu.rxjavainterview.components;

import com.example.abdu.rxjavainterview.events.EventCountDownBegun;
import com.example.abdu.rxjavainterview.events.EventCountDownTick;
import com.example.abdu.rxjavainterview.events.InterviewEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class CountDownInterviewComponent implements InterviewComponent {
    @Override
    public Observable<InterviewEvent> eventStream() {
        List<InterviewEvent> events = new ArrayList<>();
        events.add(new EventCountDownBegun("3"));
        events.add(new EventCountDownTick("2"));
        events.add(new EventCountDownTick("1"));

        Observable<InterviewEvent> eventObservable = Observable.fromIterable(events)
                .zipWith(Observable.interval(1, TimeUnit.SECONDS),
                        (event, interval) -> event);

        return eventObservable;
    }
}
