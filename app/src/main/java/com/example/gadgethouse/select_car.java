package com.example.gadgethouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class select_car extends AppCompatActivity {
    private Button ok2;
    private int hotelCost, numberOfSpot,numOfPerson,numOfDays;
    private String location,email;
    private RadioGroup carSelection;
    int carRent,numbOfCar=1;
    private Button minus_car,plus_car;
    private TextView showNumberOfCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);

        email = getIntent().getStringExtra("email");
        hotelCost = getIntent().getIntExtra("hotelCost",0);
        numberOfSpot = getIntent().getIntExtra("numberOfSpot",0);
        numOfPerson = getIntent().getIntExtra("numberOfPerson",0);
        numOfDays = getIntent().getIntExtra("numberOfDays",0);
        location = getIntent().getStringExtra("location");

        minus_car = (Button)findViewById(R.id.minus_car);
        plus_car = (Button)findViewById(R.id.plus_car);
        showNumberOfCar = (TextView)findViewById(R.id.showNumberOfCar);
        plus_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numbOfCar<10){
                    numbOfCar++;
                }
                showNumberOfCar.setText(String.valueOf(numbOfCar));
            }
        });
        minus_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numbOfCar>1) {
                    numbOfCar--;
                    showNumberOfCar.setText(String.valueOf(numbOfCar));
                }
            }
        });
        
        ok2 = (Button) findViewById(R.id.ok2);
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carDetails();
            }
        });
    }

        public void carDetails(){
        carSelection = (RadioGroup) findViewById(R.id.carSelection);
        int checkId = carSelection.getCheckedRadioButtonId();

        if(checkId==-1){
            Toast toast = Toast.makeText(getApplicationContext(),"Select your car first",Toast.LENGTH_SHORT);
            toast.getView().setBackgroundColor(Color.parseColor("#d6d6c2"));
            toast.show();
        }
        else{
            switch(checkId){
                case R.id.car1:
                    carRent = 4000*numbOfCar;
                    break;
                case R.id.car2:
                    carRent = 6000*numbOfCar;
                    break;
                case R.id.car3:
                    carRent = 11000*numbOfCar;
                    break;
                case R.id.car4:
                    carRent = 4500*numbOfCar;
                    break;
                case R.id.car5:
                    carRent = 9500*numbOfCar;
                    break;
            }
            Intent intent_4= new Intent(select_car.this,receipt.class);
            intent_4.putExtra("location",location);
            intent_4.putExtra("hotelCost",hotelCost);
            intent_4.putExtra("numberOfPerson",numOfPerson);
            intent_4.putExtra("numberOfDays",numOfDays);
            intent_4.putExtra("numberOfSpot",numberOfSpot);
            intent_4.putExtra("totalCarRent",carRent);
            intent_4.putExtra("email",email);
            startActivity(intent_4);
        }
    }
}