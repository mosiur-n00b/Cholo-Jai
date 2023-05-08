package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class coxs_bazar extends AppCompatActivity {
    private Button bindas,nildoriya,next;
    private TextView bindas_cost, nildoriya_cost;
    private CheckBox coxsbazarSea,inani,himcchori,marine,ramu,kutubdia,pathor;
    private LinearLayout coxsbazarSeaLayout,inaniLayout,himcchoriLayout,marineLayout,ramuLayout,kutubdiaLayout,pathorLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coxs_bazar);

        email = getIntent().getStringExtra("email");

        bindas_cost = (TextView)findViewById(R.id.bindas_cost);
        nildoriya_cost = (TextView)findViewById(R.id.nildoriya_cost);
        bindas = (Button) findViewById(R.id.bindas);
        nildoriya = (Button) findViewById(R.id.nildoriya);
        coxsbazarSea =(CheckBox)findViewById(R.id.coxsbazarSea);
        inani =(CheckBox)findViewById(R.id.inani);
        himcchori =(CheckBox)findViewById(R.id.himcchori);
        marine =(CheckBox)findViewById(R.id.marine);
        ramu =(CheckBox)findViewById(R.id.ramu);
        kutubdia =(CheckBox)findViewById(R.id.kutubdia);
        pathor =(CheckBox)findViewById(R.id.pathor);
        coxsbazarSeaLayout = (LinearLayout)findViewById(R.id.coxsbazarSeaLayout);
        inaniLayout = (LinearLayout)findViewById(R.id.inaniLayout);
        himcchoriLayout = (LinearLayout)findViewById(R.id.himcchoriLayout);
        marineLayout = (LinearLayout)findViewById(R.id.marineLayout);
        ramuLayout = (LinearLayout)findViewById(R.id.ramuLayout);
        kutubdiaLayout= (LinearLayout) findViewById(R.id.kutubdiaLayout);
        pathorLayout = (LinearLayout)findViewById(R.id.pathorLayout);
        next = (Button) findViewById(R.id.next);

        bindas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float bindas_Price = Float.parseFloat(bindas_cost.getText().toString().replaceAll("[^0-9]",""));
                showDialouge("Bindas",2,4000);
            }
        });
        
        nildoriya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nildoriya_Price = Float.parseFloat(nildoriya_cost.getText().toString().replaceAll("[^0-9]",""));
                showDialouge("Nildoriya",4,9000);
            }
        });


        coxsbazarSea.setClickable(false);
        coxsbazarSeaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!coxsbazarSea.isChecked()){
                    coxsbazarSea.setChecked(true);
                    coxsbazarSea.setTextColor(getResources().getColor(R.color.teal_900));
                    coxsbazarSeaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    coxsbazarSea.setChecked(false);
                    coxsbazarSea.setTextColor(getResources().getColor(R.color.black));
                    coxsbazarSeaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        inani.setClickable(false);
        inaniLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!inani.isChecked()){
                    inani.setChecked(true);
                    inani.setTextColor(getResources().getColor(R.color.teal_900));
                    inaniLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    inani.setChecked(false);
                    inani.setTextColor(getResources().getColor(R.color.black));
                    inaniLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        himcchori.setClickable(false);
        himcchoriLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!himcchori.isChecked()){
                    himcchori.setChecked(true);
                    himcchori.setTextColor(getResources().getColor(R.color.teal_900));
                    himcchoriLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    himcchori.setChecked(false);
                    himcchori.setTextColor(getResources().getColor(R.color.black));
                    himcchoriLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        marine.setClickable(false);
        marineLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!marine.isChecked()){
                    marine.setChecked(true);
                    marine.setTextColor(getResources().getColor(R.color.teal_900));
                    marineLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    marine.setChecked(false);
                    marine.setTextColor(getResources().getColor(R.color.black));
                    marineLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        ramu.setClickable(false);
        ramuLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!ramu.isChecked()){
                    ramu.setChecked(true);
                    ramu.setTextColor(getResources().getColor(R.color.teal_900));
                    ramuLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    ramu.setChecked(false);
                    ramu.setTextColor(getResources().getColor(R.color.black));
                    ramuLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        kutubdia.setClickable(false);
        kutubdiaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!kutubdia.isChecked()){
                    kutubdia.setChecked(true);
                    kutubdia.setTextColor(getResources().getColor(R.color.teal_900));
                    kutubdiaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    kutubdia.setChecked(false);
                    kutubdia.setTextColor(getResources().getColor(R.color.black));
                    kutubdiaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        pathor.setClickable(false);
        pathorLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!pathor.isChecked()){
                    pathor.setChecked(true);
                    pathor.setTextColor(getResources().getColor(R.color.teal_900));
                    pathorLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    pathor.setChecked(false);
                    pathor.setTextColor(getResources().getColor(R.color.black));
                    pathorLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(coxsbazarSea.isChecked()){
                    count++;
                }
                if(inani.isChecked()){
                    count++;
                }
                if(himcchori.isChecked()){
                    count++;
                }
                if(marine.isChecked()){
                    count++;
                }
                if(ramu.isChecked()){
                    count++;
                }
                if(kutubdia.isChecked()){
                    count++;
                }
                if(pathor.isChecked()){
                    count++;
                }

                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(coxs_bazar.this).create();
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
                    Intent intent= new Intent(coxs_bazar.this,hotelCarSelect.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","coxsBazar");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
    }

    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(coxs_bazar.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(coxs_bazar.this);
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
                            Intent intent_6 = new Intent(coxs_bazar.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Coxs Bazar");
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