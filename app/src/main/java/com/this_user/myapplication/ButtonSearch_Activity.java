package com.this_user.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ButtonSearch_Activity extends AppCompatActivity {

    private String mName;
    private String phone;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttonsearch_);

        Intent i = getIntent();
        mName = i.getStringExtra("name");
        phone = i.getStringExtra("phone");
        location = i.getStringExtra("location");

        TextView t = (TextView) findViewById(R.id.textView2);
        t.setText("Hi "+mName + "  :)");

        t = (TextView) findViewById(R.id.textView3);
        t.setText("You can search for charger in the your location: ");

        t = (TextView) findViewById(R.id.textView7);
        t.setText(location);





        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ButtonSearch_Activity.this, Search_Activity.class);
                i.putExtra("name", mName);
                i.putExtra("phone", phone);
                i.putExtra("location", location);
                startActivity(i);
            }


        });

    }
}