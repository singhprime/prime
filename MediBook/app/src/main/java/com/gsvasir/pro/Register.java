package com.gsvasir.pro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    int i=0;
    private String TAG;
    private ProgressDialog progressDialog;

    @Override
    public void onBackPressed() {
        i++;
        if(i>0) {
            Intent h=new Intent(getApplicationContext(),Home.class);
            startActivity(h);
        }
    }
    Button bt2,back;
    EditText et1,et5,et3,et4,et6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        progressDialog=new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        back=(Button)findViewById(R.id.back);
        bt2=(Button)findViewById(R.id.bt2);
        et1=(EditText)findViewById(R.id.et1);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        et6=(EditText)findViewById(R.id.et6);
                back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bck=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(bck);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAccount();



            }

        });

    }
    public void createAccount()
    {
        String name = et1.getText().toString().trim();
        String Phone = et3.getText().toString().trim();
        String Address = et5.getText().toString().trim();
        String Email = et4.getText().toString().trim();
        String password = et6.getText().toString().trim();
        //checking if email and passwords are empty
        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Please enter your email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter the password",Toast.LENGTH_LONG).show();
            return;
        }
        //Comparing password and confirmPassword are equal or not
        /*if(!password.equals(confirmPwd)){
            Toast.makeText(this,"Password doesn't match",Toast.LENGTH_LONG).show();
        }*/
        //checking if phone field is empty
        if(TextUtils.isEmpty(Phone)){
            Toast.makeText(this,"Please enter phone",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("SignUp in progress,Please Wait... ");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_LONG).show();
                            Intent in=new Intent(getApplicationContext(),LoginPage.class);
                            startActivity(in);
                        }

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                      else  if (!task.isSuccessful()) {
                            Toast.makeText(Register.this, "Error occured during User Registeration",
                                    Toast.LENGTH_SHORT).show();
                            Intent n=new Intent(getApplicationContext(),Register.class);
                            startActivity(n);
                        }

                        // ...
                    }
                });
    }

}
