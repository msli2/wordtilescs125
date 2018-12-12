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

public class level2game extends AppCompatActivity {

    private TextToSpeech theVoice;
    private View level2Top;
    private View level2Middle;
    private View level2Bottom;
    private Button button2_1;
    private Button button2_2;
    private Button button2_3;
    private Button button2_4;
    private Button button2_5;
    private Button button2_6;
    private Button button2_7;
    private Button button2_8;
    private Button button2_9;
    private Button button2_10;
    private Button button2_11;
    private Button button2_12;
    private Button button2_13;
    private Button button2_14;
    private Button button2_15;
    private Button button2_16;
    private Button button2_17;
    private Button button2_18;
    private Button button2_19;
    private Button button2_20;
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
        setContentView(R.layout.level2game);
        initializeTts();

        level2Top = (View) findViewById(R.id.include2_1);
        level2Middle = (View) findViewById(R.id.include2_2);
        level2Bottom = (View) findViewById(R.id.include2_3);
        word = new ArrayList<String>();

        button2_1 = (Button) level2Middle.findViewById(R.id.button2_1);
        button2_2 = (Button) level2Middle.findViewById(R.id.button2_2);
        button2_3 = (Button) level2Middle.findViewById(R.id.button2_3);
        button2_4 = (Button) level2Middle.findViewById(R.id.button2_4);
        button2_5 = (Button) level2Middle.findViewById(R.id.button2_5);
        button2_6 = (Button) level2Middle.findViewById(R.id.button2_6);
        button2_7 = (Button) level2Middle.findViewById(R.id.button2_7);
        button2_8 = (Button) level2Middle.findViewById(R.id.button2_8);
        button2_9 = (Button) level2Middle.findViewById(R.id.button2_9);
        button2_10 = (Button) level2Middle.findViewById(R.id.button2_10);
        button2_11 = (Button) level2Middle.findViewById(R.id.button2_11);
        button2_12 = (Button) level2Middle.findViewById(R.id.button2_12);
        button2_13 = (Button) level2Middle.findViewById(R.id.button2_13);
        button2_14 = (Button) level2Middle.findViewById(R.id.button2_14);
        button2_15 = (Button) level2Middle.findViewById(R.id.button2_15);
        button2_16 = (Button) level2Middle.findViewById(R.id.button2_16);
        button2_17 = (Button) level2Middle.findViewById(R.id.button2_17);
        button2_18 = (Button) level2Middle.findViewById(R.id.button2_18);
        button2_19 = (Button) level2Middle.findViewById(R.id.button2_19);
        button2_20 = (Button) level2Middle.findViewById(R.id.button2_20);

        button_refresh = (ImageButton) level2Top.findViewById(R.id.button_refresh);
        button_menu = (Button) level2Bottom.findViewById(R.id.button_menu);
        button_enter = (Button) level2Bottom.findViewById(R.id.button_enter);

        text_time = (TextView) level2Top.findViewById(R.id.text_time);
        score = 0;
        text_score = (TextView) level2Top.findViewById(R.id.text_score);

