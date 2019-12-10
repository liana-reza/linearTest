package com.sample.android.lineartestapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtLastName, edtAge, edtAddress;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        click();
    }

    private void click() {
        btnSave.setOnClickListener(this);
    }

    private void initView() {
        edtName = findViewById(R.id.edtName);
        edtName.setText(PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_NAME, ""));
        edtLastName = findViewById(R.id.edtLastName);
        edtLastName.setText(PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_LASTNAME, ""));
        edtAge = findViewById(R.id.edtAge);
        edtAge.setText(PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_AGE, ""));
        edtAddress = findViewById(R.id.edtAddress);
        edtAddress.setText(PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_ADDRESS, ""));
        btnSave = findViewById(R.id.btnSave);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                Intent intent = new Intent(this, EditProfile.class);
                intent.putExtra(Const.TAG_NAME, edtName.getText().toString());
                intent.putExtra(Const.TAG_LASTNAME, edtLastName.getText().toString());
                intent.putExtra(Const.TAG_AGE, edtAge.getText().toString());
                intent.putExtra(Const.TAG_ADDRESS, edtAddress.getText().toString());
                startActivityForResult(intent, Const.TAG_PROFILE_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Const.TAG_PROFILE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit()
                        .putString(Const.TAG_NAME, edtName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit()
                        .putString(Const.TAG_LASTNAME, edtLastName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit()
                        .putString(Const.TAG_AGE, edtAge.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this).edit()
                        .putString(Const.TAG_ADDRESS,edtAddress.getText().toString()).apply();
                Toast.makeText(this, "Your information is saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
