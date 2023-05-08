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

public class chittagong extends AppCompatActivity {
    private Button next,jolorashi,anondo;
    private CheckBox bashbaria,banshkhali,sonaichhori,kodala,bawachhora,khoiyachhora,sandwip;
    private LinearLayout bashbariaLayout,banshkhaliLayout,sonaichhoriLayout,kodalaLayout,bawachhoraLayout,khoiyachhoraLayout,sandwipLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong);

        email = getIntent().getStringExtra("email");

        next = (Button) findViewById(R.id.next);
        bashbaria =(CheckBox)findViewById(R.id.bashbaria);
        banshkhali =(CheckBox)findViewById(R.id.banshkhali);
        sonaichhori =(CheckBox)findViewById(R.id.sonaichhori);
        kodala =(CheckBox)findViewById(R.id.kodala);
        bawachhora =(CheckBox)findViewById(R.id.bawachhora);
        khoiyachhora =(CheckBox)findViewById(R.id.khoiyachhora);
        sandwip =(CheckBox)findViewById(R.id.sandwip);
        bashbariaLayout = (LinearLayout)findViewById(R.id.bashbariaLayout);
        banshkhaliLayout = (LinearLayout)findViewById(R.id.banshkhaliLayout);
        sonaichhoriLayout = (LinearLayout)findViewById(R.id.sonaichhoriLayout);
        kodalaLayout = (LinearLayout)findViewById(R.id.kodalaLayout);
        bawachhoraLayout = (LinearLayout)findViewById(R.id.bawachhoraLayout);
        khoiyachhoraLayout= (LinearLayout) findViewById(R.id.khoiyachhoraLayout);
        sandwipLayout = (LinearLayout)findViewById(R.id.sandwipLayout);
        jolorashi = (Button) findViewById(R.id.jolorashi);
        anondo = (Button) findViewById(R.id.anondo);

        jolorashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Jolorashi",4,9000);
            }
        });

        anondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Anondo",3,7500);
            }
        });

        bashbaria.setClickable(false);
        bashbariaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!bashbaria.isChecked()){
                    bashbaria.setChecked(true);
                    bashbaria.setTextColor(getResources().getColor(R.color.teal_900));
                    bashbariaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    bashbaria.setChecked(false);
                    bashbaria.setTextColor(getResources().getColor(R.color.black));
                    bashbariaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        banshkhali.setClickable(false);
        banshkhaliLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!banshkhali.isChecked()){
                    banshkhali.setChecked(true);
                    banshkhali.setTextColor(getResources().getColor(R.color.teal_900));
                    banshkhaliLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    banshkhali.setChecked(false);
                    banshkhali.setTextColor(getResources().getColor(R.color.black));
                    banshkhaliLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        sonaichhori.setClickable(false);
        sonaichhoriLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!sonaichhori.isChecked()){
                    sonaichhori.setChecked(true);
                    sonaichhori.setTextColor(getResources().getColor(R.color.teal_900));
                    sonaichhoriLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    sonaichhori.setChecked(false);
                    sonaichhori.setTextColor(getResources().getColor(R.color.black));
                    sonaichhoriLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        kodala.setClickable(false);
        kodalaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!kodala.isChecked()){
                    kodala.setChecked(true);
                    kodala.setTextColor(getResources().getColor(R.color.teal_900));
                    kodalaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    kodala.setChecked(false);
                    kodala.setTextColor(getResources().getColor(R.color.black));
                    kodalaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        bawachhora.setClickable(false);
        bawachhoraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!bawachhora.isChecked()){
                    bawachhora.setChecked(true);
                    bawachhora.setTextColor(getResources().getColor(R.color.teal_900));
                    bawachhoraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    bawachhora.setChecked(false);
                    bawachhora.setTextColor(getResources().getColor(R.color.black));
                    bawachhoraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        khoiyachhora.setClickable(false);
        khoiyachhoraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!khoiyachhora.isChecked()){
                    khoiyachhora.setChecked(true);
                    khoiyachhora.setTextColor(getResources().getColor(R.color.teal_900));
                    khoiyachhoraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    khoiyachhora.setChecked(false);
                    khoiyachhora.setTextColor(getResources().getColor(R.color.black));
                    khoiyachhoraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        sandwip.setClickable(false);
        sandwipLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!sandwip.isChecked()){
                    sandwip.setChecked(true);
                    sandwip.setTextColor(getResources().getColor(R.color.teal_900));
                    sandwipLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    sandwip.setChecked(false);
                    sandwip.setTextColor(getResources().getColor(R.color.black));
                    sandwipLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(bashbaria.isChecked()){
                    count++;
                }
                if(banshkhali.isChecked()){
                    count++;
                }
                if(sonaichhori.isChecked()){
                    count++;
                }
                if(kodala.isChecked()){
                    count++;
                }
                if(bawachhora.isChecked()){
                    count++;
                }
                if(khoiyachhora.isChecked()){
                    count++;
                }
                if(sandwip.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(chittagong.this).create();
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
                    Intent intent= new Intent(chittagong.this,chittagong_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Chittagong");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }
        });
    }

    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(chittagong.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(chittagong.this);
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
                            Intent intent_6 = new Intent(chittagong.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Chittagong");
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