package ru.startandroid.lesson30activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;
    TextView tvText;
    Button btnColor, btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //нахожу view по id
        tvText = findViewById(R.id.tvText);
        btnColor = findViewById(R.id.btnColor);
        btnAlign = findViewById(R.id.btnAlign);
        //вешаю слушатель
        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //создаю intent
        Intent intent;
        switch (v.getId()){
            case R.id.btnColor:
                intent = new Intent(this, Color.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, Align.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
                break; }
    }
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        //записываю в лог значения requestCode и resultCode
        Log.d("MyLogs", "requestCode" + requestCode + "resultCode" + resultCode);
        //если пришел результат
        if(resultCode == RESULT_OK){
            //в зависимости от того какой REQUEST_CODE пришел выполняется определённый case
            switch (requestCode){
                case REQUEST_CODE_COLOR :
                    int color = data.getIntExtra("color", android.graphics.Color.WHITE);
                    tvText.setTextColor(color);
                    break;
                case REQUEST_CODE_ALIGN :
                    int align = data.getIntExtra("align", Gravity.LEFT);
                    tvText.setGravity(align);
                    break; }
        }//если результата нет выводим тост с определённым текстом и продолжительностью
        else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }
}
