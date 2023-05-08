package com.example.gadgethouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class district extends AppCompatActivity {
    private Button coxs_bazar;
    private Button sylhet;
    private Button bandarban;
    private Button chittagong;
    private Button gazipur;
    private Button rangamati;
    private Button tangail;
    private Button dhaka;
    private Button comilla;
    private String email;
    private Button khagrachori;
    private TextView contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        email = getIntent().getStringExtra("email");

        coxs_bazar = (Button) findViewById(R.id.coxs_bazar);
        coxs_bazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,coxs_bazar.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        sylhet = (Button) findViewById(R.id.sylhet);
        sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,sylhet.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        bandarban = (Button) findViewById(R.id.bandarban);
        bandarban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,bandarban.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        chittagong = (Button) findViewById(R.id.chittagong);
        chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,chittagong.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        gazipur = (Button) findViewById(R.id.gazipur);
        gazipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,gazipur.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        rangamati = (Button) findViewById(R.id.rangamati);
        rangamati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,rangamati.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        tangail = (Button) findViewById(R.id.tangail);
        tangail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,tangail.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

       dhaka = (Button) findViewById(R.id.dhaka);
        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,dhaka.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        comilla = (Button) findViewById(R.id. comilla);
        comilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this, comilla.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        khagrachori = (Button) findViewById(R.id.khagrachari);
        khagrachori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,khagrachori.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        contact = (TextView)findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(district.this,contact.class);
                startActivity(intent);
            }
        });

    }
}