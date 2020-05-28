package dev.esgi.quiveutgagnerdesmillions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gameover extends AppCompatActivity {
    private Button back_to_menu, save_score;
    private TextView text, winText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        back_to_menu = findViewById(R.id.btn_back_to_menu);
        save_score = findViewById(R.id.btn_save_score);
        text = findViewById(R.id.scoreText);
        winText = findViewById(R.id.gameoverText);

        text.setText("score : "+MainActivity.score);

        Boolean status = false;
        try {
             status = getIntent().getExtras().getBoolean("win");
        }catch (NullPointerException e){
        }
        if (status){
            winText.setText("You WIN !");
        }else{
            winText.setText("GAME OVER");
        }

        back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.score = 0;
                Intent i = new Intent(Gameover.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
