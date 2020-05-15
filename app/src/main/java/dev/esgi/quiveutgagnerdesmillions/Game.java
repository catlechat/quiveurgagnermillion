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

public class Game extends AppCompatActivity {
    private final static int TIMER_TIME = 20;
    private int index = TIMER_TIME;
    private Chronometer timer;
    private TextView question;
    private Button back_to;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timer = findViewById(R.id.chrono);
        question = findViewById(R.id.q);
        back_to = findViewById(R.id.back_to_menu_warning);


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
