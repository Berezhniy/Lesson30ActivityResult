package ru.startandroid.lesson30activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class Align extends AppCompatActivity implements View.OnClickListener {
    Button btnRight, btnCenter, btnLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);
        //нахожу view по id
        btnRight = findViewById(R.id.btnRight);
        btnCenter = findViewById(R.id.btnCenter);
        btnLeft = findViewById(R.id.btnLeft);
        //вешаю слушатель
        btnRight.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //создаю и инициализирую intent
        Intent intent = new Intent();
        switch (v.getId()) {
            //В зависимости от нажатой кнопки, определённые данные будут занесены в intent
            case R.id.btnLeft:
                intent.putExtra("align", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("align", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("align", Gravity.RIGHT);
                break; }
        setResult(RESULT_OK, intent);
        finish();
    }
}
