//package com.example.doctor;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.pm.ActivityInfo;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ActivityAdapter extends ArrayAdapter<Activity> {
//
//    private Context context;
//    private int resource;
//    private ArrayList<ActivityInfo> activitylist;
//
//    public ActivityAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ActivityInfo> activitylist)
//    {
//
//        super(context, resource);
//        this.context = context;
//        this.resource = resource;
//        this.activitylist = activitylist;
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView,
//                        @NonNull ViewGroup parent) {
//        // just like we did with fragments:
//        // inflate a layout, wire widgets, insert data, return the layout
//        if(convertView == null) {
//            convertView = LayoutInflater.from(context)
//                    .inflate(R.layout.item_activitylist, parent,
//                            false);
//        }
//
//        ActivityInfo currentActivity = activitylist.get(position);
//
//        TextView textViewName =
//                convertView.findViewById(R.id.textView_main_name);
//        textViewName.setText(currentActivity.getClass().getName());
//
//        return convertView;
//    }
//
//}
