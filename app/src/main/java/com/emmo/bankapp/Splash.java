package com.emmo.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankapp.R;

public class Splash extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);



      int SPLASH_DISPLAY_LENGTH = 1000;


      new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
            /* Create an Intent that will start the Menu-Activity. */
            Intent mainIntent = new Intent(Splash.this,
                    Authentication.class);
            Splash.this.startActivity(mainIntent);
            Splash.this.finish();
         }
      }, SPLASH_DISPLAY_LENGTH);
   }
}
