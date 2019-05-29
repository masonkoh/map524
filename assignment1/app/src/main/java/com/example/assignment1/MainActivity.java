package com.example.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView bonjourWorldTextView = findViewById(R.id.bonjourWorldTextView);
        final TextView hiSenecaTextView = findViewById(R.id.hiSenecaTextView);
        Button sayBonjourBtn = findViewById(R.id.sayBonjourBtn);
        Button sayHiBtn = findViewById(R.id.sayHiBtn);

        final RadioGroup firstRadioGroup = findViewById(R.id.firstRadioGroup);
        final RadioGroup secondRadioGroup = findViewById(R.id.secondRadioGroup);

        final CheckBox redBtn = findViewById(R.id.redBtn);
        final CheckBox yellowBtn = findViewById(R.id.yellowBtn);
        final CheckBox greenBtn = findViewById(R.id.greenBtn);
        Button colorsBtn = findViewById(R.id.colorsBtn);


        sayBonjourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int changedRadio = firstRadioGroup.getCheckedRadioButtonId();
                if (changedRadio == R.id.aliceRadioBtn) {
                    bonjourWorldTextView.setText("Bonjour Alice");
                }
                if (changedRadio == R.id.bobRadioBtn) {
                    bonjourWorldTextView.setText("Bonjour Bob");
                }
                if (changedRadio == R.id.carolRadioBtn) {
                    bonjourWorldTextView.setText("Bonjour Carol");
                }
            }
        });
        sayHiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int changedRadio = secondRadioGroup.getCheckedRadioButtonId();
                if (changedRadio == R.id.daveRadioBtn) {
                    hiSenecaTextView.setText("Hi Dave");
                }
                if (changedRadio == R.id.eveRadioBtn) {
                    hiSenecaTextView.setText("Hi Eve");
                }
                if (changedRadio == R.id.fredRadioBtn) {
                    hiSenecaTextView.setText("Hi Fred");
                }
            }
        });

        firstRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.aliceRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Alice", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.bobRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Bob", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.carolRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Carol", Toast.LENGTH_SHORT).show();
                }

            }
        });
        secondRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.daveRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Dave", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.eveRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Eve", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.fredRadioBtn) {
                    Toast.makeText(getApplicationContext(), "Fred", Toast.LENGTH_SHORT).show();
                }

            }
        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (redBtn.isChecked()) {
                    Toast.makeText(getApplicationContext(), "red", Toast.LENGTH_SHORT).show();
                }
            }
        });
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yellowBtn.isChecked()) {
                    Toast.makeText(getApplicationContext(), "yellow", Toast.LENGTH_SHORT).show();
                }
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greenBtn.isChecked()) {
                    Toast.makeText(getApplicationContext(), "green", Toast.LENGTH_SHORT).show();
                }
            }
        });

        colorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer colors = new StringBuffer();
                if (redBtn.isChecked()) {
                    colors.append("red ");
                }
                if (yellowBtn.isChecked()) {
                    colors.append("yellow ");
                }
                if (greenBtn.isChecked()) {
                    colors.append("green ");
                }
                Toast.makeText(getApplicationContext(), colors, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
