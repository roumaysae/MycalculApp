package com.example.mycalculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.mycalculapp.R;
import android.content.pm.ActivityInfo;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonClear,buttonSign,buttonBackspace,buttonPercent;
    private double firstValue = 0.0;
    private double secondValue = 0.0;
    private String currentOperator =  "";
    private  Button buttonTopaysage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.textView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonDot = findViewById(R.id.buttonDecimal);
        buttonClear = findViewById(R.id.buttonClear);
        buttonSign = findViewById(R.id.buttonSign);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonTopaysage = findViewById(R.id.buttonTopaysage);

        View.OnClickListener numberButtonClickListener = v -> {
            Button b = (Button) v;
            resultText.append(b.getText().toString());
        };

        View.OnClickListener operatorButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                firstValue = Double.valueOf(resultText.getText().toString());
                resultText.setText("");
                currentOperator = b.getText().toString();
            }
        };

        buttonTopaysage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the orientation to landscape
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                // Start the landscape activity
                Intent intent = new Intent(MainActivity.this, Paysage_Format.class);
                startActivity(intent);
            }
        });


        button0.setOnClickListener(numberButtonClickListener);
        button1.setOnClickListener(numberButtonClickListener);
        button2.setOnClickListener(numberButtonClickListener);
        button3.setOnClickListener(numberButtonClickListener);
        button4.setOnClickListener(numberButtonClickListener);
        button5.setOnClickListener(numberButtonClickListener);
        button6.setOnClickListener(numberButtonClickListener);
        button7.setOnClickListener(numberButtonClickListener);
        button8.setOnClickListener(numberButtonClickListener);
        button9.setOnClickListener(numberButtonClickListener);
        buttonDot.setOnClickListener(numberButtonClickListener);
        buttonPlus.setOnClickListener(operatorButtonClickListener);
        buttonMinus.setOnClickListener(operatorButtonClickListener);
        buttonMultiply.setOnClickListener(operatorButtonClickListener);
        buttonDivide.setOnClickListener(operatorButtonClickListener);
        buttonSign.setOnClickListener(operatorButtonClickListener);
        buttonPercent.setOnClickListener(operatorButtonClickListener);
        buttonBackspace.setOnClickListener(operatorButtonClickListener);

        buttonBackspace.setOnClickListener( v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                String newText = currentText.substring(0, currentText.length() - 1);
                resultText.setText(newText);
            }
        });

        buttonSign.setOnClickListener( v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(-value));
            }
        });

        buttonPercent.setOnClickListener( v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(value / 100));
            }
        });
        buttonClear.setOnClickListener( v -> resultText.setText(""));

        buttonEqual.setOnClickListener( v -> {
            secondValue = Double.parseDouble(resultText.getText().toString());
            switch (currentOperator) {
                case "+":
                    resultText.setText(String.valueOf(firstValue + secondValue));
                    break;
                case "-":
                    resultText.setText(String.valueOf(firstValue - secondValue));
                    break;
                case "×":
                    resultText.setText(String.valueOf(firstValue * secondValue));
                    break;
                case "/":
                    resultText.setText(String.valueOf(firstValue / secondValue));
                    break;

            }
        });





    }
}