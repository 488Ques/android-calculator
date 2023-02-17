package com.tri.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonEqual, buttonDiv, buttonMult, buttonPlus, buttonMinus, buttonCLR, buttonDEL;
    EditText editTextResult;

    Integer v1, v2;

    enum Operation {
        PLUS,
        MINUS,
        MULT,
        DIV
    }

    Operation operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMult = findViewById(R.id.buttonMult);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonCLR = findViewById(R.id.buttonCLR);
        buttonDEL = findViewById(R.id.buttonDEL);

        editTextResult = findViewById(R.id.editTextResult);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText(editTextResult.getText() + "9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClick(Operation.PLUS);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClick(Operation.MINUS);
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClick(Operation.MULT);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClick(Operation.DIV);
            }
        });

        buttonCLR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextResult.setText("");
            }
        });

        buttonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextResult.getText().toString();
                text = text.substring(0, text.length() - 1);
                editTextResult.setText(text);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextResult.getText().toString().length() != 0 && v1 != null) {
                    v2 = Integer.parseInt(editTextResult.getText().toString());
                    switch (operator) {
                        case PLUS:
                            editTextResult.setText(String.valueOf(v1 + v2));
                            break;
                        case MINUS:
                            editTextResult.setText(v1 - v2 + "");
                            break;
                        case MULT:
                            editTextResult.setText(v1 * v2 + "");
                            break;
                        case DIV:
                            editTextResult.setText(v1 / v2 + "");
                            break;
                    }
                }
            }
        });
    }

    protected void operatorClick(Operation op) {
        if (editTextResult.getText().toString().length() == 0) {
            editTextResult.setText("");
        } else {
            v1 = Integer.parseInt(editTextResult.getText().toString());
            operator = op;
            editTextResult.setText("");
        }
    }
}