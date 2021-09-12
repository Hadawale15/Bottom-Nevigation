package com.example.bottomnevigation_activity2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bottomnevigation_activity2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView= findViewById(R.id.navview_id);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        bottomNavigationView.setSelectedItemId(R.id.dashboard_id);
        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_id,new Dashboard()).commit();
        }

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               Fragment selectedFragment = null;
               switch (item.getItemId()){
                   case R.id.home_id:
                       selectedFragment=new Home();
                       break;

                   case R.id.dashboard_id:
                       selectedFragment=new Dashboard();
                       break;

                   case R.id.notification_id:
                       selectedFragment=new Notification();
                       break;

                   case R.id.account_id:
                       selectedFragment=new Account();
                       break;
               }

               getSupportFragmentManager().beginTransaction().replace(R.id.layout_id,selectedFragment).commit();

               return true;
           }
       });

    }

}