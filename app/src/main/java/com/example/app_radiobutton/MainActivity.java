package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Creamos los atributos
    EditText et1;
    EditText et2;
    RadioButton rb1;
    RadioButton rb2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Convertimos cada view a su tipo correspondiente
        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);

        rb1 = (RadioButton)findViewById(R.id.rb_sumar);
        rb2 = (RadioButton)findViewById(R.id.rb_restar);

        tv =  (TextView)findViewById(R.id.tv_resultado);


    }

    public void calcular(View view){
        //Transformamos los editText a String.
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();



        //Comprobamos si algun valor esta vacio para que muestre un aviso
        if (valor1.isEmpty() && valor2.isEmpty() || valor1.isEmpty() || valor2.isEmpty()){
            Toast.makeText(this, "Escribe los dos valores", Toast.LENGTH_LONG).show();
        }else{
            //Los String los tranformamos ahora a Integer
            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);
            if (rb1.isChecked()){
                //Transformamos el resultado de la suma en String y despues lo mostramos
                String resultado = String.valueOf(sumar(num1,num2));
                tv.setText(resultado);
            }else if(rb2.isChecked()){
                //Transformamos el resultado de la resta en String y despues lo mostramos
                String resultado = String.valueOf(restar(num1,num2));
                tv.setText(resultado);
            } else{
                Toast.makeText(this, "Tienes que seleccionar una de las opciones", Toast.LENGTH_LONG).show();
            }
        }

    }

    public int sumar(int valor1, int valor2){

        return valor1 + valor2;

    }

    public int restar(int valor1, int valor2){

        return valor1 - valor2;
    }
}