package com.sample.android.lineartestapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    TextView txtName,txtLastName,txtAddress,txtAge;
    Button btnSave,btnEdit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        intent = getIntent();
        initView();
        click();
    }

    private void click() {
        btnSave.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
    }

    private void initView() {
        txtName = findViewById(R.id.txtName);
        txtName.setText(intent.getStringExtra(Const.TAG_NAME));
        txtLastName = findViewById(R.id.txtLastName);
        txtLastName.setText(intent.getStringExtra(Const.TAG_LASTNAME));
        txtAddress = findViewById(R.id.txtAddress);
        txtAddress.setText(intent.getStringExtra(Const.TAG_ADDRESS));
        txtAge = findViewById(R.id.txtAge);
        txtAge.setText(intent.getStringExtra(Const.TAG_AGE));
        btnSave =findViewById(R.id.btnSave);
        btnEdit =findViewById(R.id.btnEdit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdit:
                finish();
                break;
            case R.id.btnSave:
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",intent.getExtras());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

        }
    }
}
