package com.emmo.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankapp.R;

public class Authentication extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_user_name);


      findViewById(R.id.usernameFab)
              .setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    Intent intent = new Intent(Authentication.this, Main.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                 }
              });



   }
}
