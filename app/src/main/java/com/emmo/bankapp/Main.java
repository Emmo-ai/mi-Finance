package com.emmo.bankapp;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bankapp.R;
import com.google.android.material.navigation.NavigationView;


public class Main extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

   private static final float END_SCALE = 0.7f;
   ImageView icon_nav;
   NavigationView navigationView;
   DrawerLayout drawer;
   LinearLayout contextView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      drawer = findViewById(R.id.drawerLayout);
      navigationView = findViewById(R.id.nav_view);
      contextView = findViewById(R.id.contextView);

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
         this.getWindow().setNavigationBarColor(getColor(R.color.appBackground));
      }
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
         this.getWindow().setStatusBarColor(getColor(R.color.appBackground));
      }


      icon_nav = findViewById(R.id.NavBtn);
      navigationView.bringToFront();
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.setCheckedItem(R.id.nav_loans);

      icon_nav.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (drawer.isDrawerVisible(GravityCompat.START)) {
               drawer.closeDrawer(GravityCompat.START);
            }
            else {
               drawer.openDrawer(GravityCompat.START);
            }
         }
      });

      animateNavigationDrawer();

   }





   private void animateNavigationDrawer() {
      drawer.setScrimColor(getResources().getColor(R.color.AppTextAndFields));

      drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
         @Override
         public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            final float diffScaleOffset = slideOffset * (1 - END_SCALE);
            final float offsetScale = 1 - diffScaleOffset;
            contextView.setScaleX(offsetScale);
            contextView.setScaleY(offsetScale);

            final float xOffset = drawerView.getWidth() * slideOffset;
            final float xOffsetDiff = contextView.getWidth() * diffScaleOffset / 2;
            final float xTranslation = xOffset - xOffsetDiff;
            contextView.setTranslationX(xTranslation);


         }

         @Override
         public void onDrawerOpened(@NonNull View drawerView) {

         }

         @Override
         public void onDrawerClosed(@NonNull View drawerView) {

         }

         @Override
         public void onDrawerStateChanged(int newState) {

         }
      });
   }



   @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem item) {

      Fragment fragment = null;
      Class fragmentClass;
      switch (item.getItemId()){

         case R.id.myProfile:
            fragmentClass = MyAccount.class;
            break;
         default:
            fragmentClass = MyAccount.class;

      }
      try {
         fragment = (Fragment) fragmentClass.newInstance();
      } catch (Exception e) {
         e.printStackTrace();
      }

      FragmentManager fragmentManager = getSupportFragmentManager();
      assert fragment != null;
      fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();

      // Highlight the selected item has been done by NavigationView
      item.setChecked(true);
      drawer.closeDrawers();
      return false;
   }
}
