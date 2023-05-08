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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tangail extends AppCompatActivity {
    private Button next,kashmiri,jomidari;
    private CheckBox mohera,pirgachha,porir,dome,madhupur,dhanbari,atia;
    private LinearLayout moheraLayout,pirgachhaLayout,porirLayout,domeLayout,madhupurLayout,dhanbariLayout,atiaLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tangail);

        email = getIntent().getStringExtra("email");

        mohera =(CheckBox)findViewById(R.id.mohera);
        pirgachha =(CheckBox)findViewById(R.id.pirgachha);
        porir =(CheckBox)findViewById(R.id.porir);
        dome =(CheckBox)findViewById(R.id.dome);
        madhupur =(CheckBox)findViewById(R.id.madhupur);
        dhanbari =(CheckBox)findViewById(R.id.dhanbari);
        atia =(CheckBox)findViewById(R.id.atia);
        moheraLayout = (LinearLayout)findViewById(R.id.moheraLayout);
        pirgachhaLayout = (LinearLayout)findViewById(R.id.pirgachhaLayout);
        porirLayout = (LinearLayout)findViewById(R.id.porirLayout);
        domeLayout = (LinearLayout)findViewById(R.id.domeLayout);
        madhupurLayout = (LinearLayout)findViewById(R.id.madhupurLayout);
        dhanbariLayout = (LinearLayout)findViewById(R.id.dhanbariLayout);
        atiaLayout = (LinearLayout)findViewById(R.id.atiaLayout);
        kashmiri = (Button) findViewById(R.id.kashmiri);
        jomidari = (Button) findViewById(R.id.jomidari);
        next = (Button) findViewById(R.id.next);

        kashmiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Kashmiri",2,4000);
            }
        });

        jomidari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Jomidari",4,9000);
            }
        });

        mohera.setClickable(false);
        moheraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!mohera.isChecked()){
                    mohera.setChecked(true);
                    mohera.setTextColor(getResources().getColor(R.color.teal_900));
                    moheraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    mohera.setChecked(false);
                    mohera.setTextColor(getResources().getColor(R.color.black));
                    moheraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        pirgachha.setClickable(false);
        pirgachhaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!pirgachha.isChecked()){
                    pirgachha.setChecked(true);
                    pirgachha.setTextColor(getResources().getColor(R.color.teal_900));
                    pirgachhaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    pirgachha.setChecked(false);
                    pirgachha.setTextColor(getResources().getColor(R.color.black));
                    pirgachhaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        porir.setClickable(false);
        porirLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!porir.isChecked()){
                    porir.setChecked(true);
                    porir.setTextColor(getResources().getColor(R.color.teal_900));
                    porirLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    porir.setChecked(false);
                    porir.setTextColor(getResources().getColor(R.color.black));
                    porirLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        dome.setClickable(false);
        domeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!dome.isChecked()){
                    dome.setChecked(true);
                    dome.setTextColor(getResources().getColor(R.color.teal_900));
                    domeLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    dome.setChecked(false);
                    dome.setTextColor(getResources().getColor(R.color.black));
                    domeLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        madhupur.setClickable(false);
        madhupurLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!madhupur.isChecked()){
                    madhupur.setChecked(true);
                    madhupur.setTextColor(getResources().getColor(R.color.teal_900));
                    madhupurLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    madhupur.setChecked(false);
                    madhupur.setTextColor(getResources().getColor(R.color.black));
                    madhupurLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        dhanbari.setClickable(false);
        dhanbariLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!dhanbari.isChecked()){
                    dhanbari.setChecked(true);
                    dhanbari.setTextColor(getResources().getColor(R.color.teal_900));
                    dhanbariLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    dhanbari.setChecked(false);
                    dhanbari.setTextColor(getResources().getColor(R.color.black));
                    dhanbariLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        atia.setClickable(false);
        atiaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if(!atia.isChecked()){
                    atia.setChecked(true);
                    atia.setTextColor(getResources().getColor(R.color.teal_900));
                    atiaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    atia.setChecked(false);
                    atia.setTextColor(getResources().getColor(R.color.black));
                    atiaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(mohera.isChecked()){
                    count++;
                }
                if(pirgachha.isChecked()){
                    count++;
                }
                if(porir.isChecked()){
                    count++;
                }
                if(dome.isChecked()){
                    count++;
                }
                if(madhupur.isChecked()){
                    count++;
                }
                if(dhanbari.isChecked()){
                    count++;
                }
                if(atia.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(tangail.this).create();
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
                    Intent intent= new Intent(tangail.this,tangail_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Tangail");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
    }
    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(tangail.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(tangail.this);
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
                            Intent intent_6 = new Intent(tangail.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Tangail");
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