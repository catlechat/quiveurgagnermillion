package dev.esgi.quiveutgagnerdesmillions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_start, btn_add, btn_class,btn_about,btn_quit;

    public static ArrayList<Question> questions = new ArrayList<>();
    public static Question q1 = new Question("What is the capital of France","Italy","Lyon",
            "Nantes","Paris");
    public static Question q2 = new Question("ESGI means","Ecole Superieure Gravité Informatique",
            "Ecole Suberbe Genie Informatique","Ecole Superieure Genie Intelectuel",
            "Ecole Superieure Genie Informatique");
    public static Question q3 = new Question("What is the name of this app creator ?","Luis","Pierre",
            "Miyuki","Ivan");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_add = findViewById(R.id.btn_add);
        btn_class = findViewById(R.id.btn_class);
        btn_about = findViewById(R.id.btn_about);
        btn_quit = findViewById(R.id.btn_quit);

        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getResources().getString(R.string.pop_title))
                        .setPositiveButton(getResources().getString(R.string.pop_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.pop_no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setCancelable(true)
                        .show();
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, About.class);
                startActivity(i);
                finish();
            }
        });


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions.clear();
                questions.add(q1);
                questions.add(q2);
                questions.add(q3);
                Intent i = new Intent(MainActivity.this, Game.class);
                startActivity(i);
                finish();
            }
        });
    }

}
