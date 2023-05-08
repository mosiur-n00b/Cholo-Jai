package com.example.gadgethouse;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class receipt extends AppCompatActivity {
    private int  numberOfSpot,numOfPerson,numOfDays,hotelCost,carRent;
    private String location,email;
    private TextView sview,hotelview,transportview,totalview,totalvatview;
    private Button back,confirm;
    String summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        email = getIntent().getStringExtra("email");
        numberOfSpot = getIntent().getIntExtra("numberOfSpot",0);
        location = getIntent().getStringExtra("location");
        numOfPerson = getIntent().getIntExtra("numberOfPerson",0);
        numOfDays = getIntent().getIntExtra("numberOfDays",0);
        hotelCost = getIntent().getIntExtra("hotelCost",0);
        carRent = getIntent().getIntExtra("totalCarRent",0);

        summary = "You're total "+numOfPerson+" persons "+" and your trip in "+location+" is for "+numOfDays+" days.";
        sview = (TextView)findViewById(R.id.sview);
        sview.setText(String.valueOf(summary));

        hotelview = (TextView)findViewById(R.id.hotelview);
        int totalHotelCost = hotelCost * numOfDays;
        hotelview.setText(String.valueOf(totalHotelCost));

        transportview = (TextView)findViewById(R.id.transportview);
        int totalCarRent = carRent * numOfDays;
        transportview.setText(String.valueOf(totalCarRent));

        totalview = (TextView)findViewById(R.id.totalview);
        int totalCost = totalHotelCost+totalCarRent;
        totalview.setText(String.valueOf(totalCost));

        totalvatview = (TextView)findViewById(R.id.totalvatview);
        float finalCost = (float)(totalCost+totalCost*.05);
        totalvatview.setText(String.valueOf((int)finalCost));

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_5= new Intent(receipt.this,district.class);
                startActivity(intent_5);
            }
        });

        confirm  = (Button)findViewById(R.id.confirm );
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_5= new Intent(receipt.this,general_Form.class);
                intent_5.putExtra("location",location);
                intent_5.putExtra("hotelCost",hotelCost);
                intent_5.putExtra("numberOfDays",numOfDays);
                intent_5.putExtra("numberOfPerson",numOfPerson);
                intent_5.putExtra("numberOfPerson",carRent);
                intent_5.putExtra("numberOfSpot",numberOfSpot);
                intent_5.putExtra("totalCost",(int)finalCost);
                intent_5.putExtra("email",email);
                intent_5.putExtra("selection","asyourwish");
                startActivity(intent_5);
            }
        });
    }
}