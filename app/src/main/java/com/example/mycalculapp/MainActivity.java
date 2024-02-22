    package com.example.mycalculapp;

    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.content.pm.ActivityInfo;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import org.mariuszgromada.math.mxparser.*;

    public class MainActivity extends AppCompatActivity {

        private TextView resultText;
        private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonClear, buttonBackspace, buttonPercent, buttonTopaysage;
        private Button buttonSign;
        private Expression expression = new Expression(""); // mxparser expression object
        private String currentExpression = ""; // Current expression string

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
            buttonBackspace = findViewById(R.id.buttonBackspace);
            buttonPercent = findViewById(R.id.buttonPercent);
            buttonTopaysage = findViewById(R.id.buttonTopaysage);
            buttonSign=findViewById(R.id.buttonSign);
            // Button click listeners for number buttons
            View.OnClickListener numberButtonClickListener = v -> {
                Button b = (Button) v;
                appendToExpression(b.getText().toString());
            };

            // Button click listener for operator buttons
            View.OnClickListener operatorButtonClickListener = v -> {
                Button b = (Button) v;
                appendToExpression(" " + b.getText().toString() + " ");
            };

            // Assign click listeners to number buttons
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

            // Assign click listeners to operator buttons
            buttonPlus.setOnClickListener(operatorButtonClickListener);
            buttonMinus.setOnClickListener(operatorButtonClickListener);
            buttonMultiply.setOnClickListener(operatorButtonClickListener);
            buttonDivide.setOnClickListener(operatorButtonClickListener);

            // Clear the expression when the clear button is clicked
            buttonClear.setOnClickListener(v -> clearExpression());

            // Handle backspace functionality
            buttonBackspace.setOnClickListener(v -> backspace());

            // Calculate the result when the equal button is clicked
            buttonEqual.setOnClickListener(v -> evaluateExpression());


            buttonPercent.setOnClickListener( v -> {
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    double value = Double.parseDouble(currentText);
                    resultText.setText(String.valueOf(value / 100));
                }
            });


// Handle sign button functionality
            buttonSign.setOnClickListener( v -> {
                String currentText = resultText.getText().toString();
                if (!currentText.isEmpty()) {
                    double value = Double.parseDouble(currentText);
                    resultText.setText(String.valueOf(-value));
                }
            });

            // Switch to landscape mode when the landscape button is clicked
            buttonTopaysage.setOnClickListener(v -> {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                Intent intent = new Intent(MainActivity.this, Paysage_Format.class);
                startActivity(intent);
            });
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
            expression.setExpressionString(currentExpression);
            double result = expression.calculate();
            resultText.setText(String.valueOf(result));
        }
    }
