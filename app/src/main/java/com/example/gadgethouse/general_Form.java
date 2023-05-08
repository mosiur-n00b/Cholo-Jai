package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class general_Form extends AppCompatActivity {
    private int  numberOfSpot,numOfPerson,numOfDays,hotelCost,carRent,totalCost,dpersonnum;
    private String location,email,selection,userName,usermobile,userBkash,userNID;
    private TextView bkashText,emailView;
    private EditText name,mobile,idNo,bkashNum;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general__form);

        numberOfSpot = getIntent().getIntExtra("numberOfSpot",0);
        numOfDays = getIntent().getIntExtra("numberOfDays",0);
        hotelCost = getIntent().getIntExtra("hotelCost",0);
        carRent = getIntent().getIntExtra("totalCarRent",0);
        location = getIntent().getStringExtra("location");
        email = getIntent().getStringExtra("email");
        numOfPerson = getIntent().getIntExtra("numberOfPerson",0);
        totalCost = getIntent().getIntExtra("totalCost",0);
        selection =  getIntent().getStringExtra("selection");
        dpersonnum = getIntent().getIntExtra("dPersonNum",0);

        bkashText = (TextView)findViewById(R.id.bkashText);
        name = (EditText)findViewById(R.id.name);
        mobile = (EditText)findViewById(R.id.mobile);
        idNo = (EditText)findViewById(R.id.idNo);
        bkashNum =(EditText)findViewById(R.id.bkashNum);
        emailView = (TextView)findViewById(R.id.emailView);
        confirmButton = (Button)findViewById(R.id.confirmButton );

        String showBkashInfo;
        showBkashInfo = "Please pay first " + totalCost+ " taka in Bkash 01517006328 number";
        bkashText.setText(showBkashInfo);

        emailView.setText(email);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = name.getText().toString().trim();
                usermobile = mobile.getText().toString().trim();
                userBkash = bkashNum.getText().toString().trim();
                userNID = idNo.getText().toString().trim();

                if(userName.isEmpty()){
                    name.setError("Full name is required");
                    name.requestFocus();
                    return;
                }
                if(usermobile.isEmpty() || usermobile.length()!=11){
                    mobile.setError("plz give the valid mobile no");
                    mobile.requestFocus();
                    return;
                }
                if(userNID.isEmpty()){
                    idNo.setError("NID numder s required");
                    idNo.requestFocus();
                    return;
                }
                if(userBkash.isEmpty() || userBkash.length()!=11){
                    bkashNum.setError("Plz check your number again");
                    bkashNum.requestFocus();
                    return;
                }

                Toast.makeText(getApplicationContext(),"We will send confirmation email within 24 hours",Toast.LENGTH_SHORT).show();

                dataHolder obj = new dataHolder(email,location,usermobile,userName,userNID,selection,userBkash,numOfPerson,totalCost);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("customer");
                node.child(usermobile).setValue(obj);

                if(selection.equals("packages")){
                    dataHolder2 obj2= new dataHolder2(dpersonnum);
                    FirebaseDatabase db2 = FirebaseDatabase.getInstance();
                    DatabaseReference node2 = db2.getReference("forPackage");
                    node2.setValue(obj2);
                }
                finishAffinity();
                System.exit(0);
            }
        });

    }
}