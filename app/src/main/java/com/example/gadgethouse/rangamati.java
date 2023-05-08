package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class rangamati extends AppCompatActivity {

    private CheckBox sajek,kaptai,rajban,shuvolong,hazachora,happy,komlok;
    private LinearLayout sajekLayout,kaptaiLayout,rajbanLayout,shuvolongLayout,hazachoraLayout,happyLayout,komlokLayout;
    private Button next;
    private int person;
    private String email;
    private Button jolkona,meghrajjo;
    private DatabaseReference rref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangamati);

        email = getIntent().getStringExtra("email");
        sajek =(CheckBox)findViewById(R.id.sajek);
        kaptai =(CheckBox)findViewById(R.id.kaptai);
        rajban =(CheckBox)findViewById(R.id.rajban);
        shuvolong=(CheckBox)findViewById(R.id.shuvolong);
        hazachora =(CheckBox)findViewById(R.id.hazachora);
        happy =(CheckBox)findViewById(R.id.happy);
        komlok =(CheckBox)findViewById(R.id.komlok);
        sajekLayout = (LinearLayout)findViewById(R.id.sajekLayout);
        kaptaiLayout = (LinearLayout)findViewById(R.id.kaptaiLayout);
        rajbanLayout = (LinearLayout)findViewById(R.id.rajbanLayout);
        shuvolongLayout= (LinearLayout)findViewById(R.id.shuvolongLayout);
        hazachoraLayout = (LinearLayout)findViewById(R.id.hazachoraLayout);
        happyLayout= (LinearLayout) findViewById(R.id.happyLayout);
        komlokLayout = (LinearLayout)findViewById(R.id.komlokLayout);
        next = (Button) findViewById(R.id.next);
        jolkona = (Button) findViewById(R.id.jolkona);
        meghrajjo = (Button) findViewById(R.id.meghrajjo);

        jolkona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Jolkona",2,5100);
            }
        });
        meghrajjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Meghrajjo",4,9000);
            }
        });

        sajek.setClickable(false);
        sajekLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!sajek.isChecked()){
                    sajek.setChecked(true);
                    sajek.setTextColor(getResources().getColor(R.color.teal_900));
                    sajekLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    sajek.setChecked(false);
                    sajek.setTextColor(getResources().getColor(R.color.black));
                    sajekLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        kaptai.setClickable(false);
        kaptaiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!kaptai.isChecked()){
                    kaptai.setChecked(true);
                    kaptai.setTextColor(getResources().getColor(R.color.teal_900));
                    kaptaiLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    kaptai.setChecked(false);
                    kaptai.setTextColor(getResources().getColor(R.color.black));
                    kaptaiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        rajban.setClickable(false);
        rajbanLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!rajban.isChecked()){
                    rajban.setChecked(true);
                    rajban.setTextColor(getResources().getColor(R.color.teal_900));
                    rajbanLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    rajban.setChecked(false);
                    rajban.setTextColor(getResources().getColor(R.color.black));
                    rajbanLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        shuvolong.setClickable(false);
        shuvolongLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!shuvolong.isChecked()){
                    shuvolong.setChecked(true);
                    shuvolong.setTextColor(getResources().getColor(R.color.teal_900));
                    shuvolongLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    shuvolong.setChecked(false);
                    shuvolong.setTextColor(getResources().getColor(R.color.black));
                    shuvolongLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        hazachora.setClickable(false);
        hazachoraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!hazachora.isChecked()){
                    hazachora.setChecked(true);
                    hazachora.setTextColor(getResources().getColor(R.color.teal_900));
                    hazachoraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    hazachora.setChecked(false);
                    hazachora.setTextColor(getResources().getColor(R.color.black));
                    hazachoraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        happy.setClickable(false);
        happyLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!happy.isChecked()){
                    happy.setChecked(true);
                    happy.setTextColor(getResources().getColor(R.color.teal_900));
                    happyLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    happy.setChecked(false);
                    happy.setTextColor(getResources().getColor(R.color.black));
                    happyLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        komlok.setClickable(false);
        komlokLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!komlok.isChecked()){
                    komlok.setChecked(true);
                    komlok.setTextColor(getResources().getColor(R.color.teal_900));
                    komlokLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    komlok.setChecked(false);
                    komlok.setTextColor(getResources().getColor(R.color.black));
                    komlokLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });


        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(sajek.isChecked()){
                    count++;
                }
                if(kaptai.isChecked()){
                    count++;
                }
                if(rajban.isChecked()){
                    count++;
                }
                if(shuvolong.isChecked()){
                    count++;
                }
                if(hazachora.isChecked()){
                    count++;
                }
                if(happy.isChecked()){
                    count++;
                }
                if(komlok.isChecked()){
                    count++;
                }


                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(rangamati.this).create();
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
                    Intent intent= new Intent(rangamati.this,rangamati_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Rangamati");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
    }
    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(rangamati.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(rangamati.this);
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
                            Intent intent_6 = new Intent(rangamati.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Rangamati");
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