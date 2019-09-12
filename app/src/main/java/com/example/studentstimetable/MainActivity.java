package com.example.studentstimetable;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  //  private ShareActionProvider shareActionProvider;


    Button btn_timetable,btn_notes,btn_notification,btn_camera,btn_share,btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_timetable = (Button)findViewById(R.id.buttonTimetable);
        btn_notes = (Button)findViewById(R.id.buttonNotes);
        btn_notification = (Button)findViewById(R.id.buttonNotification);
        btn_camera = (Button)findViewById(R.id.buttonCamera);
        btn_share = (Button)findViewById(R.id.buttonShare);
        btn_about = (Button)findViewById(R.id.buttonAbout);

        btn_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Time Table Clicked", Toast.LENGTH_SHORT).show();

                openTimetableActivity();
            }
        });

        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Notes Clicked", Toast.LENGTH_SHORT).show();
                openNotesActivity();
            }
        });

        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Reminder Clicked", Toast.LENGTH_SHORT).show();

                openNotificationActivity();
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Camera Clicked", Toast.LENGTH_SHORT).show();

                openCameraActivity();

            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();

                openShareActivity();
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();

               openAboutActivity();

            }
        });

    }

    public void openTimetableActivity(){

        Intent intent = new Intent(this, ActivityTimetable.class);
        startActivity(intent);
    }

    public void openShareActivity(){

        Intent intent = new Intent(this, ActivityShare.class);
        startActivity(intent);
    }

    public void openCameraActivity(){

        Intent intent = new Intent(this,CameraActivity.class);
        startActivity(intent);
    }

    public void openAboutActivity(){

        Intent intent = new Intent(this, ActivityAbout.class);
        startActivity(intent);
    }

    public void openNotificationActivity(){

        Intent intent = new Intent(this, ActivityNotification.class);
        startActivity(intent);
    }

    public void openNotesActivity(){

        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }

    public void onBackPressed(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm Exit..!!");

        alertDialogBuilder.setIcon(R.drawable.ic_exit);

        alertDialogBuilder.setMessage("Are you sure you want to exit");

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "You clicked on cancel", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}


