package com.example.abdu.rxjavainterview.ui;

import com.example.abdu.rxjavainterview.components.InterviewComponent;
import com.example.abdu.rxjavainterview.data.Job;
import com.example.abdu.rxjavainterview.events.InterviewEvent;

import java.util.Queue;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class InterviewPresenterImplementation implements InterviewPresenter {
    private InterviewView view;
    private Job job;
    private Disposable disposable;

    public InterviewPresenterImplementation(Job job) {
        this.job = job;
    }

    @Override
    public void startPresenting(InterviewView view) {
        this.view = view;
        poolEvents(this.job.getComponents());
    }

    @Override
    public void stopPresenting() {
        if (this.disposable != null) {
            this.disposable.dispose();
            this.view = null;
        }
    }

    void poolEvents(Queue<InterviewComponent> interviewComponents) {
        if (interviewComponents.peek() == null) {
            return;
        }

        interviewComponents.poll().
                eventStream().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<InterviewEvent>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(InterviewEvent event) {
                        event.presentOnView(view);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        poolEvents(interviewComponents);
                    }
                });
    }
}
