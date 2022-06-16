package com.example.fooddelivery1.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fooddelivery1.R;

public class ShowClock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_clock);
        getSupportActionBar().hide();
    }
}
