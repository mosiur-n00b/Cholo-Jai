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

public class comilla extends AppCompatActivity {
    private Button next,bihara,magicbutton;
    private TextView cheack;
    private CheckBox shalbon,cemetery,nobo,dharmasagar,queenpalace,rupban,magic;
    private LinearLayout shalbonLayout,cemeteryLayout,noboLayout,dharmasagarLayout,queenpalaceLayout,rupbanLayout,magicLayout;
    private int person;
    private String email;
    private DatabaseReference rref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comilla);

        email = getIntent().getStringExtra("email");

        next = (Button) findViewById(R.id.next);
        bihara = (Button) findViewById(R.id.bihara);
        magicbutton = (Button) findViewById(R.id.magicbutton);
        shalbon =(CheckBox)findViewById(R.id.shalbon);
        cemetery =(CheckBox)findViewById(R.id.cemetery);
        nobo =(CheckBox)findViewById(R.id.nobo);
        dharmasagar =(CheckBox)findViewById(R.id.dharmasagar);
        queenpalace =(CheckBox)findViewById(R.id.queenpalace);
        rupban =(CheckBox)findViewById(R.id.rupban);
        magic =(CheckBox)findViewById(R.id.magic);
        shalbonLayout = (LinearLayout)findViewById(R.id.shalbonLayout);
        cemeteryLayout = (LinearLayout)findViewById(R.id.cemeteryLayout);
        noboLayout = (LinearLayout)findViewById(R.id.noboLayout);
        dharmasagarLayout = (LinearLayout)findViewById(R.id.dharmasagarLayout);
        queenpalaceLayout = (LinearLayout)findViewById(R.id.queenpalaceLayout);
        rupbanLayout= (LinearLayout) findViewById(R.id.rupbanLayout);
        magicLayout = (LinearLayout)findViewById(R.id.magicLayout);

        bihara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Bihara",2,3500);
            }
        });

        magicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Magic",3,7000);
            }
        });

        shalbon.setClickable(false);
        shalbonLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!shalbon.isChecked()){
                    shalbon.setChecked(true);
                    shalbon.setTextColor(getResources().getColor(R.color.teal_900));
                    shalbonLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    shalbon.setChecked(false);
                    shalbon.setTextColor(getResources().getColor(R.color.black));
                    shalbonLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        cemetery.setClickable(false);
        cemeteryLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!cemetery.isChecked()){
                    cemetery.setChecked(true);
                    cemetery.setTextColor(getResources().getColor(R.color.teal_900));
                    cemeteryLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    cemetery.setChecked(false);
                    cemetery.setTextColor(getResources().getColor(R.color.black));
                    cemeteryLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        nobo.setClickable(false);
        noboLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!nobo.isChecked()){
                    nobo.setChecked(true);
                    nobo.setTextColor(getResources().getColor(R.color.teal_900));
                    noboLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    nobo.setChecked(false);
                    nobo.setTextColor(getResources().getColor(R.color.black));
                    noboLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        dharmasagar.setClickable(false);
        dharmasagarLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!dharmasagar.isChecked()){
                    dharmasagar.setChecked(true);
                    dharmasagar.setTextColor(getResources().getColor(R.color.teal_900));
                    dharmasagarLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    dharmasagar.setChecked(false);
                    dharmasagar.setTextColor(getResources().getColor(R.color.black));
                    dharmasagarLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        queenpalace.setClickable(false);
        queenpalaceLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!queenpalace.isChecked()){
                    queenpalace.setChecked(true);
                    queenpalace.setTextColor(getResources().getColor(R.color.teal_900));
                    queenpalaceLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    queenpalace.setChecked(false);
                    queenpalace.setTextColor(getResources().getColor(R.color.black));
                    queenpalaceLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        rupban.setClickable(false);
        rupbanLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!rupban.isChecked()){
                    rupban.setChecked(true);
                    rupban.setTextColor(getResources().getColor(R.color.teal_900));
                    rupbanLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    rupban.setChecked(false);
                    rupban.setTextColor(getResources().getColor(R.color.black));
                    rupbanLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        magic.setClickable(false);
        magicLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!magic.isChecked()){
                    magic.setChecked(true);
                    magic.setTextColor(getResources().getColor(R.color.teal_900));
                    magicLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    magic.setChecked(false);
                    magic.setTextColor(getResources().getColor(R.color.black));
                    magicLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int count = 0;
                if(shalbon.isChecked()){
                    count++;
                }
                if(cemetery.isChecked()){
                    count++;
                }
                if(nobo.isChecked()){
                    count++;
                }
                if(dharmasagar.isChecked()){
                    count++;
                }
                if(queenpalace.isChecked()){
                    count++;
                }
                if(rupban.isChecked()){
                    count++;
                }
                if(magic.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(comilla.this).create();
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
                    Intent intent= new Intent(comilla.this,comilla_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Comilla");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
    }

    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(comilla.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(comilla.this);
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
                            Intent intent_6 = new Intent(comilla.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Comilla");
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