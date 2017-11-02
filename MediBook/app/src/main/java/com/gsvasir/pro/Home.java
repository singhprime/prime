package com.gsvasir.pro;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button lb,b1,gp,fb,sb;
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0,int arg1) {
                        moveTaskToBack(true);
                    }}).create().show();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getSupportActionBar().hide();
        sb=(Button)findViewById(R.id.sb);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents=new Intent(getApplicationContext(),Register.class);
                startActivity(intents);
            }
        });

        lb=(Button)findViewById(R.id.lb);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
            }
        });
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });
        gp=(Button)findViewById(R.id.gp);
        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                intent2.setData(Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?service=oz&passive=1209600&continue=https%3A%2F%2Fplus.google.com%2Fup%2F%3Fcontinue%3Dhttps%3A%2F%2Fplus.google.com%2Fcollections%2Ffeatured%3Fhl%253Den%26gpsrc%3Dgplp0&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
                startActivity(intent2);
            }
        });
        fb=(Button)findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent();
                intent3.setAction(Intent.ACTION_VIEW);
                intent3.addCategory(Intent.CATEGORY_BROWSABLE);
                intent3.setData(Uri.parse("https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwirmNyopNnUAhXEvY8KHV61CQsQFgglMAA&url=https%3A%2F%2Fwww.facebook.com%2F&usg=AFQjCNGug_CqO9cxLI8dHdn-CceO8_ie5w"));
                startActivity(intent3);
            }
        });

    }
    }
