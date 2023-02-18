package com.tri.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonEqual, buttonDiv, buttonMult, buttonPlus, buttonMinus, buttonCLR, buttonDEL, buttonHistory;
    EditText editTextExpr;
    TextView textViewResult;

    ArrayList<String> exprs = new ArrayList<String>();
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
        buttonHistory = findViewById(R.id.buttonHistory);

        editTextExpr = findViewById(R.id.editTextExpr);
        textViewResult = findViewById(R.id.textViewResult);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextExpr.setText(editTextExpr.getText() + "9");
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
                editTextExpr.setText("");
            }
        });

        buttonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextExpr.getText().toString();
                text = text.substring(0, text.length() - 1);
                editTextExpr.setText(text);
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHistory = new Intent(getApplicationContext(), CalcHistory.class);
                toHistory.putExtra("exprs", exprs);
                startActivity(toHistory);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextExpr.getText().toString().length() != 0 && v1 != null) {
                    v2 = Integer.parseInt(editTextExpr.getText().toString());
                    switch (operator) {
                        case PLUS:
                            textViewResult.setText(String.valueOf(v1 + v2));
                            exprs.add(String.format("%d + %d = %d", v1, v2, v1 + v2));
                            break;
                        case MINUS:
                            textViewResult.setText(String.valueOf(v1 - v2));
                            exprs.add(String.format("%d - %d = %d", v1, v2, v1 - v2));
                            break;
                        case MULT:
                            textViewResult.setText(String.valueOf(v1 * v2));
                            exprs.add(String.format("%d * %d = %d", v1, v2, v1 * v2));
                            break;
                        case DIV:
                            textViewResult.setText(String.valueOf(v1 / v2));
                            exprs.add(String.format("%d / %d = %d", v1, v2, v1 / v2));
                            break;
                    }
                }
            }
        });
    }

    protected void operatorClick(Operation op) {
        if (editTextExpr.getText().toString().length() == 0) {
            editTextExpr.setText("");
        } else {
            v1 = Integer.parseInt(editTextExpr.getText().toString());
            operator = op;
            editTextExpr.setText("");
        }
    }
}