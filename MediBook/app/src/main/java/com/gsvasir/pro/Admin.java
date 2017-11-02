package com.gsvasir.pro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Admin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    public void onBackPressed() {


        Intent h = new Intent(getApplicationContext(), LoginPage.class);
        startActivity(h);

    }

    EditText et1, et2;
    Button bt1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
    progressDialog=new ProgressDialog(this);

        if (mAuth.getCurrentUser() != null) {
            // User is signed in
            Toast.makeText(getApplicationContext(), "SignIn as an Administrator", Toast.LENGTH_SHORT).show();
        }
        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
        bt1 = (Button) findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });

    }

    public void onLogin() {
        String email = et1.getText().toString().trim();
        String pass = et2.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
            Toast.makeText(getApplicationContext(), "Both fields are mandatory", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Loging you in,Please Wait... ");
        progressDialog.show();
        if (email.equals("gurpreet4416.gs@gmail.com")) {
            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(),Notification.class);
                                startActivity(intent);
                            }
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            else if (!task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "User Not Registered",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
        else
        {
            Toast.makeText(getApplicationContext(),"NOT A VALID ADMIN",Toast.LENGTH_LONG).show();
        }
    }
}