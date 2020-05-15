package dev.esgi.quiveutgagnerdesmillions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gameover extends AppCompatActivity {
    private Button back_to_menu, save_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        back_to_menu = findViewById(R.id.btn_back_to_menu);
        save_score = findViewById(R.id.btn_save_score);

        back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Gameover.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
