package com.example.mycalculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class Paysage_Format extends AppCompatActivity {
    private TextView resultText;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonClear, buttonBackspace, buttonPercent;
    private Button buttonSign;
    private String currentExpression = ""; // Current expression string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paysage_format);

        // Initialize views
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
        buttonBackspace = findViewById(R.id.buttonBackspace);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonSign=findViewById(R.id.buttonSign);

        // Set click listeners for number buttons
        setNumberButtonClickListeners();

        // Set click listeners for operator buttons
        setOperatorButtonClickListeners();

        // Set click listener for clear button
        buttonClear.setOnClickListener(v -> clearExpression());

        // Handle backspace functionality
        buttonBackspace.setOnClickListener(v -> backspace());

        // Calculate the result when the equal button is clicked
        buttonEqual.setOnClickListener(v -> evaluateExpression());

        // Set click listener for percent button
        buttonPercent.setOnClickListener(v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(value / 100));
            }
        });

        // Set click listener for sign button
        buttonSign.setOnClickListener(v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(-value));
            }
        });

        // Handle click listeners for scientific operations buttons using mxparser
        Button buttonSqrt = findViewById(R.id.buttonSqrt);
        buttonSqrt.setOnClickListener(v -> appendToExpression("sqrt("));

        Button buttonSquare = findViewById(R.id.buttonSquare);
        buttonSquare.setOnClickListener(v -> appendToExpression("^2"));

        Button buttonPower = findViewById(R.id.buttonPower);
        buttonPower.setOnClickListener(v -> appendToExpression("^"));

        Button buttonPi = findViewById(R.id.buttonPi);
        buttonPi.setOnClickListener(v -> appendToExpression(String.valueOf(Math.PI)));

        Button buttonSin = findViewById(R.id.buttonSin);
        buttonSin.setOnClickListener(v -> appendToExpression("sin("));

        Button buttonCos = findViewById(R.id.buttonCos);
        buttonCos.setOnClickListener(v -> appendToExpression("cos("));

        Button buttonTan = findViewById(R.id.buttonTan);
        buttonTan.setOnClickListener(v -> appendToExpression("tan("));

        Button buttonLog = findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(v -> appendToExpression("log("));

        Button buttonLn = findViewById(R.id.buttonLn);
        buttonLn.setOnClickListener(v -> appendToExpression("ln("));

        Button buttonFactorial = findViewById(R.id.buttonFactorial);
        buttonFactorial.setOnClickListener(v -> appendToExpression("!"));

        Button buttonE = findViewById(R.id.buttonE);
        buttonE.setOnClickListener(v -> appendToExpression("e"));

        Button buttonModulus = findViewById(R.id.buttonModulus);
        buttonModulus.setOnClickListener(v -> appendToExpression("abs("));

        Button buttonOpenParenthesis = findViewById(R.id.buttonOpenParenthesis);
        buttonOpenParenthesis.setOnClickListener(v -> appendToExpression("("));

        Button buttonCloseParenthesis = findViewById(R.id.buttonCloseParenthesis);
        buttonCloseParenthesis.setOnClickListener(v -> appendToExpression(")"));

        Button buttonComma = findViewById(R.id.buttonComma);
        buttonComma.setOnClickListener(v -> appendToExpression(","));

        Button buttonRad = findViewById(R.id.buttonRad);
        buttonRad.setOnClickListener(v -> appendToExpression("rad("));

        Button buttonDeg = findViewById(R.id.buttonDeg);
        buttonDeg.setOnClickListener(v -> appendToExpression("deg("));

        Button buttonInverse = findViewById(R.id.buttonInverse);
        buttonInverse.setOnClickListener(v -> appendToExpression("^(-1)"));

        Button buttonAbs = findViewById(R.id.buttonAbs);
        buttonAbs.setOnClickListener(v -> appendToExpression("abs("));

        Button buttonExp = findViewById(R.id.buttonExp);
        buttonExp.setOnClickListener(v -> appendToExpression("exp("));

    }

    // Method to set click listeners for number buttons
    private void setNumberButtonClickListeners() {
        View.OnClickListener numberButtonClickListener = v -> {
            Button b = (Button) v;
            appendToExpression(b.getText().toString());
        };

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
        buttonDot.setOnClickListener(v -> appendToExpression("."));
    }

    // Method to set click listeners for operator buttons
    private void setOperatorButtonClickListeners() {
        View.OnClickListener operatorButtonClickListener = v -> {
            Button b = (Button) v;
            appendToExpression(" " + b.getText().toString() + " ");
        };

        buttonPlus.setOnClickListener(operatorButtonClickListener);
        buttonMinus.setOnClickListener(operatorButtonClickListener);
        buttonMultiply.setOnClickListener(operatorButtonClickListener);
        buttonDivide.setOnClickListener(operatorButtonClickListener);
    }

    // Method to append text to the current expression
    private void appendToExpression(String text) {
        currentExpression += text;
        resultText.setText(currentExpression);
    }

    // Method to clear the current expression
    private void clearExpression() {
        currentExpression = "";
        resultText.setText("");
    }

    // Method to handle backspace functionality
    private void backspace() {
        if (currentExpression.length() > 0) {
            currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
            resultText.setText(currentExpression);
        }
    }

    // Method to evaluate the current expression and display the result
    private void evaluateExpression() {
        Expression expression = new Expression(currentExpression);
        double result = expression.calculate();
        resultText.setText(String.valueOf(result));
    }

    @Override
    public void onBackPressed() {
        // Start MainActivity when back button is pressed
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
