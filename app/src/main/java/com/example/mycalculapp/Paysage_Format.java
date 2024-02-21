package com.example.mycalculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Paysage_Format extends AppCompatActivity {
    private TextView resultText;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonClear,buttonSign,buttonBackspace,buttonPercent;

    private double firstValue = 0.0;
    private double secondValue = 0.0;
    private String currentOperator =  "";
//
   private Button buttonToportrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paysage_format);

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
      buttonToportrait = findViewById(R.id.buttonToportrait);
//Paysage format buttons:
        Button buttonSqrt = findViewById(R.id.buttonSqrt);
        Button buttonSquare = findViewById(R.id.buttonSquare);
        Button buttonPower = findViewById(R.id.buttonPower);
        Button buttonPi = findViewById(R.id.buttonPi);
        Button buttonSin = findViewById(R.id.buttonSin);
        Button buttonCos = findViewById(R.id.buttonCos);
        Button buttonTan = findViewById(R.id.buttonTan);
        Button buttonLog = findViewById(R.id.buttonLog);
        Button buttonLn = findViewById(R.id.buttonLn);
        Button buttonFactorial = findViewById(R.id.buttonFactorial);
        Button buttonE = findViewById(R.id.buttonE);
        Button buttonModulus = findViewById(R.id.buttonModulus);
        Button buttonOpenParenthesis = findViewById(R.id.buttonOpenParenthesis);
        Button buttonCloseParenthesis = findViewById(R.id.buttonCloseParenthesis);
        Button buttonComma = findViewById(R.id.buttonComma);
        Button buttonRad = findViewById(R.id.buttonRad);
        Button buttonDeg = findViewById(R.id.buttonDeg);
        Button buttonInverse = findViewById(R.id.buttonInverse);
        Button buttonAbs = findViewById(R.id.buttonAbs);
        Button buttonExp = findViewById(R.id.buttonExp);

      buttonToportrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Paysage_Format.this, MainActivity.class);
                startActivity(intent);
            }
        });

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                resultText.append(b.getText().toString());
            }
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
//buttons of paysage mode :
        buttonSqrt.setOnClickListener(numberButtonClickListener);
        buttonSquare.setOnClickListener(numberButtonClickListener);
        buttonPower.setOnClickListener(numberButtonClickListener);
        buttonPi.setOnClickListener(numberButtonClickListener);
        buttonSin.setOnClickListener(numberButtonClickListener);
        buttonCos.setOnClickListener(numberButtonClickListener);
        buttonTan.setOnClickListener(numberButtonClickListener);
        buttonLog.setOnClickListener(numberButtonClickListener);
        buttonLn.setOnClickListener(numberButtonClickListener);
        buttonFactorial.setOnClickListener(numberButtonClickListener);
        buttonE.setOnClickListener(numberButtonClickListener);
        buttonModulus.setOnClickListener(numberButtonClickListener);
        buttonOpenParenthesis.setOnClickListener(numberButtonClickListener);
        buttonCloseParenthesis.setOnClickListener(numberButtonClickListener);
        buttonComma.setOnClickListener(numberButtonClickListener);
        buttonRad.setOnClickListener(numberButtonClickListener);
        buttonDeg.setOnClickListener(numberButtonClickListener);
        buttonInverse.setOnClickListener(numberButtonClickListener);
        buttonAbs.setOnClickListener(numberButtonClickListener);
        buttonExp.setOnClickListener(numberButtonClickListener);

        //defining the buttons fucntions!:
        buttonSqrt.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double sqrt = Math.sqrt(value);
            resultText.setText(String.valueOf(sqrt));
        });
        buttonSquare.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double square = value * value;
            resultText.setText(String.valueOf(square));
        });

        buttonPower.setOnClickListener(v -> {
                firstValue = Double.parseDouble(resultText.getText().toString());
                resultText.setText(""); // Clear the result text after operator click
                currentOperator = "^"; // Setting operator to indicate power operation
            });
        buttonPi.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double pi=value*3.14;
            resultText.setText(String.valueOf(pi));
            });

        buttonSin.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double sinValue = Math.sin(value);
            resultText.setText(String.valueOf(sinValue));
        });

        buttonCos.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double cosValue = Math.cos(value);
            resultText.setText(String.valueOf(cosValue));
        });

        buttonTan.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double tanValue = Math.tan(value);
            resultText.setText(String.valueOf(tanValue));
        });

        buttonLog.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double logValue = Math.log10(value);
            resultText.setText(String.valueOf(logValue));
        });

        buttonLn.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double lnValue = Math.log(value);
            resultText.setText(String.valueOf(lnValue));
        });

        buttonFactorial.setOnClickListener(v -> {
            int value = Integer.parseInt(resultText.getText().toString());
            int factorial = 1;
            for (int i = 1; i <= value; i++) {
                factorial *= i;
            }
            resultText.setText(String.valueOf(factorial));
        });

        buttonE.setOnClickListener(v -> {
            double eValue = Math.E;
            resultText.setText(String.valueOf(eValue));
        });

        buttonModulus.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double modulus = Math.abs(value);
            resultText.setText(String.valueOf(modulus));
        });

        buttonOpenParenthesis.setOnClickListener(v -> resultText.append("("));

        buttonCloseParenthesis.setOnClickListener(v -> resultText.append(")"));

        buttonComma.setOnClickListener(v -> resultText.append(","));

        buttonRad.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            // Check if the value is already in radians
            if (value >= 0 && value <= 2 * Math.PI) {
                // Value is in radians, no need to convert
                resultText.setText(String.valueOf(value));
            } else {
                // Value is in degrees, convert to radians
                double radValue = Math.toRadians(value);
                resultText.setText(String.valueOf(radValue));
            }
        });
        buttonDeg.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double degValue = Math.toDegrees(value);
            resultText.setText(String.valueOf(degValue));
        });

        buttonInverse.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double inverse = 1 / value;
            resultText.setText(String.valueOf(inverse));
        });

        buttonAbs.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double absValue = Math.abs(value);
            resultText.setText(String.valueOf(absValue));
        });

        buttonExp.setOnClickListener(v -> {
            double value = Double.parseDouble(resultText.getText().toString());
            double expValue = Math.exp(value);
            resultText.setText(String.valueOf(expValue));
        });



        buttonBackspace.setOnClickListener(v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                String newText = currentText.substring(0, currentText.length() - 1);
                resultText.setText(newText);
            }
        });

        buttonSign.setOnClickListener(v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(-value));
            }
        });


        buttonPercent.setOnClickListener(v -> {
            String currentText = resultText.getText().toString();
            if (!currentText.isEmpty()) {
                double value = Double.parseDouble(currentText);
                resultText.setText(String.valueOf(value / 100));
            }
        });

        buttonClear.setOnClickListener(v -> resultText.setText(""));

        buttonEqual.setOnClickListener(v -> {
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
                case "^":
                    resultText.setText(String.valueOf(Math.pow(firstValue, secondValue)));
                    break;
                case "/":
                    resultText.setText(String.valueOf(firstValue / secondValue));
                    break;

            }   });
    }

}