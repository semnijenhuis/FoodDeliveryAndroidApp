package com.example.fooddelivery1.Activitys.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.fooddelivery1.R;
import com.example.fooddelivery1.Activitys.ShowClock;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Home extends Fragment {

    private TextView textView;
    private FloatingActionButton button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textView = (TextView) root.findViewById(R.id.date);
        button = root.findViewById(R.id.homeTimerDrawButton);

        textView.setText(date());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShowClock.class);
                startActivity(intent);
            }
        });
        return root;
    }

    public String date() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}