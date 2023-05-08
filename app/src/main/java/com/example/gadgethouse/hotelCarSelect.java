package com.example.gadgethouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;


public class hotelCarSelect extends AppCompatActivity {
    private LinearLayout checkInDate,checkOutDate,longbeachLayout,seagullLayout,primeLayout,sea_shineLayout;
    private String location,email;
    private int  numberOfSpot,numOfPerson=1;
    private Button minusPerson,plusPerson;
    private TextView showPerson,viewCheakInDate,viewCheakOutDate,showLocation1,showLocation2,showLocation3,showLocation4;
    private DatePickerDialog.OnDateSetListener mDateSetListener_1,mDateSetListener_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_car_select);

        email = getIntent().getStringExtra("email");
        numberOfSpot = getIntent().getIntExtra("numberOfSpot",0);
        location = getIntent().getStringExtra("location");

        longbeachLayout = (LinearLayout) findViewById(R.id.longbeachLayout);
        longbeachLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numOfPerson =  Integer.parseInt(showPerson.getText().toString());
                if(viewCheakInDate.getText().toString() == "" || viewCheakOutDate.getText().toString() == ""){
                    fillUpTheDate(1);
                }else{
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
                    String startDate = viewCheakInDate.getText().toString();
                    String endDate = viewCheakOutDate.getText().toString();
                    LocalDate startDateValue = LocalDate.parse(startDate, dateFormatter);
                    LocalDate endDateValue = LocalDate.parse(endDate, dateFormatter);
                    long days = ChronoUnit.DAYS.between(startDateValue, endDateValue);
                    int numOfDays = (int)days;
                    if(numOfPerson>100){
                        Toast.makeText(getApplicationContext(),"can't exceed 100 person",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(numOfDays<1){
                            fillUpTheDate(1);
                        }
                        else if(numberOfSpot/numOfDays > 3){
                            fillUpTheDate(2);
                        }
                        else{
                            Intent intent_1= new Intent(hotelCarSelect.this,long_beach.class);
                            intent_1.putExtra("numberOfSpot",numberOfSpot);
                            intent_1.putExtra("location",location);
                            intent_1.putExtra("numberOfPerson",numOfPerson);
                            intent_1.putExtra("numberOfDays",numOfDays);
                            intent_1.putExtra("email",email);
                            startActivity(intent_1);
                        }
                    }
                }
            }
        });

        seagullLayout = (LinearLayout) findViewById(R.id.seagullLayout);
        seagullLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numOfPerson =  Integer.parseInt(showPerson.getText().toString());
                if(viewCheakInDate.getText().toString() == "" || viewCheakOutDate.getText().toString() == ""){
                    fillUpTheDate(1);
                }else{
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
                    String startDate = viewCheakInDate.getText().toString();
                    String endDate = viewCheakOutDate.getText().toString();
                    LocalDate startDateValue = LocalDate.parse(startDate, dateFormatter);
                    LocalDate endDateValue = LocalDate.parse(endDate, dateFormatter);
                    long days = ChronoUnit.DAYS.between(startDateValue, endDateValue);
                    int numOfDays = (int)days;
                    if(numOfPerson>100){
                        Toast.makeText(getApplicationContext(),"can't exceed 100 person",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(numOfDays<1){
                            fillUpTheDate(1);
                        }
                        else if(numberOfSpot/numOfDays > 3){
                            fillUpTheDate(2);
                        }
                        else{
                            Intent intentt= new Intent(hotelCarSelect.this,seagull.class);
                            intentt.putExtra("numberOfSpot",numberOfSpot);
                            intentt.putExtra("location",location);
                            intentt.putExtra("numberOfPerson",numOfPerson);
                            intentt.putExtra("numberOfDays",numOfDays);
                            intentt.putExtra("email",email);
                            startActivity(intentt);
                        }
                    }
                }
            }
        });

        primeLayout = (LinearLayout) findViewById(R.id.primeLayout);
        primeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numOfPerson =  Integer.parseInt(showPerson.getText().toString());
                if(viewCheakInDate.getText().toString() == "" || viewCheakOutDate.getText().toString() == ""){
                    fillUpTheDate(1);
                }else{
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
                    String startDate = viewCheakInDate.getText().toString();
                    String endDate = viewCheakOutDate.getText().toString();
                    LocalDate startDateValue = LocalDate.parse(startDate, dateFormatter);
                    LocalDate endDateValue = LocalDate.parse(endDate, dateFormatter);
                    long days = ChronoUnit.DAYS.between(startDateValue, endDateValue);
                    int numOfDays = (int)days;
                    if(numOfPerson>100){
                        Toast.makeText(getApplicationContext(),"can't exceed 100 person",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(numOfDays<1){
                            fillUpTheDate(1);
                        }
                        else if(numberOfSpot/numOfDays > 3){
                            fillUpTheDate(2);
                        }
                        else{
                            Intent intentt= new Intent(hotelCarSelect.this,prime_coxbazar.class);
                            intentt.putExtra("numberOfSpot",numberOfSpot);
                            intentt.putExtra("location",location);
                            intentt.putExtra("numberOfPerson",numOfPerson);
                            intentt.putExtra("numberOfDays",numOfDays);
                            intentt.putExtra("email",email);
                            startActivity(intentt);
                        }
                    }
                }
            }
        });
        sea_shineLayout = (LinearLayout) findViewById(R.id.sea_shineLayout);
        sea_shineLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numOfPerson =  Integer.parseInt(showPerson.getText().toString());
                if(viewCheakInDate.getText().toString() == "" || viewCheakOutDate.getText().toString() == ""){
                    fillUpTheDate(1);
                }else{
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
                    String startDate = viewCheakInDate.getText().toString();
                    String endDate = viewCheakOutDate.getText().toString();
                    LocalDate startDateValue = LocalDate.parse(startDate, dateFormatter);
                    LocalDate endDateValue = LocalDate.parse(endDate, dateFormatter);
                    long days = ChronoUnit.DAYS.between(startDateValue, endDateValue);
                    int numOfDays = (int)days;
                    if(numOfPerson>100){
                        Toast.makeText(getApplicationContext(),"can't exceed 100 person",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(numOfDays<1){
                            fillUpTheDate(1);
                        }
                        else if(numberOfSpot/numOfDays > 3){
                            fillUpTheDate(2);
                        }
                        else{
                            Intent intentt= new Intent(hotelCarSelect.this,seashine_coxbazar.class);
                            intentt.putExtra("numberOfSpot",numberOfSpot);
                            intentt.putExtra("location",location);
                            intentt.putExtra("numberOfPerson",numOfPerson);
                            intentt.putExtra("numberOfDays",numOfDays);
                            intentt.putExtra("email",email);
                            startActivity(intentt);
                        }
                    }
                }
            }
        });

         showPerson = (TextView) findViewById(R.id.showPerson);
         minusPerson =  (Button) findViewById(R.id.minusPerson);
         minusPerson.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(numOfPerson>1){
                     numOfPerson--;
                 }
                 showPerson.setText(String.valueOf(numOfPerson));
             }
         });

        plusPerson = (Button) findViewById(R.id.plusPerson);
        plusPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfPerson++;
                showPerson.setText(String.valueOf(numOfPerson));
            }
        });

        checkInDate = (LinearLayout)findViewById(R.id.cheakInDate);
        viewCheakInDate = (TextView) findViewById(R.id.viewCheakInDate);
        checkInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal_1 = Calendar.getInstance();
                int year = cal_1 .get(Calendar.YEAR);
                int month = cal_1 .get(Calendar.MONTH);
                int day = cal_1 .get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(
                        hotelCarSelect.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener_1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener_1 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d("hotelCarSelect","onDateSet:dd-MM-yyyy:"+day+"/"+month+'/'+year);
                String date = day+"/"+month+'/'+year;
                viewCheakInDate.setText(date);
            }
        };

        checkOutDate = (LinearLayout)findViewById(R.id.cheakOutDate);
        viewCheakOutDate = (TextView) findViewById(R.id.viewCheakOutDate);
        checkOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal_2  = Calendar.getInstance();
                int year = cal_2.get(Calendar.YEAR);
                int month = cal_2.get(Calendar.MONTH);
                int day = cal_2.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(
                        hotelCarSelect.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener_2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener_2 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d("hotelCarSelect","onDateSet:dd-MM-yyyy:"+day+"/"+month+'/'+year);
                String date = day+"/"+month+'/'+year;
                viewCheakOutDate.setText(date);
            }
        };
        showLocation1 = (TextView)findViewById(R.id.showLocation1);
        showLocation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocation("Long Beach Hotel");
            }
        });
        showLocation2 = (TextView)findViewById(R.id.showLocation2);
        showLocation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocation("Hotel Seagull");
            }
        });
        showLocation3 = (TextView)findViewById(R.id.showLocation3);
        showLocation3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocation("Prime Park Hotel");
            }
        });
        showLocation4 = (TextView)findViewById(R.id.showLocation4);
        showLocation4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocation("Hotel Sea Shine");
            }
        });
    }

    public void fillUpTheDate(int num){
        AlertDialog alertDialog = new AlertDialog.Builder(hotelCarSelect.this).create();
        alertDialog.setTitle("Alert");
        if(num==1){
            alertDialog.setMessage("Please select the dates correctly");
        }
        if(num==2){
            alertDialog.setMessage("can't go more than 3 spots in a day");
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    private void showLocation(String sDestination) {
        String sSource = "Coxs Bazar";
        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+sSource+"/"+sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}