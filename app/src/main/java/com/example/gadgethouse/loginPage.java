package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    private TextView register,forget;
    private Button login;
    private EditText editEmail,editPassword;
    private FirebaseAuth mAuth;
    private String setEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(loginPage.this,SignUp.class);
                startActivity(intent);
            }
        });

        login = (Button)findViewById(R.id.loginButton);
        editEmail = (EditText)findViewById(R.id.email);
        editPassword = (EditText)findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(loginPage.this,district.class));
                mAuth = FirebaseAuth.getInstance();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if(email.isEmpty()){
                    editEmail.setError("Email is required");
                    editEmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editEmail.setError("valid email is required");
                    editEmail.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    editPassword.setError("Password is required");
                    editPassword.requestFocus();
                    return;
                }
                if(password.length() <6){
                    editPassword.setError("password must be at least 6 characters");
                    editPassword.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();
                                    Intent firstIntent = new Intent(loginPage.this,district.class);
                                    firstIntent.putExtra("email",email);
                                    startActivity(firstIntent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(),"Error ! "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        forget = (TextView)findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(loginPage.this);
                alertDialog.setTitle("Forgot Password");
                alertDialog.setMessage("Enter your email");

                final EditText input = new EditText(loginPage.this);
                alertDialog.setView(input);

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mAuth = FirebaseAuth.getInstance();
                                setEmail =  input.getText().toString().trim();
                                if(Patterns.EMAIL_ADDRESS.matcher(setEmail).matches()){
                                    mAuth.sendPasswordResetEmail(setEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(getApplicationContext(),"Check your email",Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Toast.makeText(getApplicationContext(),"Error ! "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"plz enter valid email address",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();

            }
        });
    }

}