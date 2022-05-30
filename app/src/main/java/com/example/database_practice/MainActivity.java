package com.example.database_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.database_practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sp= getSharedPreferences("My pref",MODE_PRIVATE);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp= getSharedPreferences("My pref",MODE_PRIVATE);
                String val=binding.edittext.getText().toString();
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("Name",val);
                ed.apply();
                binding.textView.setText(val);
            }
        });
       String editVal=sp.getString("Name","No val as per row");
        binding.textView.setText(editVal);

    }
}