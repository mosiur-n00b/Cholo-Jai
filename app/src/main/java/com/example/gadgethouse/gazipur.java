package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class gazipur extends AppCompatActivity {

    private Button next,kuthibari,humayan;
    private CheckBox safari,shamshanswari,nationalpark,ekdala,basecamp,nicolas,seagullresort;
    private LinearLayout safariLayout,shamshanswariLayout,nationalparkLayout,ekdalaLayout,basecampLayout,nicolasLayout,seagullresortLayout;
    private int person;
    private String email;
    private DatabaseReference rref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazipur);
        email = getIntent().getStringExtra("email");

        next = (Button) findViewById(R.id.next);
        safari =(CheckBox)findViewById(R.id.safari);
        shamshanswari =(CheckBox)findViewById(R.id.shamshanswari);
        nationalpark =(CheckBox)findViewById(R.id.nationalpark);
        ekdala =(CheckBox)findViewById(R.id.ekdala);
        basecamp =(CheckBox)findViewById(R.id.basecamp);
        nicolas =(CheckBox)findViewById(R.id.nicolas);
        seagullresort =(CheckBox)findViewById(R.id.seagullresort);
        safariLayout = (LinearLayout)findViewById(R.id.safariLayout);
        shamshanswariLayout = (LinearLayout)findViewById(R.id.shamshanswariLayout);
        nationalparkLayout = (LinearLayout)findViewById(R.id.nationalparkLayout);
        ekdalaLayout = (LinearLayout)findViewById(R.id.ekdalaLayout);
        basecampLayout = (LinearLayout)findViewById(R.id.basecampLayout);
        nicolasLayout= (LinearLayout) findViewById(R.id.nicolasLayout);
        seagullresortLayout = (LinearLayout)findViewById(R.id.seagullresortLayout);
        kuthibari= (Button) findViewById(R.id.kuthibari);
        humayan = (Button) findViewById(R.id.humayan);

        kuthibari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Kuthibari",2,3000);
            }
        });

        humayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Humayan",3,7500);
            }
        });

        safari.setClickable(false);
        safariLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!safari.isChecked()){
                    safari.setChecked(true);
                    safari.setTextColor(getResources().getColor(R.color.teal_900));
                    safariLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    safari.setChecked(false);
                    safari.setTextColor(getResources().getColor(R.color.black));
                    safariLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        shamshanswari.setClickable(false);
        shamshanswariLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!shamshanswari.isChecked()){
                    shamshanswari.setChecked(true);
                    shamshanswari.setTextColor(getResources().getColor(R.color.teal_900));
                    shamshanswariLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    shamshanswari.setChecked(false);
                    shamshanswari.setTextColor(getResources().getColor(R.color.black));
                    shamshanswariLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        nationalpark.setClickable(false);
        nationalparkLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!nationalpark.isChecked()){
                    nationalpark.setChecked(true);
                    nationalpark.setTextColor(getResources().getColor(R.color.teal_900));
                    nationalparkLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    nationalpark.setChecked(false);
                    nationalpark.setTextColor(getResources().getColor(R.color.black));
                    nationalparkLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        ekdala.setClickable(false);
        ekdalaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!ekdala.isChecked()){
                    ekdala.setChecked(true);
                    ekdala.setTextColor(getResources().getColor(R.color.teal_900));
                    ekdalaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    ekdala.setChecked(false);
                    ekdala.setTextColor(getResources().getColor(R.color.black));
                    ekdalaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        basecamp.setClickable(false);
        basecampLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!basecamp.isChecked()){
                    basecamp.setChecked(true);
                    basecamp.setTextColor(getResources().getColor(R.color.teal_900));
                    basecampLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    basecamp.setChecked(false);
                    basecamp.setTextColor(getResources().getColor(R.color.black));
                    basecampLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        nicolas.setClickable(false);
        nicolasLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!nicolas.isChecked()){
                    nicolas.setChecked(true);
                    nicolas.setTextColor(getResources().getColor(R.color.teal_900));
                    nicolasLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    nicolas.setChecked(false);
                    nicolas.setTextColor(getResources().getColor(R.color.black));
                    nicolasLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        seagullresort.setClickable(false);
        seagullresortLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!seagullresort.isChecked()){
                    seagullresort.setChecked(true);
                    seagullresort.setTextColor(getResources().getColor(R.color.teal_900));
                    seagullresortLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    seagullresort.setChecked(false);
                    seagullresort.setTextColor(getResources().getColor(R.color.black));
                    seagullresortLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(safari.isChecked()){
                    count++;
                }
                if(shamshanswari.isChecked()){
                    count++;
                }
                if(nationalpark.isChecked()){
                    count++;
                }
                if(ekdala.isChecked()){
                    count++;
                }
                if(basecamp.isChecked()){
                    count++;
                }
                if(nicolas.isChecked()){
                    count++;
                }
                if(seagullresort.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(gazipur.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please select at least one spot first");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    Intent intent= new Intent(gazipur.this,gazipur_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Gazipur");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }
        });

    }

    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(gazipur.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(gazipur.this);
        input_2.setInputType(InputType.TYPE_CLASS_NUMBER);
        ad.setView(input_2);
        ad.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                rref = FirebaseDatabase.getInstance().getReference().child("forPackage");
                rref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int dpersonnum = Integer.parseInt(snapshot.child("personNum").getValue().toString());

                        person = Integer.parseInt(input_2.getText().toString());
                        if(person==0){
                            Toast.makeText(getApplicationContext(),"Please give a valid number",Toast.LENGTH_SHORT).show();
                        }
                        else if(person>dpersonnum){
                            Toast.makeText(getApplicationContext(),"you can add "+dpersonnum+" persons",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent intent_6 = new Intent(gazipur.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Gazipur");
                            intent_6.putExtra("dPersonNum",dpersonnum-person);
                            startActivity(intent_6);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
        ad.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        ad.show();
    }
}