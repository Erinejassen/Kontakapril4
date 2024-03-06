package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Homeui extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Chatsfragment chatsfragment = new Chatsfragment();
    Contactsfragment contactsfragment = new Contactsfragment();
    Groupsfragment groupsfragment = new Groupsfragment();
    Requestfragment requestfragment = new Requestfragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeui);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, chatsfragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.chats) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, chatsfragment).commit();
                    return true;
                } else if (itemId == R.id.groups) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, groupsfragment).commit();
                    return true;
                } else if (itemId == R.id.contacts) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, contactsfragment).commit();
                    return true;
                } else if (itemId == R.id.request) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, requestfragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}