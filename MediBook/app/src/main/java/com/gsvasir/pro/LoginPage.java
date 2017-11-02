package com.gsvasir.pro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
//firebase:-
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;




    @Override
    public void onBackPressed() {


            Intent h=new Intent(getApplicationContext(),Home.class);
            startActivity(h);

    }

    EditText et1,et2;
    Button bt1,bt2,bt3;
    private ProgressDialog progressDialog;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);




                if ( mAuth.getCurrentUser() != null) {
                    // User is signed in
                    Toast.makeText(getApplicationContext(),"SignIn or SignUP",Toast.LENGTH_SHORT).show();
                }
        et1=(EditText)findViewById(R.id.e1);
        et2=(EditText)findViewById(R.id.e2);
        bt1=(Button)findViewById(R.id.b1);
        bt2=(Button)findViewById(R.id.b2);
        bt3=(Button)findViewById(R.id.b3);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),Admin.class);
            startActivity(intent);}
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg=new Intent(getApplicationContext(),Register.class);
                startActivity(reg);
            }
        });

    }
    public void onLogin()
    {
        String email=et1.getText().toString().trim();
        String pass=et2.getText().toString().trim();
        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass))
        {
            Toast.makeText(getApplicationContext(),"Both fields are mandatory",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Loging you in,Please Wait... ");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(getApplicationContext(),Interface.class);
                            startActivity(intent);
                        }
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                       else if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"User Not Registered",
                                    Toast.LENGTH_SHORT).show();
                            Intent n=new Intent(getApplicationContext(),LoginPage.class);
                            startActivity(n);
                        }

                        // ...
                    }
                });
    }
}





