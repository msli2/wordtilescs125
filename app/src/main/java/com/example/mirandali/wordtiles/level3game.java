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

public class level3game extends AppCompatActivity {

    private TextToSpeech theVoice;
    private View level3Top;
    private View level3Middle;
    private View level3Bottom;
    private Button button3_1;
    private Button button3_2;
    private Button button3_3;
    private Button button3_4;
    private Button button3_5;
    private Button button3_6;
    private Button button3_7;
    private Button button3_8;
    private Button button3_9;
    private Button button3_10;
    private Button button3_11;
    private Button button3_12;
    private Button button3_13;
    private Button button3_14;
    private Button button3_15;
    private Button button3_16;
    private Button button3_17;
    private Button button3_18;
    private Button button3_19;
    private Button button3_20;
    private Button button3_21;
    private Button button3_22;
    private Button button3_23;
    private Button button3_24;
    private ImageButton button_refresh;
    private Button button_menu;
    private Button button_enter;

    private CountDownTimer countDownTimer;
    private TextView text_time;

    private int score;
    private TextView text_score;

    private ArrayList<String> word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3game);
        initializeTts();

        level3Top = (View) findViewById(R.id.include3_1);
        level3Middle = (View) findViewById(R.id.include3_2);
        level3Bottom = (View) findViewById(R.id.include3_3);
        word = new ArrayList<String>();

        button3_1 = (Button) level3Middle.findViewById(R.id.button3_1);
        button3_2 = (Button) level3Middle.findViewById(R.id.button3_2);
        button3_3 = (Button) level3Middle.findViewById(R.id.button3_3);
        button3_4 = (Button) level3Middle.findViewById(R.id.button3_4);
        button3_5 = (Button) level3Middle.findViewById(R.id.button3_5);
        button3_6 = (Button) level3Middle.findViewById(R.id.button3_6);
        button3_7 = (Button) level3Middle.findViewById(R.id.button3_7);
        button3_8 = (Button) level3Middle.findViewById(R.id.button3_8);
        button3_9 = (Button) level3Middle.findViewById(R.id.button3_9);
        button3_10 = (Button) level3Middle.findViewById(R.id.button3_10);
        button3_11 = (Button) level3Middle.findViewById(R.id.button3_11);
        button3_12 = (Button) level3Middle.findViewById(R.id.button3_12);
        button3_13 = (Button) level3Middle.findViewById(R.id.button3_13);
        button3_14 = (Button) level3Middle.findViewById(R.id.button3_14);
        button3_15 = (Button) level3Middle.findViewById(R.id.button3_15);
        button3_16 = (Button) level3Middle.findViewById(R.id.button3_16);
        button3_17 = (Button) level3Middle.findViewById(R.id.button3_17);
        button3_18 = (Button) level3Middle.findViewById(R.id.button3_18);
        button3_19 = (Button) level3Middle.findViewById(R.id.button3_19);
        button3_20 = (Button) level3Middle.findViewById(R.id.button3_20);
        button3_21 = (Button) level3Middle.findViewById(R.id.button3_21);
        button3_22 = (Button) level3Middle.findViewById(R.id.button3_22);
        button3_23 = (Button) level3Middle.findViewById(R.id.button3_23);
        button3_24 = (Button) level3Middle.findViewById(R.id.button3_24);

        button_refresh = (ImageButton) level3Top.findViewById(R.id.button_refresh);
        button_menu = (Button) level3Bottom.findViewById(R.id.button_menu);
        button_enter = (Button) level3Bottom.findViewById(R.id.button_enter);

        text_time = (TextView) level3Top.findViewById(R.id.text_time);
        score = 0;
        text_score = (TextView) level3Top.findViewById(R.id.text_score);

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
                TextView display_text = (TextView) level3Bottom.findViewById(R.id.text_display);
                display_text.setText(speakWord);
                speak(speakWord);
                if (checkWord(speakWord)) {
                    score += speakWord.length() * speakWord.length();
                    text_score.setText("Score: " + score);
                }
            }
        });


        TextView button3_1Text = (TextView) button3_1;
        String text1 = String.valueOf(randomLetterVowels());
        button3_1Text.setText(text1);
        TextView button3_2Text = (TextView) button3_2;
        String text2 = String.valueOf(randomLetter());
        button3_2Text.setText(text2);
        TextView button3_3Text = (TextView) button3_3;
        String text3 = String.valueOf(randomLetter());
        button3_3Text.setText(text3);
        TextView button3_4Text = (TextView) button3_4;
        String text4 = String.valueOf(randomLetter());
        button3_4Text.setText(text4);
        TextView button3_5Text = (TextView) button3_5;
        String text5 = String.valueOf(randomLetter());
        button3_5Text.setText(text5);
        TextView button3_6Text = (TextView) button3_6;
        String text6 = String.valueOf(randomLetterVowels());
        button3_6Text.setText(text6);
        TextView button3_7Text = (TextView) button3_7;
        String text7 = String.valueOf(randomLetter());
        button3_7Text.setText(text7);
        TextView button3_8Text = (TextView) button3_8;
        String text8 = String.valueOf(randomLetter());
        button3_8Text.setText(text8);
        TextView button3_9Text = (TextView) button3_9;
        String text9 = String.valueOf(randomLetter());
        button3_9Text.setText(text9);
        TextView button3_10Text = (TextView) button3_10;
        String text10 = String.valueOf(randomLetter());
        button3_10Text.setText(text10);
        TextView button3_11Text = (TextView) button3_11;
        String text11 = String.valueOf(randomLetterVowels());
        button3_11Text.setText(text11);
        TextView button3_12Text = (TextView) button3_12;
        String text12 = String.valueOf(randomLetter());
        button3_12Text.setText(text12);
        TextView button3_13Text = (TextView) button3_13;
        String text13 = String.valueOf(randomLetter());
        button3_13Text.setText(text13);
        TextView button3_14Text = (TextView) button3_14;
        String text14 = String.valueOf(randomLetter());
        button3_14Text.setText(text14);
        TextView button3_15Text = (TextView) button3_15;
        String text15 = String.valueOf(randomLetter());
        button3_15Text.setText(text15);
        TextView button3_16Text = (TextView) button3_16;
        String text16 = String.valueOf(randomLetterVowels());
        button3_16Text.setText(text16);
        TextView button3_17Text = (TextView) button3_17;
        String text17 = String.valueOf(randomLetter());
        button3_17Text.setText(text17);
        TextView button3_18Text = (TextView) button3_18;
        String text18 = String.valueOf(randomLetterVowels());
        button3_18Text.setText(text18);
        TextView button3_19Text = (TextView) button3_19;
        String text19 = String.valueOf(randomLetter());
        button3_19Text.setText(text19);
        TextView button3_20Text = (TextView) button3_20;
        String text20 = String.valueOf(randomLetter());
        button3_20Text.setText(text20);
        TextView button3_21Text = (TextView) button3_21;
        String text21 = String.valueOf(randomLetter());
        button3_21Text.setText(text21);
        TextView button3_22Text = (TextView) button3_22;
        String text22 = String.valueOf(randomLetter());
        button3_22Text.setText(text22);
        TextView button3_23Text = (TextView) button3_23;
        String text23 = String.valueOf(randomLetterVowels());
        button3_23Text.setText(text23);
        TextView button3_24Text = (TextView) button3_24;
        String text24 = String.valueOf(randomLetter());
        button3_24Text.setText(text24);



        button3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_1Text = (TextView) button3_1;
                word.add(button3_1Text.getText().toString());
                String text1 = String.valueOf(randomLetterVowels());
                button3_1Text.setText(text1);
            }
        });
        button3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button2_2Text = (TextView) button3_2;
                word.add(button2_2Text.getText().toString());
                String text2 = String.valueOf(randomLetter());
                button2_2Text.setText(text2);
            }
        });
        button3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_3Text = (TextView) button3_3;
                word.add(button3_3Text.getText().toString());
                String text3 = String.valueOf(randomLetter());
                button3_3Text.setText(text3);
            }
        });
        button3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_4Text = (TextView) button3_4;
                word.add(button3_4Text.getText().toString());
                String text4 = String.valueOf(randomLetter());
                button3_4Text.setText(text4);
            }
        });
        button3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_5Text = (TextView) button3_5;
                word.add(button3_5Text.getText().toString());
                String text5 = String.valueOf(randomLetter());
                button3_5Text.setText(text5);
            }
        });
        button3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_6Text = (TextView) button3_6;
                word.add(button3_6Text.getText().toString());
                String text6 = String.valueOf(randomLetterVowels());
                button3_6Text.setText(text6);
            }
        });
        button3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_7Text = (TextView) button3_7;
                word.add(button3_7Text.getText().toString());
                String text7 = String.valueOf(randomLetter());
                button3_7Text.setText(text7);
            }
        });
        button3_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_8Text = (TextView) button3_8;
                word.add(button3_8Text.getText().toString());
                String text8 = String.valueOf(randomLetter());
                button3_8Text.setText(text8);
            }
        });
        button3_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_9Text = (TextView) button3_9;
                word.add(button3_9Text.getText().toString());
                String text9 = String.valueOf(randomLetter());
                button3_9Text.setText(text9);
            }
        });
        button3_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_10Text = (TextView) button3_10;
                word.add(button3_10Text.getText().toString());
                String text10 = String.valueOf(randomLetter());
                button3_10Text.setText(text10);
            }
        });
        button3_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_11Text = (TextView) button3_11;
                word.add(button3_11Text.getText().toString());
                String text11 = String.valueOf(randomLetterVowels());
                button3_11Text.setText(text11);
            }
        });
        button3_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_12Text = (TextView) button3_12;
                word.add(button3_12Text.getText().toString());
                String text12 = String.valueOf(randomLetter());
                button3_12Text.setText(text12);
            }
        });
        button3_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_13Text = (TextView) button3_13;
                word.add(button3_13Text.getText().toString());
                String text13 = String.valueOf(randomLetter());
                button3_13Text.setText(text13);
            }
        });
        button3_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_14Text = (TextView) button3_14;
                word.add(button3_14Text.getText().toString());
                String text14 = String.valueOf(randomLetter());
                button3_14Text.setText(text14);
            }
        });
        button3_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_15Text = (TextView) button3_15;
                word.add(button3_15Text.getText().toString());
                String text15 = String.valueOf(randomLetter());
                button3_15Text.setText(text15);
            }
        });
        button3_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_16Text = (TextView) button3_16;
                word.add(button3_16Text.getText().toString());
                String text16 = String.valueOf(randomLetterVowels());
                button3_16Text.setText(text16);
            }
        });
        button3_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_17Text = (TextView) button3_17;
                word.add(button3_17Text.getText().toString());
                String text17 = String.valueOf(randomLetter());
                button3_17Text.setText(text17);
            }
        });
        button3_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_18Text = (TextView) button3_18;
                word.add(button3_18Text.getText().toString());
                String text18 = String.valueOf(randomLetterVowels());
                button3_18Text.setText(text18);
            }
        });
        button3_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_19Text = (TextView) button3_19;
                word.add(button3_19Text.getText().toString());
                String text19 = String.valueOf(randomLetter());
                button3_19Text.setText(text19);
            }
        });
        button3_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_20Text = (TextView) button3_20;
                word.add(button3_20Text.getText().toString());
                String text20 = String.valueOf(randomLetter());
                button3_20Text.setText(text20);
            }
        });
        button3_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_21Text = (TextView) button3_21;
                word.add(button3_21Text.getText().toString());
                String text21 = String.valueOf(randomLetter());
                button3_21Text.setText(text21);
            }
        });
        button3_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_22Text = (TextView) button3_22;
                word.add(button3_22Text.getText().toString());
                String text22 = String.valueOf(randomLetter());
                button3_22Text.setText(text22);
            }
        });
        button3_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_23Text = (TextView) button3_23;
                word.add(button3_23Text.getText().toString());
                String text23 = String.valueOf(randomLetterVowels());
                button3_23Text.setText(text23);
            }
        });
        button3_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView button3_24Text = (TextView) button3_24;
                word.add(button3_24Text.getText().toString());
                String text24 = String.valueOf(randomLetter());
                button3_24Text.setText(text24);
            }
        });


        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak("Refresh Game");
                TextView button3_1Text = (TextView) button3_1;
                String text1 = String.valueOf(randomLetterVowels());
                button3_1Text.setText(text1);
                TextView button3_2Text = (TextView) button3_2;
                String text2 = String.valueOf(randomLetter());
                button3_2Text.setText(text2);
                TextView button3_3Text = (TextView) button3_3;
                String text3 = String.valueOf(randomLetter());
                button3_3Text.setText(text3);
                TextView button3_4Text = (TextView) button3_4;
                String text4 = String.valueOf(randomLetter());
                button3_4Text.setText(text4);
                TextView button3_5Text = (TextView) button3_5;
                String text5 = String.valueOf(randomLetter());
                button3_5Text.setText(text5);
                TextView button3_6Text = (TextView) button3_6;
                String text6 = String.valueOf(randomLetterVowels());
                button3_6Text.setText(text6);
                TextView button3_7Text = (TextView) button3_7;
                String text7 = String.valueOf(randomLetter());
                button3_7Text.setText(text7);
                TextView button3_8Text = (TextView) button3_8;
                String text8 = String.valueOf(randomLetter());
                button3_8Text.setText(text8);
                TextView button3_9Text = (TextView) button3_9;
                String text9 = String.valueOf(randomLetter());
                button3_9Text.setText(text9);
                TextView button3_10Text = (TextView) button3_10;
                String text10 = String.valueOf(randomLetter());
                button3_10Text.setText(text10);
                TextView button3_11Text = (TextView) button3_11;
                String text11 = String.valueOf(randomLetterVowels());
                button3_11Text.setText(text11);
                TextView button3_12Text = (TextView) button3_12;
                String text12 = String.valueOf(randomLetter());
                button3_12Text.setText(text12);
                TextView button3_13Text = (TextView) button3_13;
                String text13 = String.valueOf(randomLetter());
                button3_13Text.setText(text13);
                TextView button3_14Text = (TextView) button3_14;
                String text14 = String.valueOf(randomLetter());
                button3_14Text.setText(text14);
                TextView button3_15Text = (TextView) button3_15;
                String text15 = String.valueOf(randomLetter());
                button3_15Text.setText(text15);
                TextView button3_16Text = (TextView) button3_16;
                String text16 = String.valueOf(randomLetterVowels());
                button3_16Text.setText(text16);
                TextView button3_17Text = (TextView) button3_17;
                String text17 = String.valueOf(randomLetter());
                button3_17Text.setText(text17);
                TextView button3_18Text = (TextView) button3_18;
                String text18 = String.valueOf(randomLetterVowels());
                button3_18Text.setText(text18);
                TextView button3_19Text = (TextView) button3_19;
                String text19 = String.valueOf(randomLetter());
                button3_19Text.setText(text19);
                TextView button3_20Text = (TextView) button3_20;
                String text20 = String.valueOf(randomLetter());
                button3_20Text.setText(text20);
                TextView button3_21Text = (TextView) button3_21;
                String text21 = String.valueOf(randomLetter());
                button3_21Text.setText(text21);
                TextView button3_22Text = (TextView) button3_22;
                String text22 = String.valueOf(randomLetter());
                button3_22Text.setText(text22);
                TextView button3_23Text = (TextView) button3_23;
                String text23 = String.valueOf(randomLetterVowels());
                button3_23Text.setText(text23);
                TextView button3_24Text = (TextView) button3_24;
                String text24 = String.valueOf(randomLetter());
                button3_24Text.setText(text24);
            }
        });
    }
    public void openMenu() {
        Intent a = new Intent(level3game.this, MainActivity.class);
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
                    Toast.makeText(level3game.this, "Sorry, No TTS engine available", Toast.LENGTH_SHORT);
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
        text_time.setText("Time: 60");

        countDownTimer = new CountDownTimer(61 * 1000, 1000) {
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
                Intent a = new Intent(level3game.this, finalscreen.class);
                startActivity(a);
            }
        }.start();
    }

    private void cancel() {
        countDownTimer.cancel();
    }



}