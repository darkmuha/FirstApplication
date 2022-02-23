package com.hfad.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView day_count;
    private TextView last_clicked;
    private TextView best;
    private Button btn;
    private Array listOfDates;
    private int counter;
    private Date date;
    private String output1;

    @Override
    public void onClick(View v) {
        last_clicked.setText(output1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        day_count = findViewById(R.id.day_count);
        last_clicked = findViewById(R.id.last_clicked);
        best = findViewById(R.id.best);
        btn = findViewById(R.id.btn);

        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
        date = new Date();
        output1 = sdf.format(date);
        counter = 0;

        btn.setOnClickListener(this);


    }
}