package com.example.gadgethouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class receipt2 extends AppCompatActivity {
    private TextView numPerson,costPer,totalcost,totalcostVat,sview;
    private int numberOfPerson,cost,days,dpersonnum;
    private String packagename,details,email,location;
    private Button back,confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt2);

        numberOfPerson = getIntent().getIntExtra("numberOfPerson",0);
        cost = getIntent().getIntExtra("cost",0);
        days = getIntent().getIntExtra("days",0);
        packagename = getIntent().getStringExtra("packageName");
        email = getIntent().getStringExtra("email");
        location = getIntent().getStringExtra("location");
        dpersonnum = getIntent().getIntExtra("dPersonNum",0);

        sview = (TextView)findViewById(R.id.sview);
        costPer = (TextView)findViewById(R.id.costPer);
        numPerson = (TextView)findViewById(R.id.numPerson);
        totalcost = (TextView)findViewById(R.id.totalcost);
        totalcostVat = (TextView)findViewById(R.id.totalcostVat);

        details="You are enjoying "+packagename+" package for "+days+" days and "+(days-1)+" night" + " in "+location;

        sview.setText(details);
        numPerson.setText(String.valueOf(numberOfPerson));
        costPer.setText(String.valueOf(cost));

        int price = numberOfPerson*cost;
        totalcost.setText(String.valueOf(price));

        float finalCost = (float)(price+price*.05);
        totalcostVat.setText(String.valueOf((int)finalCost));

        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_7= new Intent(receipt2.this,district.class);
                startActivity(intent_7);
            }
        });

        confirm  = (Button)findViewById(R.id.confirm );
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_5= new Intent(receipt2.this,general_Form.class);
                intent_5.putExtra("location",location);
                intent_5.putExtra("totalCost",(int)finalCost);
                intent_5.putExtra("email",email);
                intent_5.putExtra("location",location);
                intent_5.putExtra("selection","packages");
                intent_5.putExtra("numberOfPerson",numberOfPerson);
                intent_5.putExtra("dPersonNum",dpersonnum);
                startActivity(intent_5);
            }
        });

    }
}