package com.example.studentstimetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ActivityTimetable extends AppCompatActivity implements View.OnClickListener {

    private CardView year1CardView, year2CardView, year3CardView, year4CardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        year1CardView = findViewById(R.id.year1CardViewId);
        year2CardView = findViewById(R.id.year2CardViewId);
        year3CardView = findViewById(R.id.year3CardViewId);
        year4CardView = findViewById(R.id.year4CardViewId);

        year1CardView.setOnClickListener(this);
        year2CardView.setOnClickListener(this);
        year3CardView.setOnClickListener(this);
        year4CardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.year1CardViewId)
        {

            Intent intent = new Intent(ActivityTimetable.this, Year1Activity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.year2CardViewId)
        {

            Intent intent = new Intent(ActivityTimetable.this, Year2Activity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.year3CardViewId)
        {

            Intent intent = new Intent(ActivityTimetable.this, Year3Activity.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.year4CardViewId)
        {

            Intent intent = new Intent(ActivityTimetable.this, Year4Activity.class);
            startActivity(intent);

        }

    }
}
