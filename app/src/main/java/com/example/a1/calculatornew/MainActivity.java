package com.example.a1.calculatornew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String textBtn, sign = "", res;
    private Double first = 0.0, second = 0.0, result = 0.0;
    private int index = 0;
    private static final String TAG = "Lifecycle";
    private boolean b1 = true;

    String str;
    DecimalFormat format = new DecimalFormat();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView)findViewById(R.id.main_text);
        textBtn = "";

        if (savedInstanceState != null){
            str = savedInstanceState.getString("text");
            first = savedInstanceState.getDouble("first");
            second = savedInstanceState.getDouble("second");
            sign = savedInstanceState.getString("sign");
            display.setText(str);
        }
    }
    public Double Count() {
        res = display.getText().toString();
        second = Double.parseDouble(res);
        if(sign.equals("+")) {
            result = first + second;
        }
        else if(sign.equals("-")) {
            result = first - second;
        }
        else if(sign.equals("*")) {
            result = first * second;
        }
        else if(sign.equals("/")) {
            result = first / second;
        }
        return  result;
    }
    public void onClickBtn(View v) {
        b1 = true;
        Button button = (Button) v;
        textBtn += button.getText().toString();
        display.setText(textBtn);
        if(sign == "") {
            first = Double.parseDouble(textBtn);
        }
    }

    public void onClickC(View v) {
        b1 = true;
        Button button = (Button) v;
        textBtn = "";
        sign = "";
        result = 0.0;
        index = 0;
        display.setText("");
    }

    public void onClickSigns(View v) {
        b1 = true;
        Button button = (Button) v;
        sign = button.getText().toString();
        display.setText(sign);
        if(index != 0) {
            first = Count();
        }
        textBtn = "";
        index++;
    }

    public void calculate(View v) {
        if(b1) {
            result = Count();
            format.setDecimalSeparatorAlwaysShown(false);
            display.setText(format.format(result).toString());
            b1 = false;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("text", display.getText().toString());
        outState.putDouble("first", first);
        outState.putDouble("second", second);
        outState.putString("sign", sign);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.d(TAG, "onDestroy");
    }
}
