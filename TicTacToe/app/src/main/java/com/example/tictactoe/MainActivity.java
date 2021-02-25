package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    char boxes[][]= {{'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}};
    boolean playerChance = true;
    String player1,player2;
    int player1Score=0;
    int player2Score=0;
    TextView box11,box12,box13,box21,box22,box23,box31,box32,box33,tb1,tb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box11= (TextView)findViewById(R.id.button_00);
        box12= (TextView)findViewById(R.id.button_01);
        box13= (TextView)findViewById(R.id.button_02);
        box21= (TextView)findViewById(R.id.button_10);
        box22= (TextView)findViewById(R.id.button_11);
        box23= (TextView)findViewById(R.id.button_12);
        box31= (TextView)findViewById(R.id.button_20);
        box32= (TextView)findViewById(R.id.button_21);
        box33= (TextView)findViewById(R.id.button_22);
        tb1= (TextView)findViewById(R.id.tb1);
        tb2= (TextView)findViewById(R.id.tb2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player1= extras.getString("player1");
            player2=extras.getString("player2");
        }
        tb1.setText(player1+"-"+player1Score);
        tb2.setText(player2+"-"+player2Score);
    }
    public void reset(View view){
        player1Score=0;player2Score=0;
        tb1.setText(player1+"-"+player1Score);
        tb2.setText(player2+"-"+player2Score);
    }
    public boolean checkOver(){
        Character a,b,c;
        for(int i=0;i<3;i++){
            a = boxes[i][0];
            b = boxes[i][1];
            c = boxes[i][2];
            if(a.equals(b) && b.equals(c) && !b.equals('a')){
                Log.i("check",a+" "+b+" "+c);
                return true;
            }
            a = boxes[0][i];
            b = boxes[1][i];
            c = boxes[2][i];
            if(a.equals(b) && b.equals(c) && !b.equals('a')){
                return true;
            }
        }
        Character aa,ac,bb,cc,ca;
        aa=boxes[0][0];
        ac=boxes[0][2];
        bb=boxes[1][1];
        cc=boxes[2][2];
        ca=boxes[2][0];
        if(aa.equals(bb) && bb.equals(cc) && !bb.equals('a')){
            return true;
        }
        if(ac.equals(bb) && bb.equals(ca) && !bb.equals('a')){
            return true;
        }
        int x=0;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                Character aac = boxes[k][l];
                if(aac.equals('a')){
                    x=1;
                }
            }
        }
        if(x==0){
            clearBoard();
            Toast.makeText(this,"Its a tie",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    public void clearBoard(){
        box11.setText("");
        box12.setText("");
        box13.setText("");
        box21.setText("");
        box22.setText("");
        box23.setText("");
        box31.setText("");
        box32.setText("");
        box33.setText("");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boxes[i][j]='a';
            }
        }
    }
    public void afterEnd(){
        if(checkOver()){
            if(!playerChance){
                player2Score++;
                Toast.makeText(this,player2+" wins",Toast.LENGTH_SHORT).show();
            }
            else{
                player1Score++;
                Toast.makeText(this,player1+" wins",Toast.LENGTH_SHORT).show();
            }
            clearBoard();
        }
        tb1.setText(player1+"-"+player1Score);
        tb2.setText(player2+"-"+player2Score);
    }
    public void a11(View view){
        if(box11.getText().length()==0){
            if(playerChance){
                box11.setText("X");
                boxes[0][0]='X';
            }
            else {
                box11.setText("O");
                boxes[0][0]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a12(View view){
        if(box12.getText().length()==0){
            if(playerChance){
                box12.setText("X");
                boxes[0][1]='X';
            }
            else {
                box12.setText("O");
                boxes[0][1]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a13(View view){
        if(box13.getText().length()==0){
            if(playerChance){
                box13.setText("X");
                boxes[0][2]='X';
            }
            else{
                box13.setText("O");
                boxes[0][2]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a21(View view){
        if(box21.getText().length()==0){
            if(playerChance){
                box21.setText("X");
                boxes[1][0]='X';
            }
            else {
                box21.setText("O");
                boxes[1][0]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a22(View view){
        if(box22.getText().length()==0){
            if(playerChance){
                box22.setText("X");
                boxes[1][1]='X';
            }
            else{
                box22.setText("O");
                boxes[1][1]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a23(View view){
        if(box23.getText().length()==0){
            if(playerChance){
                box23.setText("X");
                boxes[1][2]='X';
            }
            else{
                box23.setText("O");
                boxes[1][2]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a31(View view){
        if(box31.getText().length()==0){
            if(playerChance){
                box31.setText("X");
                boxes[2][0]='X';
            }
            else{
                box31.setText("O");
                boxes[2][0]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a32(View view){
        if(box32.getText().length()==0){
            if(playerChance){
                box32.setText("X");
                boxes[2][1]='X';
            }
            else{
                box32.setText("O");
                boxes[2][1]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }
    public void a33(View view){
        if(box33.getText().length()==0){
            if(playerChance){
                box33.setText("X");
                boxes[2][2]='X';
            }
            else{
                box33.setText("O");
                boxes[2][2]='O';
            }
        }
        afterEnd();
        playerChance=!playerChance;
    }

}