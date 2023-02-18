package com.tri.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CalcHistory extends AppCompatActivity {
    LinearLayout linearLayoutHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_history);

        ArrayList<String> exprs = getIntent().getStringArrayListExtra("exprs");
        linearLayoutHistory = findViewById(R.id.linearLayoutHistory);

        TextView textExpr = new TextView(this);
        textExpr.setTextSize(32);
        linearLayoutHistory.addView(textExpr);
        for (String expr : exprs) {
            textExpr.append(expr);
            textExpr.append("\n");
        }
    }
}