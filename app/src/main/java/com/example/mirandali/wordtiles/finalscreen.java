package com.example.mirandali.wordtiles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalscreen extends AppCompatActivity {
    private Button button_menu2;
    TextView text_final;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscreen);

        text_final = (TextView) findViewById(R.id.text_final);

        SharedPreferences b = getSharedPreferences("PREFS", 0);
        score = b.getInt("Final Score: ", 0);

        text_final.setText("Final Score: " + score);

        button_menu2 = (Button) findViewById(R.id.button_menu2);
        button_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
    }

    public void openMenu() {
        Intent a = new Intent(finalscreen.this, MainActivity.class);
        startActivity(a);
    }

}
