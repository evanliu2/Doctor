package com.example.doctor;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorMainActivity extends AppCompatActivity {

    private TextView bpm;
    private TextView beatdisplay;

    private Button start;
    private Button stop;

    private CheckBox offbeats;
    private CheckBox efirst;
    private CheckBox hidecounts;
    private CheckBox cats;

    private int userBpm;
    private int count;

    CountDownTimer countdown;

    public static final String TAG = DoctorMainActivity.class.getSimpleName();

    private boolean stopped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_main);

        wireWidgets();

        //final MediaPlayer defaultBeat = MediaPlayer.create(this, R.raw.woodtickshort);
        final SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        final int defaultBeat = soundPool.load(this, R.raw.woodtickshort, 1);
        final int kittenBeat = soundPool.load(this, R.raw.kittenbeat, 1);
        final int kittenEfirst = soundPool.load(this, R.raw.kittenefirst, 1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopped = false;
                soundPool.autoPause();
                soundPool.autoResume();

                if(hidecounts.isChecked())
                {
                    beatdisplay.setVisibility(View.INVISIBLE);
                }

                else
                {
                    beatdisplay.setVisibility(View.VISIBLE);
                }

                //Empty?
                if(bpm.length() != 0) {

                    //Too Long?
                    if (Integer.parseInt(bpm.getText().toString()) > 300) {
                        Toast.makeText(DoctorMainActivity.this, "Yeah...No...", Toast.LENGTH_SHORT).show();
                    }

                    //No? Cool
                    else {

                        start.setEnabled(false);
                        start.setVisibility(View.INVISIBLE);
                        stop.setEnabled(true);
                        stop.setVisibility(View.VISIBLE);

                        userBpm = Integer.parseInt(bpm.getText().toString());
                        final double beatsPerSec = userBpm / 60.0;
                        int interval = (int) (1000 / beatsPerSec);
                        count = 1;

                        if (offbeats.isChecked()) {
                            interval = (int) (0.5 * (int) (1000 / beatsPerSec));
                        }

                        countdown = new CountDownTimer(Integer.MAX_VALUE, interval) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                if (offbeats.isChecked()) {

                                    if (count % 2 == 1) {

                                        if (count == 1 && efirst.isChecked()) {
                                            beatdisplay.setText(count + "");

                                                if(cats.isChecked())
                                                    soundPool.play(kittenEfirst,1f, 1f, 0, 0, 1f);
                                                else
                                                soundPool.play(defaultBeat, 1f, 1f, 0, 0, 1);

                                            count++;
                                        }

                                        else {
                                            beatdisplay.setText(count + "");

                                                if(cats.isChecked())
                                                    soundPool.play(kittenBeat, 0.4f, 0.4f, 0, 0, 1);

                                                else
                                                    soundPool.play(defaultBeat, 0.4f, 0.4f, 0, 0, 1);

                                            count++;
                                        }
                                    }

                                    else {
                                        beatdisplay.setText(count + "");

                                        if(cats.isChecked())
                                            soundPool.play(kittenBeat, 0.2f, 0.2f, 0, 0, 1);

                                        else
                                            soundPool.play(defaultBeat, 0.2f, 0.2f, 0, 0, 1);

                                        if (count == 8) {
                                            count = 1;
                                        } else {
                                            count++;
                                        }
                                    }
                                }

                                else if (offbeats.isChecked() == false) {

                                    if (count == 1 && efirst.isChecked()) {
                                        beatdisplay.setText(count + "");
                                        if(cats.isChecked())
                                            soundPool.play(kittenEfirst, 1f, 1f, 0, 0, 1);
                                        else
                                            soundPool.play(defaultBeat, 1f, 1f, 0, 0, 1);

                                        count++;
                                    }

                                    else {
                                        beatdisplay.setText(count + "");
                                        if(cats.isChecked())
                                            soundPool.play(kittenBeat, 0.4f, 0.4f, 0, 0, 1);
                                        else
                                            soundPool.play(defaultBeat, 0.4f, 0.4f, 0, 0, 1);

                                        if (count == 4) {
                                            count = 1;
                                        }
                                        else {
                                            count++;
                                        }
                                    }
                                }
                            }


                            @Override
                            public void onFinish() {
                                Toast.makeText(DoctorMainActivity.this, "done!", Toast.LENGTH_SHORT).show();
                            }
                        };

                        countdown.start();

                    }
                }

                else
                    {
                        Toast.makeText(DoctorMainActivity.this, "Please Enter a Bpm!", Toast.LENGTH_SHORT).show();
                    }

                }


        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countdown.cancel();
                soundPool.autoPause();

                stopped = true;

                if(stopped)
                {
                    start.setEnabled(true);
                    start.setVisibility(View.VISIBLE);
                    stop.setEnabled(false);
                    stop.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    private void wireWidgets() {
        bpm = findViewById(R.id.editText_main_bpm);
        beatdisplay = findViewById(R.id.textView_main_beatnum);
        start = findViewById(R.id.button_main_start);
        stop = findViewById(R.id.button_main_stop);
        offbeats = findViewById(R.id.checkBox_main_offbeats);
        efirst = findViewById(R.id.checkBox_main_efirst);
        hidecounts = findViewById(R.id.checkBox_main_hidecounts);
        cats = findViewById(R.id.checkBox_main_cats);
    }
}

//TODO MAKE SOME KIND OF WARNING FOR THE FOLLOWING QUALITY DROPS FOR CATS
//  DONT USE ABOVE 90 BPM
//  DONT USE WITH OFFBEATS FUNCTION IF ABOVE 45 BPM
//  DO NOT PLAY AROUND DOGS OR THOSE WHO BECOME ANNOYED EASILY