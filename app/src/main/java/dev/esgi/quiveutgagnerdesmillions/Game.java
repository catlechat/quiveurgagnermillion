package dev.esgi.quiveutgagnerdesmillions;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    private final static int TIMER_TIME = 20;
    private int index = TIMER_TIME;
    private Chronometer timer;
    private TextView question;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timer = findViewById(R.id.chrono);
        question = findViewById(R.id.q);


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
                    question.setText("Game Over");
                }
            }
        });

    }
}
