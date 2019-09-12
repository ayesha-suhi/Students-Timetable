package com.example.studentstimetable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Year2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year2);

        setUIViews();
        initToolbar();

        setupListView();
    }

    private void setUIViews(){

        toolbar = (Toolbar)findViewById(R.id.ToolbarMain2);
        listView = (ListView)findViewById(R.id.lvMain2);

    }

    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("2nd Year Timetable");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Year2);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0 :{
                        Intent intent = new Intent(Year2Activity.this, WeekActivity1.class);
                        startActivity(intent);
                        break;
                    }
                    case 1 :{
                        break;
                    }
                    case 2 :{
                        break;
                    }
                    case 3: {
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){

            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){

                convertView = layoutInflater.inflate(R.layout.year2_activity_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvYear2);
            description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView)convertView.findViewById(R.id.ivYear2);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Class Routine")){

                imageView.setImageResource(R.drawable.routine);

            }else if(titleArray[position].equalsIgnoreCase("Syllabus")){

                imageView.setImageResource(R.drawable.book);

            }else if(titleArray[position].equalsIgnoreCase("Faculty")){

                imageView.setImageResource(R.drawable.faculty);

            }else{

                imageView.setImageResource(R.drawable.resources);
            }

            return convertView;
        }
    }
}
