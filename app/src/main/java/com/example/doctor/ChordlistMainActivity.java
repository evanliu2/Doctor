package com.example.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ChordlistMainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chordlist_main);

        ChordlistMainActivity.this.setTitle("Guitar Chord List");

    }
}
