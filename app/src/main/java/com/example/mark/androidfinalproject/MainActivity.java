package com.example.mark.androidfinalproject;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView deviceStatus;
    private Button busyButton, freeButton;
    private Handler myHandler = new Handler();
    private boolean busy = false;
    //AudioManager audiomanage = (AudioManager)getSystemService(this.AUDIO_SERVICE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        busyButton = (Button) findViewById(R.id.makeBusy);
        freeButton = (Button) findViewById(R.id.makeFree);
        deviceStatus = (TextView) findViewById(R.id.EditTextStatus);

        busyButton.setOnClickListener(this);
        freeButton.setOnClickListener(this);

        //myHandler.post(new busyWork());
        Toast.makeText(this, "on create", Toast.LENGTH_LONG).show(); //debug toast


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
/*
    private class busyWork implements Runnable{

        @Override
        public void run() {

            if(busy) {
                audiomanage.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                toastIt("phone silenced");  //debug toast
            }else{
                toastIt("phone not silenced");
            }

        }
    }
*/
    public void toastIt(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //tells how to silence phone
    //http://stackoverflow.com/questions/3738724/silence-android-phone-in-java
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.makeBusy:
                busy = true;
                //audiomanage.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                deviceStatus.setText("Busy now");
                toastIt("phone silenced...");
                //myHandler.post(new busyWork());
                break;
            case R.id.makeFree:
                busy = false;
                deviceStatus.setText("Free now");

                //myHandler.post(new busyWork());
                break;
        }

    }
}
