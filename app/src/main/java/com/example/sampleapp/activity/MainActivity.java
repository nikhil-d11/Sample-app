package com.example.sampleapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sampleapp.database.CheckListWithDBActivity;
import com.example.sampleapp.databinding.Calculator;
import com.example.sampleapp.databinding.CalculatorActivity;
import com.example.sampleapp.recyclerview.ChecklistActivity;
import com.example.sampleapp.R;

public class MainActivity extends AppCompatActivity {

    final static private int share_return_code=1;
    String edit_text="";
    Integer i=0;
    TextView print_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text=findViewById(R.id.edittext_string);


        print_int=findViewById(R.id.textview_print);
        Button button=findViewById(R.id.button_share_activity);


        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edit_text=s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ShareActivity.class);
                Log.d("testing edittext",""+text.getText());
                intent.putExtra("title",text.getText().toString());
                startActivityForResult(intent,share_return_code);
            }
        });

        Button button_checklistactivity=findViewById(R.id.button_checklist_activity);
        button_checklistactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ChecklistActivity.class);
                startActivity(i);
            }
        });

        Button button_checklistactivity_roomdb=findViewById(R.id.button_checklist_activity_roomdb);
        button_checklistactivity_roomdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CheckListWithDBActivity.class);
                startActivity(i);
            }
        });

        Button button_calculator=findViewById(R.id.button_calculator);
        button_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==share_return_code){
            if (resultCode== Activity.RESULT_OK){
               i=data.getIntExtra("data",0);
               Log.d("testing result",i.toString());
               print_int.setText(i.toString());

            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("edit",edit_text);
        outState.putInt("int",i);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        edit_text=savedInstanceState.getString("edit");
        i=savedInstanceState.getInt("int");

        Log.d("testing restoreinstance",edit_text.toString()+"  "+i.toString());

    }
}