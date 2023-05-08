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

public class sylhet extends AppCompatActivity {

    private Button jolshiri,gohin,next;
    private TextView jolshiri_cost, gohin_cost;
    private CheckBox hakaluki,malni,panthumai,bisnakandi,dibir,songrampunji,shah,lovachora;
    private LinearLayout hakalukiLayout,malniLayout,panthumaiLayout,bisnakandiLayout,dibirLayout,songrampunjiLayout,shahLayout,lovachoraLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylhet);

        email = getIntent().getStringExtra("email");

        jolshiri_cost = (TextView)findViewById(R.id.jolshiri_cost);
        gohin_cost = (TextView)findViewById(R.id.gohin_cost);

        jolshiri = (Button) findViewById(R.id.jolshiri);
        gohin = (Button) findViewById(R.id.gohin);
        hakaluki =(CheckBox)findViewById(R.id.hakaluki);
        malni =(CheckBox)findViewById(R.id.malni);
        panthumai =(CheckBox)findViewById(R.id.panthumai);
        bisnakandi=(CheckBox)findViewById(R.id.bisnakandi);
        dibir =(CheckBox)findViewById(R.id.dibir);
        songrampunji =(CheckBox)findViewById(R.id.songrampunji);
        shah =(CheckBox)findViewById(R.id.shah);
        lovachora =(CheckBox)findViewById(R.id.lovachora);
        hakalukiLayout = (LinearLayout)findViewById(R.id.hakalukiLayout);
        malniLayout = (LinearLayout)findViewById(R.id.malniLayout);
        panthumaiLayout = (LinearLayout)findViewById(R.id.panthumaiLayout);
       bisnakandiLayout = (LinearLayout)findViewById(R.id.bisnakandiLayout);
        dibirLayout = (LinearLayout)findViewById(R.id.dibirLayout);
        songrampunjiLayout= (LinearLayout) findViewById(R.id.songrampunjiLayout);
        shahLayout = (LinearLayout)findViewById(R.id.shahLayout);
        lovachoraLayout = (LinearLayout)findViewById(R.id.lovachoraLayout);
        next = (Button) findViewById(R.id.next);

        jolshiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Jolshiri",3,4000);
            }
        });

        gohin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Gohin",4,9000);
            }
        });


        hakaluki.setClickable(false);
       hakalukiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!hakaluki.isChecked()){
                    hakaluki.setChecked(true);
                   hakaluki.setTextColor(getResources().getColor(R.color.teal_900));
                   hakalukiLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    hakaluki.setChecked(false);
                    hakaluki.setTextColor(getResources().getColor(R.color.black));
                    hakalukiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        malni.setClickable(false);
        malniLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!malni.isChecked()){
                    malni.setChecked(true);
                    malni.setTextColor(getResources().getColor(R.color.teal_900));
                    malniLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    malni.setChecked(false);
                    malni.setTextColor(getResources().getColor(R.color.black));
                    malniLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        panthumai.setClickable(false);
        panthumaiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!panthumai.isChecked()){
                    panthumai.setChecked(true);
                   panthumai.setTextColor(getResources().getColor(R.color.teal_900));
                    panthumaiLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    panthumai.setChecked(false);
                    panthumai.setTextColor(getResources().getColor(R.color.black));
                   panthumaiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        bisnakandi.setClickable(false);
        bisnakandiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!bisnakandi.isChecked()){
                    bisnakandi.setChecked(true);
                    bisnakandi.setTextColor(getResources().getColor(R.color.teal_900));
                    bisnakandiLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    bisnakandi.setChecked(false);
                    bisnakandi.setTextColor(getResources().getColor(R.color.black));
                    bisnakandiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        dibir.setClickable(false);
        dibirLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!dibir.isChecked()){
                    dibir.setChecked(true);
                    dibir.setTextColor(getResources().getColor(R.color.teal_900));
                    dibirLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                   dibir.setChecked(false);
                    dibir.setTextColor(getResources().getColor(R.color.black));
                    dibirLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        songrampunji.setClickable(false);
        songrampunjiLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!songrampunji.isChecked()){
                    songrampunji.setChecked(true);
                    songrampunji.setTextColor(getResources().getColor(R.color.teal_900));
                    songrampunjiLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    songrampunji.setChecked(false);
                    songrampunji.setTextColor(getResources().getColor(R.color.black));
                   songrampunjiLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        shah.setClickable(false);
        shahLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!shah.isChecked()){
                    shah.setChecked(true);
                    shah.setTextColor(getResources().getColor(R.color.teal_900));
                    shahLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    shah.setChecked(false);
                    shah.setTextColor(getResources().getColor(R.color.black));
                   shahLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        lovachora.setClickable(false);
        lovachoraLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!lovachora.isChecked()){
                    lovachora.setChecked(true);
                    lovachora.setTextColor(getResources().getColor(R.color.teal_900));
                    lovachoraLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    lovachora.setChecked(false);
                    lovachora.setTextColor(getResources().getColor(R.color.black));
                    lovachoraLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(hakaluki.isChecked()){
                    count++;
                }
                if(malni.isChecked()){
                    count++;
                }
                if(panthumai.isChecked()){
                    count++;
                }
                if(bisnakandi.isChecked()){
                    count++;
                }
                if(dibir.isChecked()){
                    count++;
                }
                if(songrampunji.isChecked()){
                    count++;
                }
                if(shah.isChecked()){
                    count++;
                }
                if(lovachora.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(sylhet.this).create();
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
                    Intent intent= new Intent(sylhet.this,sylhet_hotels.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Sylhet");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
    }


    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(sylhet.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(sylhet.this);
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
                            Intent intent_6 = new Intent(sylhet.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Sylhet");
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
