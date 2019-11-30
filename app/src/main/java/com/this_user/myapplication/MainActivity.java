package com.this_user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable()  {
            @Override
            public void run() {

                try {
                    synchronized (this) {
                        wait(2000);
                        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);

                        myIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(myIntent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }
}
