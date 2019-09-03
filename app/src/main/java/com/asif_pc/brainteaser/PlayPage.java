package com.asif_pc.brainteaser;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class PlayPage extends Activity {
    private static final long COUNTDOWN_IN_MILLIS=40000;
    TextView ques,textViewCountDown;
    RadioGroup rg;
    RadioButton op1,op2,op3,op4;
    Button next;
    MediaPlayer player;
    private ColorStateList textColorDefaultRb;
    private ColorStateList getTextColorDefaultcd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private List<Question> questionList;
    private int questionCounter;
    private Question currentQuestion;
    private int score=0;
    private int lives=4;
    private boolean answered;
    private long backPressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_page);
        ques=findViewById(R.id.textView_question);
        rg=findViewById(R.id.radioGroup);
        op1=findViewById(R.id.radioButton1);
        op2=findViewById(R.id.radioButton2);
        op3=findViewById(R.id.radioButton3);
        op4=findViewById(R.id.radioButton4);
        next=findViewById(R.id.button_next);
        player=MediaPlayer.create(this,R.raw.count_down_timer);
        textViewCountDown=findViewById(R.id.textView_timer);
        textColorDefaultRb=op1.getTextColors();
        getTextColorDefaultcd=textViewCountDown.getTextColors();
        QuizDBHelper dbHelper=new QuizDBHelper(this);
        questionList=dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        showNextQuestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered){
                    if(op1.isChecked()||op2.isChecked()||op3.isChecked()||op4.isChecked()){

                        checkAnswer();
                    }else {

                        Toast.makeText(PlayPage.this,"Please select an answer",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });
    }


    private void showNextQuestion(){
        op1.setTextColor(textColorDefaultRb);
        op2.setTextColor(textColorDefaultRb);
        op3.setTextColor(textColorDefaultRb);
        op4.setTextColor(textColorDefaultRb);
        textViewCountDown.setTextColor(getTextColorDefaultcd);
        rg.clearCheck();
        if (questionCounter<10){
            currentQuestion=questionList.get(questionCounter);
            ques.setText(currentQuestion.getQuestion());
            op1.setText(currentQuestion.getOption1());
            op2.setText(currentQuestion.getOption2());
            op3.setText(currentQuestion.getOption3());
            op4.setText(currentQuestion.getOption4());

            questionCounter++;
            answered=false;
            next.setText("Confirm");
            timeLeftInMillis=COUNTDOWN_IN_MILLIS;
            startCountDown();
        }else {
            finishQuiz();
        }
    }
    private void startCountDown(){
        countDownTimer=new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis=l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis=0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    private void updateCountDownText(){
        int minutes=(int)(timeLeftInMillis/1000)/60;
        int seconds=(int)(timeLeftInMillis/1000)%60;

        String timeFormated=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormated);
        if (timeLeftInMillis<10000) {
            if(!player.isLooping()){
                player.start();
            }
            textViewCountDown.setTextColor(Color.RED);
            textViewCountDown.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(player.isPlaying()){
                        player.stop();
                    }
                }
            },10000);
        }
    }


    private void checkAnswer(){
        answered=true;
        int answerNr=0;
        countDownTimer.cancel();
        try {
            RadioButton rbSelected = findViewById(rg.getCheckedRadioButtonId());
             answerNr = rg.indexOfChild(rbSelected) + 1;
        }catch (Exception e){}
        if (answerNr==currentQuestion.getAnswerNr()){

            score+=4;
        }
        else{
            if(lives==0){
                finishQuiz();
            }
            score--;
            lives--;

        }
        showSolution();

    }
    private void showSolution(){
        try {
            int id = rg.getCheckedRadioButtonId();
            RadioButton selected_op = findViewById(id);
            selected_op.setTextColor(Color.RED);
        }catch (Exception e){}
        switch (currentQuestion.getAnswerNr()){
            case 1:
                op1.setTextColor(Color.GREEN);
                ques.setText("Option 1 is Correct");
                break;
            case 2:
                op2.setTextColor(Color.GREEN);
                ques.setText("Option 2 is Correct");
                break;
            case 3:
                op3.setTextColor(Color.GREEN);
                ques.setText("Option 3 is Correct");
                break;
            case 4:
                op4.setTextColor(Color.GREEN);
                ques.setText("Option 4 is Correct");
                break;
        }
        if (questionCounter<10){
            next.setText("Next");
        }
        else {
            next.setText("Finish");
        }
    }

    private void finishQuiz(){
        countDownTimer.cancel();
        Intent intent1=new Intent(PlayPage.this,Score.class);
        intent1.putExtra("highscore",""+score);

        startActivity(intent1);
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime+2000>System.currentTimeMillis()){
            finishQuiz();
        }
        else {
            Toast.makeText(this,"Press back again to finish",Toast.LENGTH_SHORT).show();
        }
        backPressedTime=System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}
