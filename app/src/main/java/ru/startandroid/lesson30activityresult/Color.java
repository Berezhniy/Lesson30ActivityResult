package ru.startandroid.lesson30activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Color extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //нахожу view по id
        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        //вешаю слушатель
        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //создаю и инициализирую intent
        Intent intent = new Intent();
        //В зависимости от нажатой кнопки, определённые данные будут занесены в intent
        switch (v.getId()){
            case R.id.btnRed:
        intent.putExtra("color", android.graphics.Color.RED);
        break;
            case R.id.btnGreen:
        intent.putExtra("color", android.graphics.Color.GREEN);
        break;
            case R.id.btnBlue:
        intent.putExtra("color", android.graphics.Color.BLUE);
        break;}
        setResult(RESULT_OK, intent);
        finish();
    }
}
