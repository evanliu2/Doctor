//package com.example.doctor;
//
//import android.app.Activity;
//import android.content.pm.ActivityInfo;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class TransitionActivity extends AppCompatActivity{
//
//    private ListView listView;
//    private List<ActivityInfo> activitylist;
//    private ArrayList<ActivityInfo> templist;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.transition_main);
//        this.getSupportActionBar().hide();
//
//        wireWidgets();
//        populateListView();
//
//        try {
//            templist = new ArrayList<ActivityInfo>(Arrays.asList(getPackageManager().getPackageInfo(getPackageName(),0).activities));
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    //HOW DO YOU GET A LIST OF ALL THE ACTIVITIES IN AN APP
//
//    private void populateListView() {
//
//        ActivityAdapter adapter = new ActivityAdapter(
//                TransitionActivity.this,
//                R.layout.item_activitylist,
//                templist);
//
//        listView.setAdapter(adapter);
//
//    }
//
//    private void wireWidgets() {
//        listView = findViewById(R.id.ListView_main_activitylist);
//    }
//
//}