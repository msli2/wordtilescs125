package com.example.mirandali.wordtiles;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button button_1;
    private Button button_2;
    private Button button_3;
    private TextToSpeech theVoice;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTts();

        button_1 = (Button) findViewById(R.id.button_level1);
        button_2 = (Button) findViewById(R.id.button_level2);
        button_3 = (Button) findViewById(R.id.button_level3);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Level 1");
                openLevel1();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Level 2");
                openLevel2();
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Level 3");
                openLevel3();
            }
        });

    }

    public void openLevel1() {
        Intent a = new Intent(MainActivity.this, level1game.class);
        startActivity(a);
    }

    public void openLevel2() {
        Intent b = new Intent(MainActivity.this, level2game.class);
        startActivity(b);
    }

    public void openLevel3() {
        Intent c = new Intent(MainActivity.this, level3game.class);
        startActivity(c);
    }

    // we used this speech api: https://developer.android.com/reference/android/speech/tts/TextToSpeech
    private void initializeTts() {
        theVoice = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (theVoice.getEngines().size() == 0) {
                    Toast.makeText(MainActivity.this, "Sorry, No TTS engine available", Toast.LENGTH_SHORT);
                } else {
                    theVoice.setLanguage(Locale.getDefault());
                    speak("Welcome to Word Tiles");
                }
            }
        });
    }


    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21) {
            theVoice.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            theVoice.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
    
}
