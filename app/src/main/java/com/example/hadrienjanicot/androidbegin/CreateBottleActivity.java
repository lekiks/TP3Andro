package com.example.hadrienjanicot.androidbegin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateBottleActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bottle);
        Button createBottleBtn = findViewById(R.id.a_main_btn_createB);
        final EditText editName = findViewById(R.id.a_main_input_name);
        final EditText editPrice = findViewById(R.id.a_main_input_price);

        createBottleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editName.getText().toString();
                Float price = Float.valueOf(editPrice.getText().toString());
                Bottle b = new Bottle(name,price);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("bottle", b);
                setResult(0, returnIntent);
                finish();
            }
        });
    }
}
