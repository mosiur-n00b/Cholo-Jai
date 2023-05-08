package com.example.gadgethouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {
    private Button signUp;
    private FirebaseAuth mAuth;
    private EditText editFullName, editEmail, editPassword, editConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        signUp = (Button) findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();

                editFullName = (EditText)findViewById(R.id.fullName);
                editEmail = (EditText)findViewById(R.id.email);
                editPassword = (EditText)findViewById(R.id.password);
                editConfirmPassword = (EditText)findViewById(R.id.confirmPassword);

                String fullname = editFullName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String confirm = editConfirmPassword.getText().toString().trim();

                if(fullname.isEmpty()){
                    editFullName.setError("Full name is required");
                    editFullName.requestFocus();
                    return;
                }
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
                if(!confirm.equals(password)){
                    editConfirmPassword.setError("enter the same password");
                    editConfirmPassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),"Successfully created",Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(SignUp.this,district.class);
                                    intent.putExtra("email",email);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(),"Error ! "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}