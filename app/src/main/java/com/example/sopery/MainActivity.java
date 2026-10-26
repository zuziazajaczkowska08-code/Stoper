package com.example.sopery;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int seconds=0;
    private boolean running;
    TextView tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            tekst = findViewById(tekst);
            runTimer();
            return insets;
        });

    }
    public void onStart(View view){
        running=true;
    }
    public void onStop(View view){
        running=false;
    }
    public void onClear(View view){
        running=false;
        running=0;
    }
    public void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours= seconds/3600;
                int minutes= (seconds/3600)/60;
                int sec = seconds%60;
                String time = String.format("%d%02d%02d" , hours,minutes,sec);
                tekst.setText(time);

                if (running){
                    seconds++;
                }
                handler.postDelayed(this, delayMillis:1000)

            }
        }){

        }
}
}