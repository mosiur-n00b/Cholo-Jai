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

public class dhaka extends AppCompatActivity {
    private Button masti,rajprasad,next;
    private CheckBox ramna,bashundhara,fantasy,parliament,memorial,shaheedminar,zoo;
    private LinearLayout ramnaLayout,bashundharaLayout,fantasyLayout,parliamentLayout,memorialLayout,shaheedminarLayout,zooLayout;
    private int person;
    private String email;
    private DatabaseReference rref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);
        email = getIntent().getStringExtra("email");

        next = (Button) findViewById(R.id.next);
        ramna =(CheckBox)findViewById(R.id.ramna);
        bashundhara =(CheckBox)findViewById(R.id.bashundhara);
        fantasy=(CheckBox)findViewById(R.id.fantasy);
        parliament =(CheckBox)findViewById(R.id.parliament);
        memorial =(CheckBox)findViewById(R.id.memorial);
        shaheedminar =(CheckBox)findViewById(R.id.shaheedminar);
        zoo =(CheckBox)findViewById(R.id.zoo);
        ramnaLayout = (LinearLayout)findViewById(R.id.ramnaLayout);
        bashundharaLayout = (LinearLayout)findViewById(R.id.bashundharaLayout);
        fantasyLayout = (LinearLayout)findViewById(R.id.fantasyLayout);
        parliamentLayout = (LinearLayout)findViewById(R.id.parliamentLayout);
        memorialLayout = (LinearLayout)findViewById(R.id.memorialLayout);
        shaheedminarLayout= (LinearLayout) findViewById(R.id.shaheedminarLayout);
        zooLayout = (LinearLayout)findViewById(R.id.zooLayout);
        masti = (Button) findViewById(R.id.masti);
        rajprasad =(Button)findViewById(R.id.rajprasad);
        ramna.setClickable(false);

        masti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Masti",3,9500);
            }
        });
        rajprasad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialouge("Rajprasad",2,4500);
            }
        });

        ramnaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!ramna.isChecked()){
                    ramna.setChecked(true);
                    ramna.setTextColor(getResources().getColor(R.color.teal_900));
                    ramnaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    ramna.setChecked(false);
                    ramna.setTextColor(getResources().getColor(R.color.black));
                    ramnaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        bashundhara.setClickable(false);
        bashundharaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!bashundhara.isChecked()){
                    bashundhara.setChecked(true);
                    bashundhara.setTextColor(getResources().getColor(R.color.teal_900));
                    bashundharaLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    bashundhara.setChecked(false);
                    bashundhara.setTextColor(getResources().getColor(R.color.black));
                    bashundharaLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        fantasy.setClickable(false);
        fantasyLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!fantasy.isChecked()){
                    fantasy.setChecked(true);
                    fantasy.setTextColor(getResources().getColor(R.color.teal_900));
                    fantasyLayout.setBackgroundResource(R.drawable.bordercolorchange);

                }
                else{
                    fantasy.setChecked(false);
                    fantasy.setTextColor(getResources().getColor(R.color.black));
                    fantasyLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        parliament.setClickable(false);
        parliamentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!parliament.isChecked()){
                    parliament.setChecked(true);
                    parliament.setTextColor(getResources().getColor(R.color.teal_900));
                    parliamentLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    parliament.setChecked(false);
                    parliament.setTextColor(getResources().getColor(R.color.black));
                    parliamentLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        memorial.setClickable(false);
        memorialLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!memorial.isChecked()){
                    memorial.setChecked(true);
                    memorial.setTextColor(getResources().getColor(R.color.teal_900));
                    memorialLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    memorial.setChecked(false);
                    memorial.setTextColor(getResources().getColor(R.color.black));
                    memorialLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        shaheedminar.setClickable(false);
        shaheedminarLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!shaheedminar.isChecked()){
                    shaheedminar.setChecked(true);
                    shaheedminar.setTextColor(getResources().getColor(R.color.teal_900));
                    shaheedminarLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    shaheedminar.setChecked(false);
                    shaheedminar.setTextColor(getResources().getColor(R.color.black));
                    shaheedminarLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });
        zoo.setClickable(false);
        zooLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!zoo.isChecked()){
                    zoo.setChecked(true);
                    zoo.setTextColor(getResources().getColor(R.color.teal_900));
                    zooLayout.setBackgroundResource(R.drawable.bordercolorchange);
                }
                else{
                    zoo.setChecked(false);
                    zoo.setTextColor(getResources().getColor(R.color.black));
                    zooLayout.setBackgroundResource(R.drawable.border);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int count = 0;
                if(ramna.isChecked()){
                    count++;
                }
                if(bashundhara.isChecked()){
                    count++;
                }
                if(fantasy.isChecked()){
                    count++;
                }
                if(parliament.isChecked()){
                    count++;
                }
                if(memorial.isChecked()){
                    count++;
                }
                if(shaheedminar.isChecked()){
                    count++;
                }
                if(zoo.isChecked()){
                    count++;
                }
                if(count == 0){
                    AlertDialog alertDialog = new AlertDialog.Builder(dhaka.this).create();
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
                    Intent intent= new Intent(dhaka.this,dhaka_hotel.class);
                    intent.putExtra("numberOfSpot",count);
                    intent.putExtra("location","Dhaka");
                    intent.putExtra("email",email);
                    startActivity(intent);
                }

            }
        });


    }
    public void showDialouge(String packagename,int days,int cost){
        androidx.appcompat.app.AlertDialog.Builder ad = new androidx.appcompat.app.AlertDialog.Builder(dhaka.this);
        ad.setTitle("Total Person");

        final EditText input_2 = new EditText(dhaka.this);
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
                            Intent intent_6 = new Intent(dhaka.this,receipt2.class);
                            intent_6.putExtra("packageName",packagename);
                            intent_6.putExtra("cost",cost);
                            intent_6.putExtra("days",days);
                            intent_6.putExtra("numberOfPerson",person);
                            intent_6.putExtra("email",email);
                            intent_6.putExtra("location","Dhaka");
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