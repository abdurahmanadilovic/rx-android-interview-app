package com.example.abdu.rxjavainterview.data;

import com.example.abdu.rxjavainterview.components.CountDownInterviewComponent;
import com.example.abdu.rxjavainterview.components.FillerInterviewComponent;
import com.example.abdu.rxjavainterview.components.InterviewComponent;
import com.example.abdu.rxjavainterview.components.QuestionInterviewComponent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Abdurahman Adilovic on 3/20/18.
 */

public class Job {
    private Queue<InterviewComponent> interviewComponents;

    public Job() {

        InterviewComponent timerInterviewComponent = new CountDownInterviewComponent();
        InterviewComponent questionInterviewComponent =
                new QuestionInterviewComponent(new Question("Question 1"));
        InterviewComponent questionInterviewComponent2 =
                new QuestionInterviewComponent(new Question("Question 2"));
        InterviewComponent questionInterviewComponent3 =
                new QuestionInterviewComponent(new Question("Question 3"));

        interviewComponents = new LinkedList<>();
        interviewComponents.add(timerInterviewComponent);
        interviewComponents.add(questionInterviewComponent);
        interviewComponents.add(timerInterviewComponent);
        interviewComponents.add(questionInterviewComponent2);
        interviewComponents.add(timerInterviewComponent);
        interviewComponents.add(questionInterviewComponent3);
        interviewComponents.add(new FillerInterviewComponent());
    }

    public Queue<InterviewComponent> getComponents() {
        return interviewComponents;
    }
}
