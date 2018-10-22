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
        //Le Button est dans l'Activity
        addBottleButton= findViewById(R.id.a_main_btn_addB);

        //Creation du fragment d'affichage
        fragmentDisplayCreation();

        //Appuie sur le bouton d'ajout
        addBottleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Masque le bouton pour qu'il ne soit pas sur la prochaine vue, en effet il est dans l'Activity et non
                //le fragment qui va être écrasé, il sera donc toujours présent, d'ou l'importance de le masquer
                addBottleButton.setVisibility(View.GONE);
                fragmentCreateCreation();
            }
        });
    }

    protected void fragmentCreateCreation() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CreateFragment fragment = new CreateFragment();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0) && (resultCode == 0)) {
            Bottle createdBottle ;
            createdBottle = (Bottle) data.getSerializableExtra("bottle");
            cave.addBottle(createdBottle);
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
