package jp.techacademy.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }


    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog
                = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                Log.d("UI_PARTS", String.valueOf(hourOfday) + ":" + String.valueOf(minute));
                TextView textView = (TextView) findViewById(R.id.textView);
                if ((hourOfday >= 2) && (hourOfday < 10)) {
                    textView.setText("おはよう");

                } else if ((hourOfday >= 10) && (hourOfday < 18)) {
                    textView.setText("こんにちは");

                } else {
                    textView.setText("こんばんは");
                }
            }
        },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);



        timePickerDialog.show();



    }
}
