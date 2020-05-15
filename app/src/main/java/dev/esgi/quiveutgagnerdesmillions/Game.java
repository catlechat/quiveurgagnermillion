package dev.esgi.quiveutgagnerdesmillions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {
    public final static int TIMER_TIME = 20;
    public final static int QUESTION_TOTAL = 3;
    private int index = TIMER_TIME;
    private Chronometer timer;
    private TextView question;
    private Button back_to, answer1, answer2, answer3, answerTrue;

    Question q1 = new Question("Do you know the way ?","Yes","No",
            "What?","I can show you the way");
    Question q2 = new Question("How high you are ?","five","1m85",
            "very","yes");
    Question q3 = new Question("What is my name ?","Leo","Paolo",
            "Maxime","Ivan");

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        timer = findViewById(R.id.chrono);
        question = findViewById(R.id.q);
        answer1 = findViewById(R.id.ans1);
        answer2 = findViewById(R.id.ans2);
        answer3 = findViewById(R.id.ans3);
        answerTrue = findViewById(R.id.ansTrue);
        back_to = findViewById(R.id.back_to_menu_warning);

        Random r = new Random();
        int i = r.nextInt(QUESTION_TOTAL);
        question.setText(questions.get(i).getAsk());
        answer1.setText(questions.get(i).getAns1());
        answer2.setText(questions.get(i).getAns2());
        answer3.setText(questions.get(i).getAns3());
        answerTrue.setText(questions.get(i).getAnsTrue());

        timer.start();
        timer.setCountDown(true);
        timer.setBase(SystemClock.elapsedRealtime() + (TIMER_TIME * 1000));
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(index !=0){
                    index -=1;
                    if(index <= 5){
                        timer.setTextColor(Color.RED);
                    }
                }else {
                    timer.stop();
                    Intent i = new Intent(Game.this, Gameover.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        back_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Game.this)
                        .setTitle(getResources().getString(R.string.realy_quit))
                        .setPositiveButton(getResources().getString(R.string.pop_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent j = new Intent(Game.this, MainActivity.class);
                                startActivity(j);
                                finish();
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.pop_no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

    }
}
