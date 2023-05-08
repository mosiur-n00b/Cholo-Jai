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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class khagrachori extends AppCompatActivity {
    private Button next,romancho,ghuraghuri;
    private CheckBox matai,panchari,mayabini,mung,alutila,hatimura,risang;
    private LinearLayout mataiLayout,panchariLayout,mayabiniLayout,mungLayout,alutilaLayout,hatimuraLayout,risangLayout;
    private int person;
    private String email;
    private DatabaseReference rref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khagrachori);

        next = (Button) findViewById(R.id.next);
        matai =(CheckBox)findViewById(R.id.matai);
        panchari =(CheckBox)findViewById(R.id.panchari);
        mayabini =(CheckBox)findViewById(R.id.mayabini);
        mung =(CheckBox)findViewById(R.id.mung);
        alutila =(CheckBox)findViewById(R.id.alutila);
        hatimura =(CheckBox)findViewById(R.id.hatimura);
        risang =(CheckBox)findViewById(R.id.risang);
        mataiLayout = (LinearLayout)findViewById(R.id.mataiLayout);
        panchariLayout = (LinearLayout)findViewById(R.id.panchariLayout);
        mayabiniLayout = (LinearLayout)findViewById(R.id.mayabiniLayout);
        mungLayout = (LinearLayout)findViewById(R.id.mungLayout);
        alutilaLayout = (LinearLayout)findViewById(R.id.alutilaLayout);
        hatimuraLayout = (LinearLayout)findViewById(R.id.hatimuraLayout);
        risangLayout = (LinearLayout)findViewById(R.id.risangLayout);
        romancho = (Button) findViewById(R.id.romancho);
        ghuraghuri = (Button) findViewById(R.id.ghuraghuri);

        email = getIntent().getStringExtra("email");

        romancho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Romancho",2,5000);
            }
        });

        ghuraghuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Ghuraghuri",3,7200);
            }
        });

        matai.setClickable(false);
        mataiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!matai.isChecked()){
                    matai.setChecked(true);
                    matai.setTextColor(getResources().getColor(R.color.teal_900));
                    mataiLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    matai.setChecked(false);
                    matai.setTextColor(getResources().getColor(R.color.black));
                    mataiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        panchari.setClickable(false);
        panchariLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!panchari.isChecked()){
                    panchari.setChecked(true);
                    panchari.setTextColor(getResources().getColor(R.color.teal_900));
                    panchariLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    panchari.setChecked(false);
                    panchari.setTextColor(getResources().getColor(R.color.black));
                    panchariLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        mayabini.setClickable(false);
        mayabiniLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!mayabini.isChecked()){
                    mayabini.setChecked(true);
                    mayabini.setTextColor(getResources().getColor(R.color.teal_900));
                    mayabiniLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    mayabini.setChecked(false);
                    mayabini.setTextColor(getResources().getColor(R.color.black));
                    mayabiniLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        mung.setClickable(false);
        mungLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!mung.isChecked()){
                    mung.setChecked(true);
                    matai.setTextColor(getResources().getColor(R.color.teal_900));
                    mungLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    mung.setChecked(false);
                    mung.setTextColor(getResources().getColor(R.color.black));
                    mungLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        alutila.setClickable(false);
        alutilaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!alutila.isChecked()){
                    alutila.setChecked(true);
                    alutila.setTextColor(getResources().getColor(R.color.teal_900));
                    alutilaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    alutila.setChecked(false);
                    alutila.setTextColor(getResources().getColor(R.color.black));
                    alutilaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        hatimura.setClickable(false);
        hatimuraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!hatimura.isChecked()){
                    hatimura.setChecked(true);
                    hatimura.setTextColor(getResources().getColor(R.color.teal_900));
                    hatimuraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    hatimura.setChecked(false);
                    hatimura.setTextColor(getResources().getColor(R.color.black));
                    hatimuraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        risang.setClickable(false);
        risangLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!risang.isChecked()){
                    risang.setChecked(true);
                    matai.setTextColor(getResources().getColor(R.color.teal_900));
                    risangLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    risang.setChecked(false);
                    risang.setTextColor(getResources().getColor(R.color.black));
                    risangLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(matai.isChecked()){
                    count++;
                }
                if(panchari.isChecked()){
                    count++;
                }
                if(mayabini.isChecked()){
                    count++;
                }
                if(mung.isChecked()){
                    count++;
                }
                if(alutila.isChecked()){
                    count++;
                }
                if(hatimura.isChecked()){
                    count++;
                }
                if(risang.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(khagrachori.this).create();
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
                    Intent intent= new Intent(khagrachori.this,khagrachari_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Khagrachari");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });

    }

    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(khagrachori.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(khagrachori.this);
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
                            Intent intent_6 = new Intent(khagrachori.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Khagrachari");
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