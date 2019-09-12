package com.example.studentstimetable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        setupUIViews();
        initToolbar();

        setupListView();
    }

    private void setupUIViews(){

        toolbar = (Toolbar)findViewById(R.id.ToolbarSubjectDetails);
        listView = (ListView)findViewById(R.id.lvSubjectDetails);
    }

    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        String subject_selected = SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF,null);

        String[] syllabus1 = new String[]{};
        String[] titles = getResources().getStringArray(R.array.titles);

        if(subject_selected.equalsIgnoreCase("SAD")){

            syllabus1 = getResources().getStringArray(R.array.SAD);
        }else if(subject_selected.equalsIgnoreCase("DBMS")){

            syllabus1= getResources().getStringArray(R.array.DBMS);
        }else if(subject_selected.equalsIgnoreCase("DSP")){

            syllabus1 = getResources().getStringArray(R.array.DSP);
        }else if(subject_selected.equalsIgnoreCase("CD")){

            syllabus1 = getResources().getStringArray(R.array.CD);
        }else{

            syllabus1 = getResources().getStringArray(R.array.CE);

        }

        SubjectDetailsAdapter subjectDetailsAdapter = new SubjectDetailsAdapter(this, titles, syllabus1);
        listView.setAdapter(subjectDetailsAdapter);

    }

    public class SubjectDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, syllabus1;
        private String[] titleArray;
        private String[] syllabus1Array;

        public SubjectDetailsAdapter(Context context, String[] title, String[] syllabus1){

            mContext = context;
            titleArray = title;
            syllabus1Array = syllabus1;
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

                convertView = layoutInflater.inflate(R.layout.subject_details_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus1 = (TextView)convertView.findViewById(R.id.tvSyllabus);

            title.setText(titleArray[position]);
            syllabus1.setText(syllabus1Array[position]);


            return convertView;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
