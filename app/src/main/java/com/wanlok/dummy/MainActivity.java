package com.wanlok.dummy;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wanlok_dummy_android.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button btnDatePicker;
    private TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvSelectedDate.setText(year + "/" + String.format("%02d", month + 1) + "/" + day);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        tvSelectedDate.setText(year + "/" + String.format("%02d", month + 1) + "/" + day);
                    }
                }, year, month, day);
                datePickerDialog.show();
                datePickerDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
                datePickerDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GREEN);
            }
        });
    }
}