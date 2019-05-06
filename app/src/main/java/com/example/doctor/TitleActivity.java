package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TitleActivity extends AppCompatActivity{

    private TextView title;
    private Button start;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.title_main);
        this.getSupportActionBar().hide();

        wireWidgets();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transition = new Intent( TitleActivity.this, DoctorMainActivity.class);
                startActivity(transition);
            }
        });
    }

    private void wireWidgets() {
        title = findViewById(R.id.textView_main_title);
        start = findViewById(R.id.button_main_start);
    }
}
