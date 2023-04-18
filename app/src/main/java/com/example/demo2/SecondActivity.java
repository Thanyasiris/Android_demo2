package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int counter = 0;
    String text="";
    int max = 10;
    int min = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView countTextView = findViewById(R.id.countTextView);

        EditText editNumDecimal = findViewById(R.id.editNumDecimal);

        EditText editMinDecimal = findViewById(R.id.editMinDecimal);

        editNumDecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                text = editNumDecimal.getText().toString();
                if(!text.isEmpty()){
                    max = Integer.parseInt(text);
                    if(counter>max){
                        counter = max;
                        countTextView.setText("Count : "+ Integer.toString(counter));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editMinDecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                text = editMinDecimal.getText().toString();
                if(!text.isEmpty()){
                    min = Integer.parseInt(text) * (-1);
                    if(counter<min){
                        counter = min;
                        countTextView.setText("Count : "+ Integer.toString(counter));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter < max){
                    counter += 1;
                }
                countTextView.setText("Count : "+ Integer.toString(counter));
            }
        });

        Button remove = findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter > min){
                    counter -= 1;
                }
                countTextView.setText("Count : "+ Integer.toString(counter));
            }
        });
    }
}