package com.this_user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Search_Activity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private DatabaseReference mQuery;
    private String mName;
    private String phone;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Intent i = getIntent();
        mName = i.getStringExtra("name");
        phone = i.getStringExtra("phone");
        location = i.getStringExtra("location");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String myUserLocation = location;
                Query myTopPostsQuery = mDatabase.child("users");


                myTopPostsQuery.addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        User[] freinds = new User[3];
                        for (int k = 0; k < 3; k++) {
                            freinds[k] = new User();
                        }
                        int j = 0;
                        Iterable<DataSnapshot> list = dataSnapshot.getChildren();

                        for (DataSnapshot data : list) {
                            String key = data.toString();
                            if (key.equals("location") && !data.getValue().equals("")) {
                                if (data.getValue().toString().equals(myUserLocation)) {
                                    if (j < 3) {
                                        // freinds[j]=new User(, String phone\, String password, String name);
                                        j++;
                                    } else continue;
                                }
                            }
                        }
                        fillNames(freinds);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        User[] freinds = new User[3];
                        for (int k = 0; k < 3; k++) {
                            freinds[k] = new User();
                        }
                        int j = 0;
                        Iterable<DataSnapshot> list = dataSnapshot.getChildren();


                        for (DataSnapshot data : list) {
                            String room = data.child("location").toString();

                            if (room.equals(myUserLocation)) {
                                if (j < 3) {
                                    freinds[j] = new User((User) data.getValue());
                                    j++;
                                }
                            }
                        }
                        fillNames(freinds);
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

        });
    }


    public void fillNames(User[] person) {
        TextView t = (TextView) findViewById(R.id.textView4);
        Button b = (Button) findViewById(R.id.button);

        t.setText(person[0].getName());
        if (person[0].getName() != "")
            b.setVisibility(View.VISIBLE);
        t = (TextView) findViewById(R.id.textButton1);
        t.setText(person[0].getPhone() + "\n" + person[0].getLocation());

        t = (TextView) findViewById(R.id.textView5);
        t.setText(person[1].getName());
        b = (Button) findViewById(R.id.button2);
        if (person[1].getName() != "")
            b.setVisibility(View.VISIBLE);
        t = (TextView) findViewById(R.id.textButton2);
        t.setText(person[1].getPhone() + "\n" + person[1].getLocation());

        t = (TextView) findViewById(R.id.textView6);
        t.setText(person[2].getName());
        b = (Button) findViewById(R.id.button3);
        if (person[2].getName() != "")
            b.setVisibility(View.VISIBLE);
        t = (TextView) findViewById(R.id.textButton3);
        t.setText(person[2].getPhone() + "\n" + person[2].getLocation());
    }

    public void viewData1(View view) {
        TextView t = (TextView) findViewById(R.id.textButton1);
        t.setVisibility(View.VISIBLE);
    }

    public void viewData2(View view) {
        TextView t = (TextView) findViewById(R.id.textButton2);
        t.setVisibility(View.VISIBLE);
    }

    public void viewData3(View view) {
        TextView t = (TextView) findViewById(R.id.textButton3);
        t.setVisibility(View.VISIBLE);
    }
}
