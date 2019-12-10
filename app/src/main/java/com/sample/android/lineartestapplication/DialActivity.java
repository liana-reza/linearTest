package com.sample.android.lineartestapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DialActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtDialNumber;
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        initView();
    }

    private void initView() {
        edtDialNumber = findViewById(R.id.edtDialNumber);
        btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDial:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+edtDialNumber.getText().toString()));
                startActivity(intent);
                break;
        }
    }
}
