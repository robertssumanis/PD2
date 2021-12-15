package com.example.pd2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAlertDialog();
            }
        });

        Button on_Second = (Button) findViewById(R.id.on_second);
        on_Second.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "GOING TO SECOND ACTIVITY", Toast.LENGTH_SHORT).show();
                Intent tosecond = new Intent (getApplicationContext(), SecondActivity.class);
                startActivity(tosecond);
            }
        });
    }
    private void CreateAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("8 Group's Dialog");

        builder.setMultiChoiceItems(R.array.Names, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String arr[] = getResources().getStringArray(R.array.Names);

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), arr[which] + " checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), arr[which] + " unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(getApplicationContext(), "You closed dialog", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton(android.R.string.ok, null);

        builder.create();

        Button positiveButton = builder.show().getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Toast.makeText(getApplicationContext(), "You clicked OK", Toast.LENGTH_SHORT).show();
            }
        });
    }

}