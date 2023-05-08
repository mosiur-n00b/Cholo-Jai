package com.example.gadgethouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class moti_rangamati extends AppCompatActivity {
    private Button ok1;
    private int  numberOfSpot,numOfPerson,numOfDays;
    private String location,email;
    private Button plus_1,plus_2,plus_3,plus_4,minus_1,minus_2,minus_3,minus_4;
    private TextView textView1,textView2,textView3,textView4;
    private int singleBed=0,doubleBed=0,twinRoom=0,presidential=0;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private int hotelCost=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moti_rangamati);

        email = getIntent().getStringExtra("email");
        numberOfSpot = getIntent().getIntExtra("numberOfSpot",0);
        location = getIntent().getStringExtra("location");
        numOfPerson = getIntent().getIntExtra("numberOfPerson",0);
        numOfDays = getIntent().getIntExtra("numberOfDays",0);

        plus_1 = (Button)findViewById(R.id.plus_1);
        plus_2 = (Button)findViewById(R.id.plus_2);
        plus_3 = (Button)findViewById(R.id.plus_3);
        plus_4 = (Button)findViewById(R.id.plus_4);
        minus_1 = (Button)findViewById(R.id.minus_1);
        minus_2 = (Button)findViewById(R.id.minus_2);
        minus_3 = (Button)findViewById(R.id.minus_3);
        minus_4 = (Button)findViewById(R.id.minus_4);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);

        plus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(singleBed<10){
                    singleBed++;
                }
                textView1.setText(String.valueOf(singleBed));
            }
        });
        minus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(singleBed>0) {
                    singleBed--;
                    textView1.setText(String.valueOf(singleBed));
                }
            }
        });

        plus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(doubleBed<10){
                    doubleBed++;
                }
                textView2.setText(String.valueOf(doubleBed));
            }
        });
        minus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(doubleBed>0) {
                    doubleBed--;
                    textView2.setText(String.valueOf(doubleBed));
                }
            }
        });

        plus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(twinRoom<10){
                    twinRoom++;
                }
                textView3.setText(String.valueOf(twinRoom));
            }
        });
        minus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(twinRoom>0) {
                    twinRoom--;
                    textView3.setText(String.valueOf(twinRoom));
                }
            }
        });

        plus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presidential<10){
                    presidential++;
                }
                textView4.setText(String.valueOf(presidential));
            }
        });
        minus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presidential>0) {
                    presidential--;
                    textView4.setText(String.valueOf(presidential));
                }
            }
        });

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);

        ok1 = (Button) findViewById(R.id.ok1);
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((!checkBox1.isChecked()  && Integer.parseInt(textView1.getText().toString())>0)) || ((!checkBox2.isChecked()  && Integer.parseInt(textView2.getText().toString())>0)) || ((!checkBox3.isChecked()  && Integer.parseInt(textView3.getText().toString())>0)) || ((!checkBox4.isChecked()  && Integer.parseInt(textView4.getText().toString())>0))){
                    cheackRoom(1);
                }
                else if(((!checkBox1.isChecked()  && Integer.parseInt(textView1.getText().toString())==0)) && ((!checkBox2.isChecked()  && Integer.parseInt(textView2.getText().toString())==0)) && ((!checkBox3.isChecked()  && Integer.parseInt(textView3.getText().toString())==0)) && ((!checkBox4.isChecked()  && Integer.parseInt(textView4.getText().toString())==0))){
                    cheackRoom(2);
                }
                else if((checkBox1.isChecked() && Integer.parseInt(textView1.getText().toString())==0) || (checkBox2.isChecked() && Integer.parseInt(textView2.getText().toString())==0) || (checkBox3.isChecked() && Integer.parseInt(textView3.getText().toString())==0) || (checkBox4.isChecked() && Integer.parseInt(textView4.getText().toString())==0)){
                    cheackRoom(3);
                }
                else{
                    if(checkBox1.isChecked()){
                        int singleBedRent =2100 * (Integer.parseInt(textView1.getText().toString()));
                        hotelCost=hotelCost+singleBedRent;
                    }
                    if(checkBox2.isChecked()){
                        int doubleBedRent =4100 * (Integer.parseInt(textView2.getText().toString()));
                        hotelCost=hotelCost+doubleBedRent;
                    }
                    if(checkBox3.isChecked()){
                        int twinRoomRent =5110 * (Integer.parseInt(textView3.getText().toString()));
                        hotelCost=hotelCost+twinRoomRent;
                    }
                    if(checkBox4.isChecked()){
                        int presidentialRent =6500 * (Integer.parseInt(textView4.getText().toString()));
                        hotelCost=hotelCost+presidentialRent;
                    }

                    Intent intent_3= new Intent(moti_rangamati.this,select_car.class);
                    intent_3.putExtra("hotelCost",hotelCost);
                    intent_3.putExtra("numberOfPerson",numOfPerson);
                    intent_3.putExtra("numberOfDays",numOfDays);
                    intent_3.putExtra("numberOfSpot",numberOfSpot);
                    intent_3.putExtra("location",location);
                    intent_3.putExtra("email",email);
                    startActivity(intent_3);
                    hotelCost=0;
                }
            }
        });

    }
    public void cheackRoom(int num){
        AlertDialog alertDialog = new AlertDialog.Builder(moti_rangamati.this).create();
        alertDialog.setTitle("Alert");
        if(num==1){
            alertDialog.setMessage("Please click the box");
        }
        if(num==2){
            alertDialog.setMessage("Please click the box & increase room number");
        }

        if(num==3){
            alertDialog.setMessage("Please increase your room number");
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}