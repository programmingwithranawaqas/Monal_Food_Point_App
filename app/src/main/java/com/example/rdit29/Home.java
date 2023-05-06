package com.example.rdit29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity  implements listFrag.ContactSelected {

    TextView tvDetail;

    ArrayList<String> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvDetail = getSupportFragmentManager().findFragmentById(R.id.fdetailfrag).getView().findViewById(R.id.tvDetail);


        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");

        tvDetail.setText(numbers.get(0));

    }


    @Override
    public void contactClick(int index) {
        tvDetail.setText(numbers.get(index));
    }
}