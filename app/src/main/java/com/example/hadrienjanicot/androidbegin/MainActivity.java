package com.example.hadrienjanicot.androidbegin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static Cellar cave = new Cellar();
    IconDataAdapter adapter = new IconDataAdapter(cave.bottleList);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBottleButton= findViewById(R.id.a_main_btn_addB);
        //listDisplay = findViewById(R.id.a_main_bottleList);
        addBottleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateBottleActivity.class);
                startActivityForResult(intent,0);
            }
        });
        RecyclerView recycler = findViewById(R.id.a_main_recycler);
        recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 0) && (resultCode == 0)) {
            Bottle createdBottle ;
            createdBottle = (Bottle) data.getSerializableExtra("bottle");
            cave.addBottle(createdBottle);
            adapter.notifyItemInserted(cave.getNumberOfBottles());
            //listDisplay.setText(cave.cellarView());
        }
    }
}
