package com.example.sampleapp.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.sampleapp.R;

public class CalculatorActivity extends AppCompatActivity {

    ActivityCalculatorBinding activityCalculatorBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        activityCalculatorBinding= DataBindingUtil.setContentView(this,R.layout.activity_calculator);

        Calculator calculator=new Calculator();
        activityCalculatorBinding.setCalculator(calculator);


    }

}