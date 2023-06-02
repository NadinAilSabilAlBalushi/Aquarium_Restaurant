package com.example.aquariumrestaurant;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.aquariumrestaurant.ChefMeals.ChefHome2;
import com.example.aquariumrestaurant.ChefMeals.ChefOrder2;
import com.example.aquariumrestaurant.ChefMeals.PendingOrders4;
import com.example.aquariumrestaurant.ChefMeals.ChefProfileFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class ChefBottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        UpdateToken();
        String name = getIntent().getStringExtra("page");
        if (name != null) {
            if (name.equalsIgnoreCase("Order")) {
                loadcheffragment(new PendingOrders4());
            } else if (name.equalsIgnoreCase("Confirm")) {
                loadcheffragment(new ChefOrder2());
            } else if (name.equalsIgnoreCase("AcceptOrder")) {
                loadcheffragment(new ChefHome2());
            } else if (name.equalsIgnoreCase("Delivery")) {
                loadcheffragment(new ChefHome2());
            }
        } else {
            loadcheffragment(new ChefHome2());
        }
    }

    private void UpdateToken() {

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if(task.isComplete()){
                    String token = task.getResult();
                    FirebaseDatabase.getInstance().getReference("Tokens").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);
                }
            }
        });

    }

    private boolean loadcheffragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.chefHome:
                fragment = new ChefHome2();
                break;

            case R.id.PendingOrders:
                fragment = new PendingOrders4();
                break;

            case R.id.Orders:
                fragment = new ChefOrder2();
                break;
            case R.id.chefProfile:
                fragment = new ChefProfileFragment();
                break;
        }
        return loadcheffragment(fragment);
    }
}
