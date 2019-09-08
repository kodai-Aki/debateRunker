package com.example.debaterunker_outline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class gameResult extends AppCompatActivity {

    Spinner team1_Result;
    Spinner team2_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        team1_Result = (Spinner)findViewById(R.id.spinner);
        team2_Result = (Spinner)findViewById(R.id.spinner2);

        SharedPreferences date = getSharedPreferences("teamName", MODE_PRIVATE);
        adapter.add(String.valueOf(date));


        team1_Result.setAdapter(adapter);
        team2_Result.setAdapter(adapter);

        team1_Result.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Spinner spinner = (Spinner) parent;
                String item = (String)spinner.getSelectedItem();

                Log.v("spinner item", item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                itemを選択しなかったとき
            }
        });
    }




    public void result_Add(View v){
        finish();
    }

}
