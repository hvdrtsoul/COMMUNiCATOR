package com.example.communicator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_int = findViewById(R.id.button_int);
        Button button_sha = findViewById(R.id.button_sha);

        TextView result = findViewById(R.id.result);

        EditText input = (EditText)findViewById(R.id.input);

        button_int.setOnClickListener((View v)-> {
            HashMaster hasher = new HashMaster();
            String text = input.getText().toString();
            Log.d("GOT TEXT", text);
            result.setText(hasher.get_simple_hash(text).toString());
        });

        button_sha.setOnClickListener((View v) -> {
            HashMaster hasher = new HashMaster();
            try {
                result.setText(hasher.get_hash_sha256(input.getText().toString()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        });

    }
}