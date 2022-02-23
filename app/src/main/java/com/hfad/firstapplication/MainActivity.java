package com.hfad.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView day_count, best, last_clicked;
    private Button btn;
    private Date oldDate = null;
    private List<Integer> listOfDays = new ArrayList<>();
    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
    private int day_count_int;


    @Override
    public void onClick(View v) {
        last_clicked.setText(sdf.format(date));
        oldDate = date;
        try {
            listOfDays.add(Integer.parseInt(day_count.getText().toString().substring(6)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        day_count.setText("Days: 0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        day_count = findViewById(R.id.day_count);
        last_clicked = findViewById(R.id.last_clicked);
        best = findViewById(R.id.best);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        day_count.setText(differenceOfDays());
                        if(listOfDays.size() != 0) {
                            best.setText("Best: " + String.valueOf(Collections.max(listOfDays)));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 1000);

    }

    public String differenceOfDays() throws ParseException {
        if(oldDate == null) {
           return "Days: 0";
        }
        long diff = date.getTime() - oldDate.getTime();
        return ("Days: " + (TimeUnit.MILLISECONDS.toDays(diff)));
    }
}