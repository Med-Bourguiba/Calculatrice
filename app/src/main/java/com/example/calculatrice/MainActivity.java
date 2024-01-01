package com.example.calculatrice;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText num1 = findViewById(R.id.editTextTextPassword6);
        EditText num2 = findViewById(R.id.editTextTextPassword7);
        RadioGroup group = findViewById(R.id.radioGroup);
        Button calcBtn = findViewById(R.id.button3);
        TextView res = findViewById(R.id.textView2);
        Button btnSupp = findViewById(R.id.buttonSupprimer);


        calcBtn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Num1 And Num2 Not Allowed To be empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double r = 0;
                    double n1 = Double.parseDouble(num1.getText().toString());
                    double n2 = Double.parseDouble(num2.getText().toString());
                    int selectedId = group.getCheckedRadioButtonId();

                    if (selectedId == -1) {
                        Toast.makeText(MainActivity.this, "Veuillez sélectionner un opérateur", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    RadioButton selectedRadio = findViewById(selectedId);



                    switch(selectedRadio.getText().toString()) {
                        case "+" : {
                            r = n1 + n2;
                            break;
                        }
                        case "-" : {
                            r = n1 - n2;
                            break;
                        }
                        case "*" : {
                            r = n1 * n2;
                            break;
                        }
                        case "/" : {
                            r = n1 / n2;
                            break;
                        }
                        default:
                            throw new IllegalStateException("Unexpected value: " + selectedRadio.getText());
                    }

                    System.out.println(r);

                    res.setText(n1 + " " + selectedRadio.getText().toString() + " " + n2 + " = " + r);
                    num1.setText("");
                    num2.setText("");
                    group.clearCheck();

                } catch(Exception e) {
                    Toast.makeText(MainActivity.this, "Num1 And Num2 Must Be Integers Or Doubles", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSupp.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                res.setText("");
            }
        });


    }
}
