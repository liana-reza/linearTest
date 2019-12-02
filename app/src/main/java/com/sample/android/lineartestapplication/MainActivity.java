package com.sample.android.lineartestapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cardJan, cardFeb, cardMar, cardApr, cardMay, cardJune, cardJuly, cardAug, cardSep, cardOct, cardNov, cardDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initClick();
    }

    private void initView() {
        cardJan = findViewById(R.id.cardJan);
        cardFeb = findViewById(R.id.cardFeb);
        cardMar = findViewById(R.id.cardMar);
        cardApr = findViewById(R.id.cardApr);
        cardMay = findViewById(R.id.cardMay);
        cardJune = findViewById(R.id.cardJune);
        cardJuly = findViewById(R.id.cardJuly);
        cardAug = findViewById(R.id.cardAug);
        cardSep = findViewById(R.id.cardSep);
        cardOct = findViewById(R.id.cardOct);
        cardNov = findViewById(R.id.cardNov);
        cardDec = findViewById(R.id.cardDec);

    }

    private void initClick() {
        cardJan.setOnClickListener(this);
        cardFeb.setOnClickListener(this);
        cardMar.setOnClickListener(this);
        cardApr.setOnClickListener(this);
        cardMay.setOnClickListener(this);
        cardJune.setOnClickListener(this);
        cardJuly.setOnClickListener(this);
        cardAug.setOnClickListener(this);
        cardSep.setOnClickListener(this);
        cardOct.setOnClickListener(this);
        cardNov.setOnClickListener(this);
        cardDec.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardJan:
                Toast.makeText(this, "January", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardFeb:
                Toast.makeText(this, "February", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardMar:
                Toast.makeText(this, "March", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardMay:
                Toast.makeText(this, "May", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardJune:
                Toast.makeText(this, "June", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardJuly:
                Toast.makeText(this, "July", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardAug:
                Toast.makeText(this, "August", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardSep:
                Toast.makeText(this, "September", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardOct:
                Toast.makeText(this, "October", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardNov:
                Toast.makeText(this, "November", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardDec:
                Toast.makeText(this, "December", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
