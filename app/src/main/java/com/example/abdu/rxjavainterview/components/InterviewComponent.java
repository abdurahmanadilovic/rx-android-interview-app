package com.example.abdu.rxjavainterview.components;


import com.example.abdu.rxjavainterview.events.InterviewEvent;

import io.reactivex.Observable;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public interface InterviewComponent {
    Observable<InterviewEvent> eventStream();
}
