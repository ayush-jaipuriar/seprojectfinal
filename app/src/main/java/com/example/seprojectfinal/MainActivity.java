package com.example.seprojectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtUsername, edtPassword;
    Button btnSignUP, btnSignIn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUP = findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null) {
            //Transition to next activity

        }}

    private void signUp() {
        String email, password;
        email = edtEmail.getText().toString();
        password = edtPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {

                    Log.i("TAG", "createUserWithEmail:success");
                    //FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(MainActivity.this, "Authentication Passed. Never Give Up",
                            Toast.LENGTH_SHORT).show();

                }
                else {

                    Log.i("TAG", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
