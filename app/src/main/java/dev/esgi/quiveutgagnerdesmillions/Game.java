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

import java.util.Random;

public class Game extends AppCompatActivity {
    public final static int TIMER_TIME = 21;
    public final static int ANSWERS_TOTAL = 4;
    private int index = TIMER_TIME;
    private Chronometer timer;
    private TextView question;
    private Button back_to, answer1, answer2, answer3, answerTrue;
    //
    int i;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timer = findViewById(R.id.chrono);
        question = findViewById(R.id.q);
        back_to = findViewById(R.id.back_to_menu_warning);


        Random r = new Random();
        i = r.nextInt(MainActivity.questions.size());
        question.setText(MainActivity.questions.get(i).getAsk());

        int give = r.nextInt(ANSWERS_TOTAL);
        switch(give) {
            case 0:
                // the answer is top left
                answerTrue = findViewById(R.id.ans1);
                answer2 = findViewById(R.id.ans2);
                answer3 = findViewById(R.id.ans3);
                answer1 = findViewById(R.id.ansTrue);
                break;
            case 1:
                // the answer is top right
                answer1 = findViewById(R.id.ans1);
                answerTrue = findViewById(R.id.ans2);
                answer3 = findViewById(R.id.ans3);
                answer2 = findViewById(R.id.ansTrue);
                break;
            case 2:
                // the answer is bottom left
                answer1 = findViewById(R.id.ans1);
                answer2 = findViewById(R.id.ans2);
                answerTrue = findViewById(R.id.ans3);
                answer3 = findViewById(R.id.ansTrue);
                break;
            case 3:
                // the answer is bottom right
                answer1 = findViewById(R.id.ans1);
                answer2 = findViewById(R.id.ans2);
                answer3 = findViewById(R.id.ans3);
                answerTrue = findViewById(R.id.ansTrue);
                break;
        }
        answerTrue.setText(MainActivity.questions.get(i).getAnsTrue());
        answer1.setText(MainActivity.questions.get(i).getAns1());
        answer2.setText(MainActivity.questions.get(i).getAns2());
        answer3.setText(MainActivity.questions.get(i).getAns3());

        /*
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(answer1);
        buttons.add(answer2);
        buttons.add(answer3);
        buttons.add(answerTrue);
        int j = r.nextInt(ANSWERS_TOTAL);
        if(j==0){
            buttons.get(j).setText(MainActivity.questions.get(i).getAnsTrue());
            buttons.get(j+1).setText(MainActivity.questions.get(i).getAns1());
            buttons.get(j+2).setText(MainActivity.questions.get(i).getAns2());
            buttons.get(j+3).setText(MainActivity.questions.get(i).getAns3());
        }else if(j==1){
            buttons.get(j-1).setText(MainActivity.questions.get(i).getAns3());
            buttons.get(j).setText(MainActivity.questions.get(i).getAnsTrue());
            buttons.get(j+1).setText(MainActivity.questions.get(i).getAns1());
            buttons.get(j+2).setText(MainActivity.questions.get(i).getAns2());
        }else if(j==2){
            buttons.get(j-2).setText(MainActivity.questions.get(i).getAns3());
            buttons.get(j-1).setText(MainActivity.questions.get(i).getAns2());
            buttons.get(j).setText(MainActivity.questions.get(i).getAnsTrue());
            buttons.get(j+1).setText(MainActivity.questions.get(i).getAns1());
        }else{
            buttons.get(j-3).setText(MainActivity.questions.get(i).getAns3());
            buttons.get(j-2).setText(MainActivity.questions.get(i).getAns2());
            buttons.get(j-1).setText(MainActivity.questions.get(i).getAns2());
            buttons.get(j).setText(MainActivity.questions.get(i).getAnsTrue());
        }
        */



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


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setTextColor(Color.RED);
                Intent i = new Intent(Game.this, Gameover.class);
                startActivity(i);
                finish();
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer2.setTextColor(Color.RED);
                Intent i = new Intent(Game.this, Gameover.class);
                startActivity(i);
                finish();
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer3.setTextColor(Color.RED);
                Intent i = new Intent(Game.this, Gameover.class);
                startActivity(i);
                finish();
            }
        });
        answerTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerTrue.setTextColor(Color.GREEN);
                if(!MainActivity.questions.isEmpty()) {
                    //retirer la question en cours
                    MainActivity.questions.remove(i);
                    if (MainActivity.questions.isEmpty()) {
                        Intent j = new Intent(Game.this, Gameover.class);
                        startActivity(j);
                        finish();
                    }else{
                        Intent k = new Intent(Game.this, Game.class);
                        startActivity(k);
                        finish();
                    }
                }
            }
        });
    }
}
