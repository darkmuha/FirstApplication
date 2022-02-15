package com.hfad.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView lastClicked;
    TextView dayCount;
    Button btn;
    double date;
    double oldDate;
    String data;

    @Override
    public void onClick(View v) {
                lastClicked.setText(data);
                oldDate = date;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastClicked = findViewById(R.id.last_clicked);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        lastClicked = (TextView) findViewById(R.id.last_clicked);
        date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
        data = sdf.format(date);
        oldDate = 0F;

        dayCount = (TextView) findViewById(R.id.day_count);
        double difference = date - oldDate;
        double data1 = Math.floor(difference/86400000F);
        String diffDisplay = String.valueOf(data1);
        dayCount.setText(diffDisplay);
    }
}