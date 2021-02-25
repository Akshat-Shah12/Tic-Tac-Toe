package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Start extends AppCompatActivity {

    EditText p1,p2;
    String a;
    String b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        p1=(EditText)findViewById(R.id.p1);
        p2=(EditText)findViewById(R.id.p2);
    }
    public void startGame(View view){
        if(p1.getText().length()==0 || p2.getText().length()==0){
            Toast.makeText(this,"Please enter the names",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent();
            i.setClass(this, MainActivity.class);
            a=p1.getText().toString();
            b=p2.getText().toString();
            i.putExtra("player1",a);
            i.putExtra("player2",b);
            startActivity(i);
        }
    }
}