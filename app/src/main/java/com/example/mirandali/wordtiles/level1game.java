package com.example.mirandali.wordtiles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class level1game extends AppCompatActivity {

    private TextToSpeech theVoice;
    private View level1Top;
    private View level1Middle;
    private View level1Bottom;
    private Button button1_1;
    private Button button1_2;
    private Button button1_3;
    private Button button1_4;
    private Button button1_5;
    private Button button1_6;
    private Button button1_7;
    private Button button1_8;
    private Button button1_9;
    private Button button1_10;
    private Button button1_11;
    private Button button1_12;
    private Button button1_13;
    private Button button1_14;
    private Button button1_15;
    private Button button1_16;
    private ImageButton button_refresh;
    private Button button_menu;
    private Button button_enter;
    private CountDownTimer countDownTimer;
    private TextView text_time;

    private ArrayList<String> word;
    private int score;
    private TextView text_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1game);
        initializeTts();


        level1Top = (View) findViewById(R.id.include1_1);
        level1Middle = (View) findViewById(R.id.include1_2);
        level1Bottom = (View) findViewById(R.id.include1_3);
        word = new ArrayList<String>();


        button1_1 = (Button) level1Middle.findViewById(R.id.button1_1);
        button1_2 = (Button) level1Middle.findViewById(R.id.button1_2);
        button1_3 = (Button) level1Middle.findViewById(R.id.button1_3);
        button1_4 = (Button) level1Middle.findViewById(R.id.button1_4);
        button1_5 = (Button) level1Middle.findViewById(R.id.button1_5);
        button1_6 = (Button) level1Middle.findViewById(R.id.button1_6);
        button1_7 = (Button) level1Middle.findViewById(R.id.button1_7);
        button1_8 = (Button) level1Middle.findViewById(R.id.button1_8);
        button1_9 = (Button) level1Middle.findViewById(R.id.button1_9);
        button1_10 = (Button) level1Middle.findViewById(R.id.button1_10);
        button1_11 = (Button) level1Middle.findViewById(R.id.button1_11);
        button1_12 = (Button) level1Middle.findViewById(R.id.button1_12);
        button1_13 = (Button) level1Middle.findViewById(R.id.button1_13);
        button1_14 = (Button) level1Middle.findViewById(R.id.button1_14);
        button1_15 = (Button) level1Middle.findViewById(R.id.button1_15);
        button1_16 = (Button) level1Middle.findViewById(R.id.button1_16);

        button_refresh = (ImageButton) level1Top.findViewById(R.id.button_refresh);
        button_menu = (Button) level1Bottom.findViewById(R.id.button_menu);
        button_enter = (Button) level1Bottom.findViewById(R.id.button_enter);
        text_time = (TextView) level1Top.findViewById(R.id.text_time);

        score = 0;
        text_score = (TextView) level1Top.findViewById(R.id.text_score);

        start();

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
                cancel();
            }
        });

        // showing score on final page was from this youtube video: - https://www.youtube.com/watch?v=_cV7cgQFDo0
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public String toString() {
                return "$classname{}";
            }

            @Override
            public void onClick(View v) {
                String speakWord  = TextUtils.join("", word);
                word.clear();
                TextView display_text = (TextView) level1Bottom.findViewById(R.id.text_display);
                display_text.setText(speakWord);
                speak(speakWord);
                if (checkWord(speakWord)) {
                    score += speakWord.length() * speakWord.length();
                    text_score.setText("Score: " + score);
                }
            }
        });


        TextView button1_1Text = (TextView) button1_1;
        String text1 = String.valueOf(randomLetterVowels());
        button1_1Text.setText(text1);
        TextView button1_2Text = (TextView) button1_2;
        String text2 = String.valueOf(randomLetter());
        button1_2Text.setText(text2);
        TextView button1_3Text = (TextView) button1_3;
        String text3 = String.valueOf(randomLetter());
        button1_3Text.setText(text3);
        TextView button1_4Text = (TextView) button1_4;
        String text4 = String.valueOf(randomLetter());
        button1_4Text.setText(text4);
        TextView button1_5Text = (TextView) button1_5;
        String text5 = String.valueOf(randomLetter());
        button1_5Text.setText(text5);
        TextView button1_6Text = (TextView) button1_6;
        String text6 = String.valueOf(randomLetterVowels());
        button1_6Text.setText(text6);
        TextView button1_7Text = (TextView) button1_7;
        String text7 = String.valueOf(randomLetter());
        button1_7Text.setText(text7);
        TextView button1_8Text = (TextView) button1_8;
        String text8 = String.valueOf(randomLetter());
        button1_8Text.setText(text8);
        TextView button1_9Text = (TextView) button1_9;
        String text9 = String.valueOf(randomLetter());
        button1_9Text.setText(text9);
        TextView button1_10Text = (TextView) button1_10;
        String text10 = String.valueOf(randomLetter());
        button1_10Text.setText(text10);
        TextView button1_11Text = (TextView) button1_11;
        String text11 = String.valueOf(randomLetterVowels());
        button1_11Text.setText(text11);
        TextView button1_12Text = (TextView) button1_12;
        String text12 = String.valueOf(randomLetter());
        button1_12Text.setText(text12);
        TextView button1_13Text = (TextView) button1_13;
        String text13 = String.valueOf(randomLetter());
        button1_13Text.setText(text13);
        TextView button1_14Text = (TextView) button1_14;
        String text14 = String.valueOf(randomLetter());
        button1_14Text.setText(text14);
        TextView button1_15Text = (TextView) button1_15;
        String text15 = String.valueOf(randomLetter());
        button1_15Text.setText(text15);
        TextView button1_16Text = (TextView) button1_16;
        String text16 = String.valueOf(randomLetterVowels());
        button1_16Text.setText(text16);

        button1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_1Text = (TextView) button1_1;
                word.add(button1_1Text.getText().toString());
                String text1 = String.valueOf(randomLetterVowels());
                button1_1Text.setText(text1);
            }
        });
        button1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_2Text = (TextView) button1_2;
                word.add(button1_2Text.getText().toString());
                String text2 = String.valueOf(randomLetter());
                button1_2Text.setText(text2);
            }
        });
        button1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_3Text = (TextView) button1_3;
                word.add(button1_3Text.getText().toString());
                String text3 = String.valueOf(randomLetter());
                button1_3Text.setText(text3);
            }
        });
        button1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_4Text = (TextView) button1_4;
                word.add(button1_4Text.getText().toString());
                String text4 = String.valueOf(randomLetter());
                button1_4Text.setText(text4);
            }
        });
        button1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_5Text = (TextView) button1_5;
                word.add(button1_5Text.getText().toString());
                String text5 = String.valueOf(randomLetter());
                button1_5Text.setText(text5);
            }
        });
        button1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_6Text = (TextView) button1_6;
                word.add(button1_6Text.getText().toString());
                String text6 = String.valueOf(randomLetterVowels());
                button1_6Text.setText(text6);
            }
        });
        button1_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_7Text = (TextView) button1_7;
                word.add(button1_7Text.getText().toString());
                String text7 = String.valueOf(randomLetter());
                button1_7Text.setText(text7);
            }
        });
        button1_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_8Text = (TextView) button1_8;
                word.add(button1_8Text.getText().toString());
                String text8 = String.valueOf(randomLetter());
                button1_8Text.setText(text8);
            }
        });
        button1_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_9Text = (TextView) button1_9;
                word.add(button1_9Text.getText().toString());
                String text9 = String.valueOf(randomLetter());
                button1_9Text.setText(text9);
            }
        });
        button1_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_10Text = (TextView) button1_10;
                word.add(button1_10Text.getText().toString());
                String text10 = String.valueOf(randomLetter());
                button1_10Text.setText(text10);
            }
        });
        button1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_11Text = (TextView) button1_11;
                word.add(button1_11Text.getText().toString());
                String text11 = String.valueOf(randomLetterVowels());
                button1_11Text.setText(text11);
            }
        });
        button1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_12Text = (TextView) button1_12;
                word.add(button1_12Text.getText().toString());
                String text12 = String.valueOf(randomLetter());
                button1_12Text.setText(text12);
            }
        });
        button1_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_13Text = (TextView) button1_13;
                word.add(button1_13Text.getText().toString());
                String text13 = String.valueOf(randomLetter());
                button1_13Text.setText(text13);
            }
        });
        button1_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_14Text = (TextView) button1_14;
                word.add(button1_14Text.getText().toString());
                String text14 = String.valueOf(randomLetter());
                button1_14Text.setText(text14);
            }
        });
        button1_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_15Text = (TextView) button1_15;
                word.add(button1_15Text.getText().toString());
                String text15 = String.valueOf(randomLetter());
                button1_15Text.setText(text15);
            }
        });
        button1_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_16Text = (TextView) button1_16;
                word.add(button1_16Text.getText().toString());
                String text16 = String.valueOf(randomLetterVowels());
                button1_16Text.setText(text16);
            }
        });



        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Refresh Game");
                TextView button1_1Text = (TextView) button1_1;
                String text1 = String.valueOf(randomLetterVowels());
                button1_1Text.setText(text1);
                TextView button1_2Text = (TextView) button1_2;
                String text2 = String.valueOf(randomLetter());
                button1_2Text.setText(text2);
                TextView button1_3Text = (TextView) button1_3;
                String text3 = String.valueOf(randomLetter());
                button1_3Text.setText(text3);
                TextView button1_4Text = (TextView) button1_4;
                String text4 = String.valueOf(randomLetter());
                button1_4Text.setText(text4);
                TextView button1_5Text = (TextView) button1_5;
                String text5 = String.valueOf(randomLetter());
                button1_5Text.setText(text5);
                TextView button1_6Text = (TextView) button1_6;
                String text6 = String.valueOf(randomLetterVowels());
                button1_6Text.setText(text6);
                TextView button1_7Text = (TextView) button1_7;
                String text7 = String.valueOf(randomLetter());
                button1_7Text.setText(text7);
                TextView button1_8Text = (TextView) button1_8;
                String text8 = String.valueOf(randomLetter());
                button1_8Text.setText(text8);
                TextView button1_9Text = (TextView) button1_9;
                String text9 = String.valueOf(randomLetter());
                button1_9Text.setText(text9);
                TextView button1_10Text = (TextView) button1_10;
                String text10 = String.valueOf(randomLetter());
                button1_10Text.setText(text10);
                TextView button1_11Text = (TextView) button1_11;
                String text11 = String.valueOf(randomLetterVowels());
                button1_11Text.setText(text11);
                TextView button1_12Text = (TextView) button1_12;
                String text12 = String.valueOf(randomLetter());
                button1_12Text.setText(text12);
                TextView button1_13Text = (TextView) button1_13;
                String text13 = String.valueOf(randomLetter());
                button1_13Text.setText(text13);
                TextView button1_14Text = (TextView) button1_14;
                String text14 = String.valueOf(randomLetter());
                button1_14Text.setText(text14);
                TextView button1_15Text = (TextView) button1_15;
                String text15 = String.valueOf(randomLetter());
                button1_15Text.setText(text15);
                TextView button1_16Text = (TextView) button1_16;
                String text16 = String.valueOf(randomLetterVowels());
                button1_16Text.setText(text16);
            }
        });
    }
    public void openMenu() {
        Intent a = new Intent(level1game.this, MainActivity.class);
        startActivity(a);
    }

    public char randomLetter() {
        int number = new Random().nextInt(38);
        String total = "bcdfghjklmnpqrstvwxyzbcdfghjklmnprstwy";
        return total.charAt(number);
    }

    public char randomLetterVowels() {
        int number = new Random().nextInt(9);
        String total = "aeiouaeio";
        return total.charAt(number);
    }

    WordValidator check = new WordValidator();
    public boolean checkWord(String input) {
        return check.validateWord(input);
    }


    private void initializeTts() {
        theVoice = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (theVoice.getEngines().size() == 0) {
                    Toast.makeText(level1game.this, "Sorry, No TTS engine available", Toast.LENGTH_SHORT);
                } else {
                    theVoice.setLanguage(Locale.getDefault());
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

    // timer function is from this youtube video: - https://www.youtube.com/watch?v=5ChnwWSAN5E
    private void start() {
        text_time.setText("Time: 30");

        countDownTimer = new CountDownTimer(31 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                text_time.setText("Time:" + " " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                speak("Final Score" + score);
                SharedPreferences b = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = b.edit();
                editor.putInt("Final Score: ", score);
                editor.apply();
                Intent a = new Intent(level1game.this, finalscreen.class);
                startActivity(a);
            }
        }.start();
    }

    private void cancel() {
        countDownTimer.cancel();
    }


}