package com.example.studentstimetable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentstimetable.Utils.LetterImageView;

public class DayDetail1 extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static String[] Saturday;
    public static String[] Sunday;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    private String[] PreferredDay;
    private String[] PreferredTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail1);

        setupUIViews();
        initToolbar();

        setupListView();
    }

    private void setupUIViews(){

        listView = (ListView)findViewById(R.id.lvDayDetail1);
        toolbar = (Toolbar)findViewById(R.id.ToolbarDayDetail1);
    }

    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity1.sharedPreferences.getString(WeekActivity1.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        Saturday = getResources().getStringArray(R.array.Saturday);
        Sunday = getResources().getStringArray(R.array.Sunday);
        Monday = getResources().getStringArray(R.array.Monday);
        Tuesday = getResources().getStringArray(R.array.Tuesday);
        Wednesday = getResources().getStringArray(R.array.Wednesday);
        Thursday = getResources().getStringArray(R.array.Thursday);


        Time1 = getResources().getStringArray(R.array.Time1);
        Time2 = getResources().getStringArray(R.array.Time2);
        Time3 = getResources().getStringArray(R.array.Time3);
        Time4 = getResources().getStringArray(R.array.Time4);
        Time5 = getResources().getStringArray(R.array.Time5);
        Time6 = getResources().getStringArray(R.array.Time6);

        String selected_day = WeekActivity1.sharedPreferences.getString(WeekActivity1.SEL_DAY,null);

        if(selected_day.equalsIgnoreCase("Saturday")){

            PreferredDay = Saturday;
            PreferredTime = Time1;
        } else if(selected_day.equalsIgnoreCase("Sunday")){

            PreferredDay = Sunday;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Monday")){

            PreferredDay = Monday;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Tuesday")){

            PreferredDay = Tuesday;
            PreferredTime = Time4;
        }else if(selected_day.equalsIgnoreCase("Wednesday")){

            PreferredDay = Wednesday;
            PreferredTime = Time5;
        }else{
            PreferredDay = Thursday;
            PreferredTime = Time6;

        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail1.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);





    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray){

            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){

                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }

            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails1);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail1);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails1);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;
        }
    }
}
