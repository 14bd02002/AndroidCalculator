package com.example.a1.calculatornew;

import android.os.StrictMode;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String textBtn, sign = "", res;
    private Double previousNumber = 0.0, nextNumber = 0.0, result = 0.0;
    private int index = 0;
    private static final String TAG = "LifecycleActivity";
    private boolean b1 = true;

    String str;
    DecimalFormat format = new DecimalFormat();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView)findViewById(R.id.main_text);
        textBtn = "";
        Log.d(TAG, "onCreate");

        if (savedInstanceState != null){
            str = savedInstanceState.getString("str");
            previousNumber = savedInstanceState.getDouble("previousNumber");
            nextNumber = savedInstanceState.getDouble("nextNumber");
            sign = savedInstanceState.getString("sign");
            Log.d("String", str);
            Log.d("String1", previousNumber.toString());
            Log.d("String2", nextNumber.toString());
            screen.setText(str);
        }


    }

    public void onClickBtn(View v) {
        b1 = true;
        Button button = (Button) v;
        textBtn += button.getText().toString();
        screen.setText(textBtn);
        if(sign == "") {
            previousNumber = Double.parseDouble(textBtn);
        }
    }

    public void onClickC(View v) {
        b1 = true;
        Button button = (Button) v;
        textBtn = "";
        sign = "";
        result = 0.0;
        index = 0;
        screen.setText("");
    }

    public void onClickSigns(View v) {
        b1 = true;
        Button button = (Button) v;
        sign = button.getText().toString();
        screen.setText(sign);
        if(index != 0) {
            previousNumber = operation();
            Log.d(previousNumber.toString(), "fdd");
        }
        textBtn = "";
        index++;
    }

    public void calculate(View v) {
        if(b1) {
            result = operation();
            format.setDecimalSeparatorAlwaysShown(false);
            screen.setText(format.format(result).toString());
            b1 = false;
        }

    }

    public Double operation() {
        res = screen.getText().toString();
        nextNumber = Double.parseDouble(res);
        if(sign.equals("+")) {
            result = previousNumber+nextNumber;
        }
        else if(sign.equals("-")) {
            result = previousNumber-nextNumber;
        }
        else if(sign.equals("*")) {
            result = previousNumber*nextNumber;
        }
        else if(sign.equals("/")) {
            result = previousNumber / nextNumber;
        }
        return  result;
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



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("str", screen.getText().toString());
        outState.putDouble("previousNumber", previousNumber);
        outState.putDouble("nextNumber", nextNumber);
        outState.putString("sign", sign);
        super.onSaveInstanceState(outState);
    }



}
