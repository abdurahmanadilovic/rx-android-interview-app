package com.example.abdu.rxjavainterview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.abdu.rxjavainterview.R;
import com.example.abdu.rxjavainterview.data.JobRepository;
import com.example.abdu.rxjavainterview.data.Question;

public class MainActivity extends AppCompatActivity implements InterviewView {

    private TextView questionName;
    private TextView questionTick;
    private TextView countDown;
    private InterviewPresenterImplementation presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionName = findViewById(R.id.questionName);
        questionTick = findViewById(R.id.questionTick);
        countDown = findViewById(R.id.countDown);

        presenter = new
                InterviewPresenterImplementation(JobRepository.getRandomJob());
        presenter.startPresenting(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stopPresenting();
    }

    @Override
    public void hideCountDownView() {
        countDown.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showQuestionView(Question question) {
        questionName.setVisibility(View.VISIBLE);
        questionTick.setVisibility(View.VISIBLE);
        questionName.setText(question.getName());
        questionTick.setText("0");
    }

    @Override
    public void hideQuestionViews() {
        questionName.setVisibility(View.INVISIBLE);
        questionTick.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCountDownView() {
        countDown.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCountDownValue(String value) {
        countDown.setText(value);
    }

    @Override
    public void showQuestionTime(String value) {
        questionTick.setText(value);
    }

    @Override
    public void showInterviewDone() {
        countDown.setText("Done");
    }

    @Override
    public void showError(String msg) {

    }
}