        start();

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
                cancel();
            }
        });

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public String toString() {
                return "$classname{}";
            }

            @Override
            public void onClick(View v) {
                String speakWord  = TextUtils.join("", word);
                word.clear();
                TextView display_text = (TextView) level2Bottom.findViewById(R.id.text_display);
                display_text.setText(speakWord);
                speak(speakWord);
                if (checkWord(speakWord)) {
                    score += speakWord.length() * speakWord.length();
                    text_score.setText("Score: " + score);
                }
            }
        });


        TextView button2_1Text = (TextView) button2_1;
        String text1 = String.valueOf(randomLetterVowels());
        button2_1Text.setText(text1);
        TextView button2_2Text = (TextView) button2_2;
        String text2 = String.valueOf(randomLetter());
        button2_2Text.setText(text2);
        TextView button2_3Text = (TextView) button2_3;
        String text3 = String.valueOf(randomLetter());
        button2_3Text.setText(text3);
        TextView button2_4Text = (TextView) button2_4;
        String text4 = String.valueOf(randomLetter());
        button2_4Text.setText(text4);
        TextView button2_5Text = (TextView) button2_5;
        String text5 = String.valueOf(randomLetter());
        button2_5Text.setText(text5);
        TextView button2_6Text = (TextView) button2_6;
        String text6 = String.valueOf(randomLetterVowels());
        button2_6Text.setText(text6);
        TextView button2_7Text = (TextView) button2_7;
        String text7 = String.valueOf(randomLetter());
        button2_7Text.setText(text7);
        TextView button2_8Text = (TextView) button2_8;
        String text8 = String.valueOf(randomLetter());
        button2_8Text.setText(text8);
        TextView button2_9Text = (TextView) button2_9;
        String text9 = String.valueOf(randomLetter());
        button2_9Text.setText(text9);
        TextView button2_10Text = (TextView) button2_10;
        String text10 = String.valueOf(randomLetter());
        button2_10Text.setText(text10);
        TextView button2_11Text = (TextView) button2_11;
        String text11 = String.valueOf(randomLetterVowels());
        button2_11Text.setText(text11);
        TextView button2_12Text = (TextView) button2_12;
        String text12 = String.valueOf(randomLetter());
        button2_12Text.setText(text12);
        TextView button2_13Text = (TextView) button2_13;
        String text13 = String.valueOf(randomLetter());
        button2_13Text.setText(text13);
        TextView button2_14Text = (TextView) button2_14;
        String text14 = String.valueOf(randomLetter());
        button2_14Text.setText(text14);
        TextView button2_15Text = (TextView) button2_15;
        String text15 = String.valueOf(randomLetter());
        button2_15Text.setText(text15);
        TextView button2_16Text = (TextView) button2_16;
        String text16 = String.valueOf(randomLetterVowels());
        button2_16Text.setText(text16);
        TextView button2_17Text = (TextView) button2_17;
        String text17 = String.valueOf(randomLetter());
        button2_17Text.setText(text17);
        TextView button2_18Text = (TextView) button2_18;
        String text18 = String.valueOf(randomLetter());
        button2_18Text.setText(text18);
        TextView button2_19Text = (TextView) button2_19;
        String text19 = String.valueOf(randomLetterVowels());
        button2_19Text.setText(text19);
        TextView button2_20Text = (TextView) button2_20;
        String text20 = String.valueOf(randomLetter());
        button2_20Text.setText(text20);

        button2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_1Text = (TextView) button2_1;
                word.add(button2_1Text.getText().toString());
                String text1 = String.valueOf(randomLetterVowels());
                button2_1Text.setText(text1);
            }
        });
        button2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_2Text = (TextView) button2_2;
                word.add(button2_2Text.getText().toString());
                String text2 = String.valueOf(randomLetter());
                button2_2Text.setText(text2);
            }
        });
        button2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_3Text = (TextView) button2_3;
                word.add(button2_3Text.getText().toString());
                String text3 = String.valueOf(randomLetter());
                button2_3Text.setText(text3);
            }
        });
        button2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_4Text = (TextView) button2_4;
                word.add(button2_4Text.getText().toString());
                String text4 = String.valueOf(randomLetter());
                button2_4Text.setText(text4);
            }
        });
        button2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_5Text = (TextView) button2_5;
                word.add(button1_5Text.getText().toString());
                String text5 = String.valueOf(randomLetter());
                button1_5Text.setText(text5);
            }
        });
        button2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_6Text = (TextView) button2_6;
                word.add(button2_6Text.getText().toString());
                String text6 = String.valueOf(randomLetterVowels());
                button2_6Text.setText(text6);
            }
        });
        button2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_7Text = (TextView) button2_7;
                word.add(button2_7Text.getText().toString());
                String text7 = String.valueOf(randomLetter());
                button2_7Text.setText(text7);
            }
        });
        button2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_8Text = (TextView) button2_8;
                word.add(button2_8Text.getText().toString());
                String text8 = String.valueOf(randomLetter());
                button2_8Text.setText(text8);
            }
        });
        button2_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_9Text = (TextView) button2_9;
                word.add(button2_9Text.getText().toString());
                String text9 = String.valueOf(randomLetter());
                button2_9Text.setText(text9);
            }
        });
        button2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_10Text = (TextView) button2_10;
                word.add(button2_10Text.getText().toString());
                String text10 = String.valueOf(randomLetter());
                button2_10Text.setText(text10);
            }
        });
        button2_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_11Text = (TextView) button2_11;
                word.add(button2_11Text.getText().toString());
                String text11 = String.valueOf(randomLetterVowels());
                button2_11Text.setText(text11);
            }
        });
        button2_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_12Text = (TextView) button2_12;
                word.add(button2_12Text.getText().toString());
                String text12 = String.valueOf(randomLetter());
                button2_12Text.setText(text12);
            }
        });
        button2_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_13Text = (TextView) button2_13;
                word.add(button2_13Text.getText().toString());
                String text13 = String.valueOf(randomLetter());
                button2_13Text.setText(text13);
            }
        });
        button2_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_14Text = (TextView) button2_14;
                word.add(button2_14Text.getText().toString());
                String text14 = String.valueOf(randomLetter());
                button2_14Text.setText(text14);
            }
        });
        button2_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button1_15Text = (TextView) button2_15;
                word.add(button1_15Text.getText().toString());
                String text15 = String.valueOf(randomLetter());
                button1_15Text.setText(text15);
            }
        });
        button2_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_16Text = (TextView) button2_16;
                word.add(button2_16Text.getText().toString());
                String text16 = String.valueOf(randomLetterVowels());
                button2_16Text.setText(text16);
            }
        });
        button2_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_17Text = (TextView) button2_17;
                word.add(button2_17Text.getText().toString());
                String text17 = String.valueOf(randomLetter());
                button2_17Text.setText(text17);
            }
        });
        button2_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_18Text = (TextView) button2_18;
                word.add(button2_18Text.getText().toString());
                String text18 = String.valueOf(randomLetterVowels());
                button2_18Text.setText(text18);
            }
        });
        button2_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_19Text = (TextView) button2_19;
                word.add(button2_19Text.getText().toString());
                String text19 = String.valueOf(randomLetter());
                button2_19Text.setText(text19);
            }
        });
        button2_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_20Text = (TextView) button2_20;
                word.add(button2_20Text.getText().toString());
                String text20 = String.valueOf(randomLetter());
                button2_20Text.setText(text20);
            }
        });


        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Refresh Game");
                TextView button2_1Text = (TextView) button2_1;
                String text1 = String.valueOf(randomLetterVowels());
                button2_1Text.setText(text1);
                TextView button2_2Text = (TextView) button2_2;
                String text2 = String.valueOf(randomLetter());
                button2_2Text.setText(text2);
                TextView button2_3Text = (TextView) button2_3;
                String text3 = String.valueOf(randomLetter());
                button2_3Text.setText(text3);
                TextView button2_4Text = (TextView) button2_4;
                String text4 = String.valueOf(randomLetter());
                button2_4Text.setText(text4);
                TextView button2_5Text = (TextView) button2_5;
                String text5 = String.valueOf(randomLetter());
                button2_5Text.setText(text5);
                TextView button2_6Text = (TextView) button2_6;
                String text6 = String.valueOf(randomLetterVowels());
                button2_6Text.setText(text6);
                TextView button2_7Text = (TextView) button2_7;
                String text7 = String.valueOf(randomLetter());
                button2_7Text.setText(text7);
                TextView button2_8Text = (TextView) button2_8;
                String text8 = String.valueOf(randomLetter());
                button2_8Text.setText(text8);
                TextView button2_9Text = (TextView) button2_9;
                String text9 = String.valueOf(randomLetter());
                button2_9Text.setText(text9);
                TextView button2_10Text = (TextView) button2_10;
                String text10 = String.valueOf(randomLetter());
                button2_10Text.setText(text10);
                TextView button2_11Text = (TextView) button2_11;
                String text11 = String.valueOf(randomLetterVowels());
                button2_11Text.setText(text11);
                TextView button2_12Text = (TextView) button2_12;
                String text12 = String.valueOf(randomLetter());
                button2_12Text.setText(text12);
                TextView button2_13Text = (TextView) button2_13;
                String text13 = String.valueOf(randomLetter());
                button2_13Text.setText(text13);
                TextView button2_14Text = (TextView) button2_14;
                String text14 = String.valueOf(randomLetter());
                button2_14Text.setText(text14);
                TextView button2_15Text = (TextView) button2_15;
                String text15 = String.valueOf(randomLetter());
                button2_15Text.setText(text15);
                TextView button2_16Text = (TextView) button2_16;
                String text16 = String.valueOf(randomLetterVowels());
                button2_16Text.setText(text16);
                TextView button2_17Text = (TextView) button2_17;
                String text17 = String.valueOf(randomLetter());
                button2_17Text.setText(text17);
                TextView button2_18Text = (TextView) button2_18;
                String text18 = String.valueOf(randomLetterVowels());
                button2_18Text.setText(text18);
                TextView button2_19Text = (TextView) button2_19;
                String text19 = String.valueOf(randomLetter());
                button2_19Text.setText(text19);
                TextView button2_20Text = (TextView) button2_20;
                String text20 = String.valueOf(randomLetter());
                button2_20Text.setText(text20);
            }
        });
    }
    public void openMenu() {
        Intent a = new Intent(level2game.this, MainActivity.class);
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


    private void initializeTts() {
        theVoice = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (theVoice.getEngines().size() == 0) {
                    Toast.makeText(level2game.this, "Sorry, No TTS engine available", Toast.LENGTH_SHORT);
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

    WordValidator check = new WordValidator();
    public boolean checkWord(String input) {
        return check.validateWord(input);
    }

    private void start() {
        text_time.setText("Time: 45");

        countDownTimer = new CountDownTimer(46 * 1000, 1000) {
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
                Intent a = new Intent(level2game.this, finalscreen.class);
                startActivity(a);
            }
        }.start();
    }

    private void cancel() {
        countDownTimer.cancel();
    }


}