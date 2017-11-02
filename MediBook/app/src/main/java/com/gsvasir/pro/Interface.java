package com.gsvasir.pro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Interface extends AppCompatActivity {
    Button map,cnt,ba;
    private FirebaseAuth firebaseAuth;
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Interface.this);
        //setting dialog title
        alertDialog.setTitle("Confirmation");
        //setting dialog message
        alertDialog.setTitle("Choose Action");
        //alertdialog.setIcon(R.drawable.delete);
        alertDialog.setPositiveButton("Exit Without LogingOut", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
            }}).create().show();
        alertDialog.setNegativeButton("Exit and logOut", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }

        });
        alertDialog.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);



        firebaseAuth= FirebaseAuth.getInstance();
        map=(Button)findViewById(R.id.map);
        cnt=(Button)findViewById(R.id.cnt);
        ba=(Button)findViewById(R.id.ba);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SearchDoc.class);
                startActivity(intent);
            }
        });
        cnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent=new Intent(getApplicationContext(),Call.class);
                startActivity(intent);
            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Book.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.lout:
            {
                Toast.makeText(getApplicationContext(),"Signing Out",Toast.LENGTH_LONG).show();
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this,LoginPage.class));
                return true;
            }
            default:
            {
                return super.onOptionsItemSelected(item);

            }
        }



    }


}
