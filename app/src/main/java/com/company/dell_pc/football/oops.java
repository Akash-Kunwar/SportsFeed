
package com.company.dell_pc.football;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

//Splash screen java file
public class oops extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent hi = new Intent(oops.this,MainActivity.class);
                startActivity(hi);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}