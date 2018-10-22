package com.example.hadrienjanicot.androidbegin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements CreateFragment.OnFragmentInteractionListener{
    static Cellar cave = new Cellar();
    Button addBottleButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBottleButton= findViewById(R.id.a_main_btn_addB);

        fragmentDisplayCreation();

        addBottleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, CreateBottleActivity.class);
                //startActivityForResult(intent,0);
                addBottleButton.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CreateFragment fragment = new CreateFragment();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0) && (resultCode == 0)) {
            Bottle createdBottle ;
            createdBottle = (Bottle) data.getSerializableExtra("bottle");
            cave.addBottle(createdBottle);
            //adapter.notifyItemInserted(cave.getNumberOfBottles());
            fragmentDisplayCreation();

        }
    }

    protected void fragmentDisplayCreation(){
        addBottleButton.setVisibility(View.VISIBLE);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bottleList", cave.bottleList);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DisplayFragment fragment = new DisplayFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void AddBottle(Bottle b) {
        cave.addBottle(b);
        fragmentDisplayCreation();
    }
}
