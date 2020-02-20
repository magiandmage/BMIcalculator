package com.example.BMIcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttun;      //計算開始ボタンへの参照
    private EditText hightnumber;   //身長入力欄への参照
    private EditText weightnumber;  //体重入力欄への参照
    private TextView kekka;         //BMI結果への参照
    private TextView hyouka;        //評価への参照


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttun = findViewById(R.id.button);  //ボタンの参照を取得
        hightnumber = findViewById(R.id.hightnumber); //身長入力欄の参照を取得
        weightnumber = findViewById(R.id.weightnumber); //体重入力欄の参照を取得
        kekka = findViewById(R.id.kekka); //BMI結果表示欄の参照を取得
        hyouka = findViewById(R.id.hyouka);


        buttun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double hightnumber_double = Double.valueOf(hightnumber.getText().toString());
                double weightnumber_double = Double.valueOf(weightnumber.getText().toString());
                double BMI = calcBMI(hightnumber_double, weightnumber_double);
                String result = String.format("%.2f" , BMI);
                kekka.setText(result);
                String HYOUKA = "";
                String hyoukabun = String.format("%s",HYOUKA );
                hyouka.setText(hyoukabun);
            }
        });
    }
    //BMI算出
     double calcBMI( double h, double w ){
        double bmi= 0;
        if(h > 0 && w > 0 ){
            bmi =  w / (h * h) * 10000;
        }
        return bmi;
    }

    //評価文分岐
    void bun (double bmi){

        if(bmi > 25.0){
           System.out.print("でぶ");
        }
        else if(bmi < 18.5){
            System.out.print("ほっそ");
        }
        else{
            System.out.print("ふつー");
        }

    }
}
