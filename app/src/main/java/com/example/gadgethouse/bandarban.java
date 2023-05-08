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

public class
bandarban extends AppCompatActivity {
    private Button next,kashmiri,arannya;
    private CheckBox nafakhum,buddhadhatu,chimbuk,damtua,alicave,marayan,tindu;
    private LinearLayout nafakhumLayout,buddhadhatuLayout,chimbukLayout,damtuaLayout,alicaveLayout,marayanLayout,tinduLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandarban);

        email = getIntent().getStringExtra("email");

        next = (Button) findViewById(R.id.next);
        nafakhum =(CheckBox)findViewById(R.id.nafakhum);
        buddhadhatu =(CheckBox)findViewById(R.id.buddhadhatu);
        chimbuk =(CheckBox)findViewById(R.id.chimbuk);
        damtua =(CheckBox)findViewById(R.id.damtua);
        alicave =(CheckBox)findViewById(R.id.alicave);
        marayan =(CheckBox)findViewById(R.id.marayan);
        tindu =(CheckBox)findViewById(R.id.tindu);
        nafakhumLayout = (LinearLayout)findViewById(R.id.nafakhumLayout);
        buddhadhatuLayout = (LinearLayout)findViewById(R.id.buddhadhatuLayout);
        chimbukLayout = (LinearLayout)findViewById(R.id.chimbukLayout);
        damtuaLayout = (LinearLayout)findViewById(R.id.damtuaLayout);
        alicaveLayout = (LinearLayout)findViewById(R.id.alicaveLayout);
        marayanLayout= (LinearLayout) findViewById(R.id.marayanLayout);
        tinduLayout = (LinearLayout)findViewById(R.id.tinduLayout);
        nafakhum.setClickable(false);
        kashmiri = (Button) findViewById(R.id.kashmiri);
        arannya = (Button) findViewById(R.id.arannya);

        kashmiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Kashmiri",4,10000);
            }
        });

        arannya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Arannya",3,5000);
            }
        });

        nafakhumLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!nafakhum.isChecked()){
                    nafakhum.setChecked(true);
                    nafakhum.setTextColor(getResources().getColor(R.color.teal_900));
                    nafakhumLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    nafakhum.setChecked(false);
                    nafakhum.setTextColor(getResources().getColor(R.color.black));
                    nafakhumLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        buddhadhatu.setClickable(false);
        buddhadhatuLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!buddhadhatu.isChecked()){
                    buddhadhatu.setChecked(true);
                    buddhadhatu.setTextColor(getResources().getColor(R.color.teal_900));
                    buddhadhatuLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    buddhadhatu.setChecked(false);
                    buddhadhatu.setTextColor(getResources().getColor(R.color.black));
                    buddhadhatuLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        chimbuk.setClickable(false);
        chimbukLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!chimbuk.isChecked()){
                    chimbuk.setChecked(true);
                    chimbuk.setTextColor(getResources().getColor(R.color.teal_900));
                    chimbukLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    chimbuk.setChecked(false);
                    chimbuk.setTextColor(getResources().getColor(R.color.black));
                    chimbukLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        damtua.setClickable(false);
        damtuaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!damtua.isChecked()){
                    damtua.setChecked(true);
                    damtua.setTextColor(getResources().getColor(R.color.teal_900));
                    damtuaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    damtua.setChecked(false);
                    damtua.setTextColor(getResources().getColor(R.color.black));
                    damtuaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        alicave.setClickable(false);
        alicaveLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!alicave.isChecked()){
                    alicave.setChecked(true);
                    alicave.setTextColor(getResources().getColor(R.color.teal_900));
                    alicaveLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    alicave.setChecked(false);
                    alicave.setTextColor(getResources().getColor(R.color.black));
                    alicaveLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        marayan.setClickable(false);
        marayanLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!marayan.isChecked()){
                    marayan.setChecked(true);
                    marayan.setTextColor(getResources().getColor(R.color.teal_900));
                    marayanLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    marayan.setChecked(false);
                    marayan.setTextColor(getResources().getColor(R.color.black));
                    marayanLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        tindu.setClickable(false);
        tinduLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!tindu.isChecked()){
                    tindu.setChecked(true);
                    tindu.setTextColor(getResources().getColor(R.color.teal_900));
                    tinduLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    tindu.setChecked(false);
                    tindu.setTextColor(getResources().getColor(R.color.black));
                    tinduLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(nafakhum.isChecked()){
                    count++;
                }
                if(buddhadhatu.isChecked()){
                    count++;
                }
                if(chimbuk.isChecked()){
                    count++;
                }
                if(damtua.isChecked()){
                    count++;
                }
                if(alicave.isChecked()){
                    count++;
                }
                if(marayan.isChecked()){
                    count++;
                }
                if(tindu.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(bandarban.this).create();
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
                    Intent intent= new Intent(bandarban.this,bandarban_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Bandarban");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }
        });

    }
    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(bandarban.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(bandarban.this);
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
                            Intent intent_6 = new Intent(bandarban.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Bandarban");
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