package com.example.studentwsb.kalkulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Boolean dodaje,odejmuje,mnoze,dziele;
    public String zawartosc;
    public int co;
    public void buttonValue(View view){
        Button btn = (Button) view;
        EditText edit = findViewById(R.id.editText);
        String zawartosc = edit.getText().toString();
        zawartosc += btn.getText().toString();
        edit.setText(zawartosc);
    }

    public void buttonMinus(View view){
        EditText edit = findViewById(R.id.editText);
        co = Integer.parseInt(edit.getText().toString());
        edit.setText("");
        odejmuje = true;
        dziele = false;
        mnoze = false;
        dodaje = false;
    }
    public void buttonErase(View view){
        EditText edit = findViewById(R.id.editText);
        edit.setText("");
    }
    public void buttonPlus(View view){
        EditText edit = findViewById(R.id.editText);
        co = Integer.parseInt(edit.getText().toString());
        edit.setText("");
        dodaje = true;
        odejmuje=false;
        dziele=false;
        mnoze=false;
    }
    public void buttonMultiply(View view){
        EditText edit = findViewById(R.id.editText);
        co = Integer.parseInt(edit.getText().toString());
        edit.setText("");
        dziele = false;
        mnoze = true;
        dodaje = false;
        odejmuje = false;
    }
    public void buttonDivide(View view){
        EditText edit = findViewById(R.id.editText);
        co = Integer.parseInt(edit.getText().toString());
        edit.setText("");
        dziele = true;
        mnoze = false;
        dodaje = false;
        odejmuje = false;
    }
    public void buttonEquals(View view){
        EditText edit = findViewById(R.id.editText);
        int doCzego = Integer.parseInt(edit.getText().toString());
        int wynik = co;
        if(dodaje){
            wynik+=doCzego;
            dodaje = false;
        }
        else if(odejmuje){
            wynik-=doCzego;
            odejmuje=false;
        }
        else if(dziele){
            if(doCzego == 0){
                Toast.makeText(getApplicationContext(),"Pamiętaj cholero nie dziel przez...",Toast.LENGTH_SHORT).show();
            }
            else
            wynik/=doCzego;
        }
        else if(mnoze){
            wynik*=doCzego;
        }
        String wyswietlWiad = Integer.toString(wynik);
        edit.setText(wyswietlWiad);
       // Toast.makeText(getApplicationContext(),wyswietlWiad,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
