package com.example.studentstimetable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentstimetable.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private ListView listView;
    private String[] syllabus;
    public static SharedPreferences subjectPreferences;
    public static String SUB_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();

        setupListView();
    }

    private void setupUIViews(){

        toolbar = (Toolbar)findViewById(R.id.ToolbarSubject);
        listView = (ListView)findViewById(R.id.lvSubject);
        subjectPreferences = getSharedPreferences("syllabus",MODE_PRIVATE);
    }

    private void initToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        syllabus = getResources().getStringArray(R.array.Syllabus);


        SubjectAdapter subjectAdapter = new SubjectAdapter(this,R.layout.subject_single_item,syllabus);

        listView.setAdapter(subjectAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        subjectPreferences.edit().putString(SUB_PREF,"SAD").apply();
                        Intent intent = new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:{
                        subjectPreferences.edit().putString(SUB_PREF,"DBMS").apply();
                        Intent intent = new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        subjectPreferences.edit().putString(SUB_PREF,"DSP").apply();
                        Intent intent = new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        subjectPreferences.edit().putString(SUB_PREF,"CD").apply();
                        Intent intent = new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        subjectPreferences.edit().putString(SUB_PREF,"CE").apply();
                        Intent intent = new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }

                }
            }
        });

    }

    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] syllabus = new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.syllabus = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject = (TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }else{

                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(syllabus[position].charAt(0));
            holder.tvSubject.setText(syllabus[position]);

            return convertView;

        }

        class ViewHolder{

            private LetterImageView ivLogo;
            private TextView tvSubject;
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
